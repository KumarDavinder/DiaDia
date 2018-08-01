package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.CaricatoreLabirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto{
	private CaricatoreLabirinto a;
	 private static final String MESSAGGIO_BENVENUTO = 
				"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
				"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
				"I locali sono popolati da strani personaggi, " +
				"alcuni amici, altri... chissa!\n"+
				"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
				"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
				"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
				"Per conoscere le istruzioni usa il comando 'aiuto'.";
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	//inserire qui il percorso del file
	private static final String PERCORSO_FILE="/Users/Davinder/Documents/ProgrammiJava/DiaDia/src/it/uniroma3/diadia/stanze.txt"; 

	  /**
     * Crea tutte le stanze e le porte di collegamento
	 * @throws FileNotFoundException 
	 * @throws FormatoFileNonValidoException 
     */
	public Labirinto() throws FileNotFoundException, FormatoFileNonValidoException{
		this.a=new CaricatoreLabirinto(PERCORSO_FILE);
		creaStanze();	
	}
    private void creaStanze() throws FormatoFileNonValidoException {
    	this.a.carica();

		this.stanzaCorrente=a.getStanzaIniziale();
		this.stanzaVincente=a.getStanzaVincente();
    }
    public String getaMessaggioIniziale(){
    	return MESSAGGIO_BENVENUTO;
    }
    public Stanza getStanzaCorrente(){
		return stanzaCorrente;
	}
	public Stanza getStanzaVincente(){
		return stanzaVincente;
	}
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
}
