package it.uniroma3.diadia;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.CaricatoreLabirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.*;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 * 
 * Questa e' la classe principale crea e istanzia tutte le altre
 * 
 * @author Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public class DiaDia {
	private Partita partita;

	public DiaDia() throws FileNotFoundException, FormatoFileNonValidoException {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;
		partita.stampaMessaggioIniziale();
		this.partita.interfacciaUtenteConsole.mostraMessaggio("\n"+this.partita.getStanzaCorrente().getDescrizione()+"\n");
		this.partita.interfacciaUtenteConsole.mostraMessaggio("_________________________________________________");
		do {
			istruzione = this.partita.interfacciaUtenteConsole.prendiIstruzione();
		} while (!processaIstruzione(istruzione));
	}

	/**
	 * Processa una istruzione
	 * 
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		AbstractComando comandoDaEseguire; 
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione); 
		this.partita.interfacciaUtenteConsole.mostraMessaggio(comandoDaEseguire.esegui(this.partita)); 
		if (this.partita.vinta()) 
			this.partita.interfacciaUtenteConsole.mostraMessaggio("Hai vinto!"); 
		if (this.partita.giocatoreIsVivo()) 
			this.partita.interfacciaUtenteConsole.mostraMessaggio("Hai esaurito i CFU..."); 
		return this.partita.isFinita();
	}
	
	public static void main(String[] args) throws FileNotFoundException, FormatoFileNonValidoException {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
	
	
	
	
	
}