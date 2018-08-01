package it.uniroma3.diadia.personaggi;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega  extends AbstractPersonaggio{
	private static final String MESSAGGIO_Positivo = "ti trasferisco nella stanza con maggior numero di attrezzi"; 
	private static final String MESSAGGIO_Negativo = "Mi spiace, ti trasferisco nella stanza con minor numero di attrezzi..."; 
	private static final String comportamentoStrega="WUAHAHAHAHAHAH";
	private Attrezzo attrezzo;
	
	public Strega(String nome, String presentaz,Attrezzo attrezzo) {
		super(nome, presentaz);
		this.attrezzo=attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		
		List<Stanza> lista=TutteStanzeAdiacenti(partita);
		int numeroAttrezzi=0;
		for(Stanza a : lista){
			if(this.haSalutato()){
				if(a.getNumeroAttrezzi()>numeroAttrezzi){
					numeroAttrezzi=a.getNumeroAttrezzi();

					partita.setStanzaCorrente(a);
				}
			}
			else{
				if(a.getNumeroAttrezzi()<=numeroAttrezzi){
					numeroAttrezzi=a.getNumeroAttrezzi();
					partita.setStanzaCorrente(a);
				}
			}
		}
		String msg=MESSAGGIO_Negativo;
		if(this.haSalutato()){
			msg=this.MESSAGGIO_Positivo;
		}
		return msg;
	}

	private List<Stanza> TutteStanzeAdiacenti(Partita partita) {
		List<Stanza> lista=new ArrayList<Stanza>();
		for(String direzione : partita.getStanzaCorrente().getDirezioni()){
			if(direzione!=null){
				lista.add(partita.getStanzaCorrente().getStanzaAdiacente(direzione));
			}
		}
		return lista;
	}
	
	public void setAttrezzo(Attrezzo attrezzo) {
		this.attrezzo = attrezzo;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		this.setAttrezzo(attrezzo);
		return this.comportamentoStrega;
	}
}
