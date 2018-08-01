package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.Iterator;

public class StanzaBuia extends Stanza{
	private String nomeAttrezzo;
	
	public StanzaBuia(String nome,String nomeAttrezzo){
		super(nome);
		this.nomeAttrezzo=nomeAttrezzo;
	}
	
	public String getDescrizione(){
		String s="qui c'è un buio pesto";
		Iterator <Attrezzo> iteratore=this.attrezzi.iterator();
		while(iteratore.hasNext()){
			if(iteratore.next().getNome().equals(this.nomeAttrezzo))
				return  super.getDescrizione();
		}
		return s;
	}
	
	public void setNomeAttrezzo(String that){
		this.nomeAttrezzo=that;
	}
}
