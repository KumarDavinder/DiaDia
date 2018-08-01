package it.uniroma3.diadia.giocatore;

public class Giocatore {
	private int cfu;
	private static int CFU_INIZIALI = 20;
	private Borsa borsa;

	public Giocatore(){
		this.cfu = CFU_INIZIALI;
		borsa=new Borsa();
	}
	
	public int getCfu(){
		return this.cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public Borsa getBorsa(){
		return this.borsa;
	}

}
