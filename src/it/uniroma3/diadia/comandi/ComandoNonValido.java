package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoNonValido extends AbstractComando{
	
	public String esegui(Partita partita){
		return "comando non valido";
	}
}
