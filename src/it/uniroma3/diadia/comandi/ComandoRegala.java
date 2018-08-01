package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{

	@Override
	public String esegui(Partita partita) {
		StringBuilder s=new StringBuilder();
		if(partita.getGiocatore().getBorsa().getListaAttrezzi().contains(new Attrezzo(this.parametro,-1))){
			Attrezzo attrezzoDaRegalare=partita.getGiocatore().getBorsa().removeAttrezzo(this.parametro);
			s.append(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzoDaRegalare, partita));
		}
		else{
			s.append("attrezzo non presente in borsa");
		}
		return s.toString();
	}

}
