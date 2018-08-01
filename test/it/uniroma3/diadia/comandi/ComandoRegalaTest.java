package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

import org.junit.Before;
import org.junit.Test;

public class ComandoRegalaTest {
	private ComandoRegala comando;
	private Partita partita;
	

	@Before
	public void setUp() throws Exception {
		this.comando=new ComandoRegala();
		this.partita=new Partita();
	}

	

	@Test
	public void testEseguiStrega() {
		Strega personaggio=new Strega("strega", "male", new Attrezzo("scopa",2));		
		this.partita.getStanzaCorrente().setPersonaggio(personaggio);
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("bastone",2));
		this.comando.setParametro("bastone");
		assertEquals("WUAHAHAHAHAHAH", this.comando.esegui(partita));
		assertEquals("Borsa vuota" ,this.partita.getGiocatore().getBorsa().toString());
	}
	
	@Test
	public void testEseguiCane() {
		Cane personaggio=new Cane("cane", "bau", new Attrezzo("collare",2));		
		this.partita.getStanzaCorrente().setPersonaggio(personaggio);
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("chiave",2));
		this.comando.setParametro("chiave");	
		assertEquals("ble", this.comando.esegui(partita));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("chiave"));
		
		this.comando.setParametro("osso");
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("osso",2));
		assertEquals("gnam gnam", this.comando.esegui(partita));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("collare"));
	}
	
	@Test
	public void testEseguiMago() {
		Mago personaggio=new Mago("mago", "magia", new Attrezzo("bastone",2));		
		this.partita.getStanzaCorrente().setPersonaggio(personaggio);
		this.partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("spada",6));
		this.comando.setParametro("spada");
		assertEquals("abracadabra", this.comando.esegui(partita));
		assertTrue(this.partita.getStanzaCorrente().getAttrezzo("spada").getPeso()==3);
	}
}

