package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.Comparator;

public class ComparatorePerPeso implements Comparator<Attrezzo>{
	public int compare(Attrezzo a1,Attrezzo a2){
		return a1.getPeso() - a2.getPeso(); 
	}
}
