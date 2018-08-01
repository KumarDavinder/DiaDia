package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.ambienti.ComparatorePerPeso;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;
	
	public Borsa() {
		this.attrezzi = new ArrayList<>();
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		return this.attrezzi.add(attrezzo);
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo appoggio=new Attrezzo(nomeAttrezzo,-1);
		int indiceAttrezzoCercato=this.attrezzi.indexOf(appoggio);
		return this.attrezzi.get(indiceAttrezzoCercato);
	}
	
	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iteratore=this.attrezzi.iterator();
		Attrezzo appoggio;
		while(iteratore.hasNext()){
			appoggio=iteratore.next();
			peso += appoggio.getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.size() == 0;

	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo appoggio=new Attrezzo(nomeAttrezzo,-1);
		int indiceAttrezzoCercato=this.attrezzi.indexOf(appoggio);
		return this.attrezzi.remove(indiceAttrezzoCercato);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa (peso totale:  " + this.getPeso() + "kg   peso max: "+ this.getPesoMax() + "kg): \n");
			s.append(this.getContenutoOrdinatoPerNome().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public Attrezzo[] getAttrezzi(){
		return this.attrezzi.toArray(new Attrezzo[0]);
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ComparatorePerPeso comparaPerPeso=new ComparatorePerPeso();
		Collections.sort(this.attrezzi, comparaPerPeso);
		return this.attrezzi;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerNome(){
		Collections.sort(this.attrezzi);
		return this.attrezzi;
	}
	
	public List<Attrezzo >getListaAttrezzi(){
		return this.attrezzi;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> mappa=new HashMap<Integer,Set<Attrezzo>>(); // creo la mappa
		Set<Integer> listaKey= pesi();
		Iterator<Integer> ik=listaKey.iterator();
		Set<Attrezzo> listaAttrezzi;
		Integer app;
		while(ik.hasNext()){
			app=ik.next();
			listaAttrezzi=toList(app);
			mappa.put(app, listaAttrezzi);
		}
		return mappa;
	}
	private Set<Integer> pesi(){
		Set<Integer> r=new HashSet<>();
		Iterator<Attrezzo> it= this.attrezzi.iterator();
		while(it.hasNext()){
			r.add(it.next().getPeso());
		}
		return r;
	}
	private Set<Attrezzo> toList(int x){
		Iterator<Attrezzo> i= this.attrezzi.iterator();
		Set<Attrezzo> r=new HashSet<>();
		Attrezzo t;
		while(i.hasNext()){
			t=i.next();
			if(t.getPeso()==x){
				r.add(t);
			}
		}
		return r;
	}
}

















