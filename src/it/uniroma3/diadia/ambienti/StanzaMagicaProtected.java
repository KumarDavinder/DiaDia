package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaMagicaProtected extends Stanza {
	final static private int SOGLIA_DEFAULT = 3;
	private int sogliaMagica;

	public StanzaMagicaProtected(String nome) {
		super(nome);
		this.sogliaMagica = SOGLIA_DEFAULT;
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) { 
		 StringBuilder nomeInvertito; 
		 int pesoDoppio = attrezzo.getPeso()*2; 
		 nomeInvertito = new StringBuilder(attrezzo.getNome()); 
		 nomeInvertito = nomeInvertito.reverse(); 
		 attrezzo = new Attrezzo(nomeInvertito.toString(),pesoDoppio); 
		 return attrezzo; 
	} 
	
	public boolean addAttrezzo(Attrezzo attrezzo) { 
		 if (this.attrezzi.size() >= this.sogliaMagica) {
			 attrezzo = this.modificaAttrezzo(attrezzo); 
		} 
		 return super.addAttrezzo(attrezzo);
	}
}
