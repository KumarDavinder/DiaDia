package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoGuarda extends AbstractComando{
	
	public String esegui(Partita partita){
		return partita.getStanzaCorrente().toString();
	}
}
