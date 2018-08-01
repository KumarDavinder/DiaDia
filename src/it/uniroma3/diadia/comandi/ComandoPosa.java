package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoPosa extends AbstractComando{
	
	public String esegui(Partita partita){
		StringBuilder s=new StringBuilder();
		if(partita.getStanzaCorrente().getNumeroAttrezzi()<partita.getStanzaCorrente().getMassimoAttrezzi()){
			for (int i = 0; i < partita.getGiocatore().getBorsa().getAttrezzi().length; ++i) {
				if (partita.getGiocatore().getBorsa().getAttrezzi()[i] != null)
					if (partita.getGiocatore().getBorsa().getAttrezzi()[i].getNome().equals(this.parametro)) {
						partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().removeAttrezzo(this.parametro));
						s.append("Attrezzo posato nella stanza\n");
						s.append("\n"+partita.getStanzaCorrente().getDescrizione()+"\n\n");
						s.append("_________________________________________________");
						return s.toString();
					}
			}
			s.append("\nAttrezzo non prensente in borsa");
		}
		else if(partita.getStanzaCorrente().getNumeroAttrezzi()>=partita.getStanzaCorrente().getMassimoAttrezzi()){
			s.append("\nStanza piena");
		}
		return s.toString();
	}
}
