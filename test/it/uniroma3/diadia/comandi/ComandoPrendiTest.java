package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class ComandoPrendiTest {
	private ComandoPrendi comando;
	private Partita partita;
	private Attrezzo spada;

	@Before
	public void setUp() throws Exception {
		this.comando=new ComandoPrendi();
		this.partita=new Partita();
		this.spada=new Attrezzo("spada",5);
		this.partita.getStanzaCorrente().addAttrezzo(spada);
		this.comando.setParametro("spada");
	}

	@Test
	public void testPrendi() {
		this.comando.esegui(partita);
		
		//verifica se l'attrezzo è stato aggiunto in borsa
		
		boolean k=true;
		for(int i=0;i<this.partita.getGiocatore().getBorsa().getAttrezzi().length && k;i++){
			if(this.partita.getGiocatore().getBorsa().getAttrezzi()[i]==null){
				fail();
			}
			else if(this.partita.getGiocatore().getBorsa().getAttrezzi()[i].getNome().equals("spada"))
				k=false;
		}
		if(k==true){
			fail();
		}
		
		
		//verifica se l'attrezzo è stato tolto dalla stanza corrente
		
		for(int i=0;i<this.partita.getStanzaCorrente().getAttrezzi().length;i++){
			if(this.partita.getStanzaCorrente().getAttrezzi()[i]!=null)
				if(this.partita.getStanzaCorrente().getAttrezzi()[i].getNome().equals("spada"))
					fail();
		}
	}
}
