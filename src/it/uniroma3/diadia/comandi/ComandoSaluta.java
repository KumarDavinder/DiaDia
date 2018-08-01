package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando{

	 @Override 
	 public String esegui(Partita partita) { 
		 AbstractPersonaggio personaggio; 
		 personaggio = partita.getStanzaCorrente().getPersonaggio(); 
		 if(personaggio!=null){
			 return personaggio.saluta(); 

		 }
		 else{
			 return "non c'è nessun personaggio in questa stanza";
		 }
	 } 
}
