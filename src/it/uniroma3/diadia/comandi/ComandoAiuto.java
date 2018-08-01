package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoAiuto extends AbstractComando{
	private static String[] elencoComandi = { "vai", "aiuto", "fine" };
	
	public String esegui(Partita partita) {
		StringBuilder s=new StringBuilder();
		for (int i = 0; i < this.elencoComandi.length; i++)
			s.append(elencoComandi[i] + " ");
		s.append("\n");
		return s.toString();
	}
}
