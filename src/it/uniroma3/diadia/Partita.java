package it.uniroma3.diadia;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and David J. Barnes)
 * @see Stanza
 * @version 0.1
 */

public class Partita {
	private boolean finita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	protected InterfacciaUtente interfacciaUtenteConsole;

	public Partita() throws FileNotFoundException, FormatoFileNonValidoException{
		this.finita = false;
		this.giocatore=new Giocatore();
		this.labirinto=new Labirinto();
		this.interfacciaUtenteConsole=new InterfacciaUtenteConsole();
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
	public void stampaMessaggioIniziale(){
		this.interfacciaUtenteConsole.mostraMessaggio(labirinto.getaMessaggioIniziale());
	}

	
	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaVincente();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		labirinto.setStanzaCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return this.labirinto.getStanzaCorrente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}
	
	public boolean giocatoreIsVivo(){
		return (this.giocatore.getCfu()==0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public void setCfu(int cfu) {
		this.giocatore.setCfu(cfu);
	}	
	
	public Giocatore getGiocatore(){
		return this.giocatore;
	}
}
