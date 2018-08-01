
package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoPrendi extends AbstractComando{
	
	public String esegui(Partita partita){
		StringBuilder s=new StringBuilder();
		for (int i = 0; i < partita.getStanzaCorrente().getAttrezzi().length; i++) {
			if ((partita.getStanzaCorrente().getAttrezzi()[i] != null)){
				if (partita.getStanzaCorrente().getAttrezzi()[i].getNome().equals(this.parametro)) {
					if(partita.getGiocatore().getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzi()[i])){
						s.append("\nAttrezzo aggiunto in borsa");
						partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzi()[i]);
						s.append("\n\n"+partita.getStanzaCorrente().getDescrizione()+"\n");
						s.append("\n_________________________________________________");
						return s.toString();
					}
					else 
						return ("Borsa Piena o sttrezzo molto pesante");
				}
			}
		}
		return("\nAttrezzo non presente");
	}

}
