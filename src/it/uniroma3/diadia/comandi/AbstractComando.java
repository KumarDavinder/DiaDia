package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {
	protected String parametro;

	public abstract String esegui(Partita partita);
	
	public void setParametro(String parametro){
		this.parametro=parametro;
	}
}
