package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando{
		
	public String esegui(Partita partita){
		Stanza stanzaCorrente = partita.getStanzaCorrente(); 

		Stanza prossimaStanza = null; 
		if (parametro==null) { 
			return("\nDove vuoi andare? Devi specificare una direzione"); 
		} 
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.parametro); 
		if (prossimaStanza==null) { 
			return("\nDirezione inesistente"); 
		} 
		partita.setStanzaCorrente(prossimaStanza); 
		StringBuilder s=new StringBuilder();
		s.append("\n\n"+partita.getStanzaCorrente().toString()+"\n"); 
		s.append("\n_________________________________________________");
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return s.toString();
	}
}