package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	private static final String msg="Il mio morso ti fa perdere un cfu";
	private static final String nomeAttrezzoPreferito="osso";

	private Attrezzo attrezzo;
	
	public Cane(String nome, String presentaz,Attrezzo attrezzo) {
		super(nome, presentaz);
		this.attrezzo=attrezzo;
	}

	
	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return msg;
	}
	
	public void setAttrezzo(Attrezzo attrezzo) {
		this.attrezzo = attrezzo;
	}


	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder s=new StringBuilder();
		if(attrezzo.getNome().equals(this.nomeAttrezzoPreferito)){
			s.append("gnam gnam");
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.setAttrezzo(attrezzo);
		}
		else{
			s.append("ble");
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
		}
		return s.toString();
	}
}
