package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo. Una stanza e' un luogo
 * fisico nel gioco. E' collegata ad altre stanze attraverso delle uscite. Ogni
 * uscita e' associata ad una direzione.
 * 
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J.
 *         Barnes)
 * @see Attrezzo
 * @version 0.1
 */

public class Stanza {
	private static final int NUMERO_MASSIMO_ATTREZZI = 10;
	private String nome;
	protected List <Attrezzo> attrezzi;
	private Map<String, Stanza> stanzeAdiacenti;
	private AbstractPersonaggio personaggio; 


	 public void setPersonaggio(AbstractPersonaggio personaggio) { 
		 this.personaggio = personaggio; 
	 } 

	 public AbstractPersonaggio getPersonaggio() { 
		 return this.personaggio; 
	 }
	
	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * 
	 * @param nome
	 *            il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<String, Stanza>();
		this.attrezzi = new ArrayList<>();
	}

	/**
	 * Imposta una stanza adiacente.
	 * 
	 * @param direzione
	 *            direzione in cui sara' posta la stanza adiacente.
	 * @param stanza
	 *            stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		this.stanzeAdiacenti.put(direzione, stanza);
	}
	
	public Stanza getStanzaCorrente(){
		return this;
	}
	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * 
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la nome della stanza.
	 * 
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * 
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}
	
	public int getMassimoAttrezzi() {
		return this.NUMERO_MASSIMO_ATTREZZI;
	}
	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * 
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Attrezzo[] getAttrezzi() {
		return this.attrezzi.toArray(new Attrezzo[0]);
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * 
	 * @param attrezzo
	 *            l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI)
			return this.attrezzi.add(attrezzo);
		return false;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza, stampadone la
	 * descrizione, le uscite e gli eventuali attrezzi contenuti
	 * 
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		boolean b=false;
		String s = new String();
		s += this.nome;
		s += "\nUscite: ";
		String [] direzioni=this.stanzeAdiacenti.keySet().toArray(new String[0]);
		for (String elemento : direzioni) 
				s += elemento + " ";
		s += "\nAttrezzi nella stanza: ";
		Iterator <Attrezzo> iteratore=this.attrezzi.iterator();
		while(iteratore.hasNext()){
			s+=iteratore.next().toString();
			b=true;
		}
		if(!b)
			s+=" nessuno";
		return s;
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * 
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.contains(new Attrezzo(nomeAttrezzo,-1));
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * 
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza. null se l'attrezzo non e'
	 *         presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(this.attrezzi.indexOf(new Attrezzo(nomeAttrezzo,-1)));
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * 
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo);
	}

	public String[] getDirezioni() {
		return this.stanzeAdiacenti.keySet().toArray(new String[0]);
	}
}