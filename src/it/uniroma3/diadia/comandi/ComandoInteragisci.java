package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando{
	private String messaggio; 

	 @Override 
	 public String esegui(Partita partita) { 
		 AbstractPersonaggio personaggio; 
		 personaggio = partita.getStanzaCorrente().getPersonaggio(); 
		 if(personaggio!=null){
			 this.messaggio = personaggio.agisci(partita); 
			 return this.messaggio; 
		 }
		 else{
			 return "non c'è nessun personaggio in questa stanza";
		 }
	 } 

	 public String getMessaggio() { 
	 return this.messaggio; 
	 } 
}
