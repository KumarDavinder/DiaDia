package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.io.*;
import java.util.*;

public class CaricatoreLabirinto {

	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
	private static final String STANZE_MARKER = "Stanze:";             

	/* prefisso di una singola riga contenente il nome della stanza iniziale */
	private static final String STANZA_INIZIALE_MARKER = "Inizio:";    

	/* prefisso della riga contenente il nome stanza vincente */
	private static final String STANZA_VINCENTE_MARKER = "Vincente:";  

	/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeAttrezzo> <peso> <nomeStanza> */
	private static final String ATTREZZI_MARKER = "Attrezzi:";

	/* prefisso della riga contenente le specifiche dei collegamenti tra stanza nel formato <nomeStanzaDa> <direzione> <nomeStanzaA> */
	private static final String USCITE_MARKER = "Uscite:";

	/*
	 *  Esempio di un possibile file di specifica di un labirinto (vedi POO-26-eccezioni-file.pdf)

		Stanze: biblioteca, N10, N11
		Inizio: N10
		Vincente: N11
		Attrezzi: martello 10 biblioteca, pinza 2 N10
		Uscite: biblioteca nord N10, biblioteca sud N11

	 */
	private LineNumberReader reader;

	private Map<String, Stanza> nome2stanza;

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;


	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this.nome2stanza = new HashMap<String,Stanza>();
		this.reader = new LineNumberReader(new FileReader(nomeFile));
	}

	public void carica() throws FormatoFileNonValidoException {
		try {
			this.leggiECreaStanze();
			this.leggiInizialeEvincente();
			this.leggiECollocaAttrezzi();
			this.leggiEImpostaUscite();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	public String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = this.reader.readLine();
			check(riga.startsWith(marker),"era attesa una riga che cominciasse per "+marker);
			return riga.substring(marker.length()).trim();
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}

	//funziona
	private void leggiECreaStanze() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
		for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			Stanza stanza = new Stanza(nomeStanza);
			this.nome2stanza.put(nomeStanza, stanza);
		}
	}
	
	//funziona
	public List<String> separaStringheAlleVirgole(String string) {
		List<String> result = separa(string);
		/*Scanner scanner = new Scanner(string);
		scanner.useDelimiter(",");
		try (Scanner scannerDiParole = scanner) {
			result.add(scannerDiParole.next());
		}*/
		return result;
	}
	
	private List<String> separa(String s){
		List<String> r=new LinkedList<>();
		String t="";
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!=',' && s.charAt(i)!=' '){
				t+=s.charAt(i);
			}
			else if(s.charAt(i)==','){
				r.add(t);
				t="";
			}
		}
		r.add(t);
		return r;
	}
	private String[] separaAiTrattini(String s){
		String[] r=new String[3];
		String t="";
		int j=0;
		for(int i=0;i<s.length() && j<3;i++){
			if(s.charAt(i)!='-' && s.charAt(i)!=' '){
				t+=s.charAt(i);
			}
			else if(s.charAt(i)=='-'){
				r[j]=t;
				j++;
				t="";
			}
		}
		r[2]=t;
		return r;
	}


	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);
		check(this.isStanzaValida(nomeStanzaIniziale), nomeStanzaIniziale +" non definita");
		String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);
		check(this.isStanzaValida(nomeStanzaVincente), nomeStanzaVincente + " non definita");
		this.stanzaIniziale = this.nome2stanza.get(nomeStanzaIniziale);
		this.stanzaVincente = this.nome2stanza.get(nomeStanzaVincente);
	}

	private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);

		for(String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
			String[]r=separaAiTrattini(specificaAttrezzo);
			String nomeAttrezzo = r[0];
			String pesoAttrezzo = r[1];
			String nomeStanza = r[2]; 
//			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
//				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un attrezzo."));
//				nomeAttrezzo = scannerLinea.next();
//				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso dell'attrezzo "+nomeAttrezzo+"."));
//				pesoAttrezzo = scannerLinea.next();
//				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare l'attrezzo "+nomeAttrezzo+"."));
//				nomeStanza = scannerLinea.next();
//			}
			posaAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
		}
	}

	private void posaAttrezzo(String nomeAttrezzo, String pesoAttrezzo, String nomeStanza) throws FormatoFileNonValidoException {
		int peso;
		try {
			peso = Integer.parseInt(pesoAttrezzo);
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			check(isStanzaValida(nomeStanza),"Attrezzo "+ nomeAttrezzo+" non collocabile: stanza " +nomeStanza+" inesistente");
			this.nome2stanza.get(nomeStanza).addAttrezzo(attrezzo);
		}
		catch (NumberFormatException e) {
			check(false, "Peso attrezzo "+nomeAttrezzo+" non valido");
		}
	}


	private boolean isStanzaValida(String nomeStanza) {
		return this.nome2stanza.containsKey(nomeStanza);
	}

	private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
		String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);

		for(String specificaUscita : separaStringheAlleVirgole(specificheUscite)) {
			String[]r=separaAiTrattini(specificaUscita);
			String stanzaCorrente = r[0];
			String direzione = r[1];
			String stanzaAdiacente = r[2]; 
//			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
//				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un attrezzo."));
//				nomeAttrezzo = scannerLinea.next();
//				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso dell'attrezzo "+nomeAttrezzo+"."));
//				pesoAttrezzo = scannerLinea.next();
//				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare l'attrezzo "+nomeAttrezzo+"."));
//				nomeStanza = scannerLinea.next();
//			}
			impostaUscita(stanzaCorrente, direzione, stanzaAdiacente);
		}
	}
	
	private String msgTerminazionePrecoce(String msg) {
		return "Terminazione precoce del file prima di leggere "+msg;
	}

	private void impostaUscita(String stanzaDa, String dir, String nomeA) throws FormatoFileNonValidoException {
		check(isStanzaValida(stanzaDa),"Stanza di partenza sconosciuta "+dir);
		check(isStanzaValida(nomeA),"Stanza di destinazione sconosciuta "+ dir);
		Stanza partenzaDa = this.nome2stanza.get(stanzaDa);
		Stanza arrivoA = this.nome2stanza.get(nomeA);
		partenzaDa.impostaStanzaAdiacente(dir, arrivoA);
	}


	final private void check(boolean condizioneCheDeveEsseraVera, String messaggioErrore) throws FormatoFileNonValidoException {
		if (!condizioneCheDeveEsseraVera)
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.reader.getLineNumber() + "] "+messaggioErrore);		
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	public Map<String, Stanza> getNome2stanza() {
		return nome2stanza;
	}
}