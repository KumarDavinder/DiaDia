package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.Partita;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class ComandoPosaTest {
	private ComandoPosa comando;
	private Partita partita;
	private Attrezzo spada;
	
	@Before
	public void setUp() throws Exception {
		this.comando=new ComandoPosa();
		this.partita=new Partita();
		this.spada=new Attrezzo("spada",3);
		this.partita.getGiocatore().getBorsa().addAttrezzo(spada);
		this.comando.setParametro("spada");
	}

	@Test
	public void testComandoPosa() {
		this.comando.esegui(partita);
		
		//verifica se l'attrezzo settato è stato aggiunto in stanza

		boolean k=true;
		for(int i=0; i<this.partita.getStanzaCorrente().getAttrezzi().length && k;i++){
			if(this.partita.getStanzaCorrente().getAttrezzi()[i]==null )
				fail();
			else if(this.partita.getStanzaCorrente().getAttrezzi()[i].getNome().equals("spada"))
				k=false;
		}	
		if(k==true){
			fail();
		}
		
		//verifica se l'attrezzo è stato rimosso dalla borsa
		
		for(int i=0; i<this.partita.getGiocatore().getBorsa().getAttrezzi().length;i++){
			if(this.partita.getGiocatore().getBorsa().getAttrezzi()[i]!=null)
				if(this.partita.getGiocatore().getBorsa().getAttrezzi()[i].getNome().equals("slada"))
					fail();
			}
		}	
}
