package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaMagicaTest {
	private StanzaMagicaProtected stanzaMagica;
	private Attrezzo spada;
	private Attrezzo osso;
	private Attrezzo pala;
	private Attrezzo martello;
	private Partita partita;
	@Before
	
	public void setUp() throws Exception {
		this.osso=new Attrezzo("osso", 2);
		this.pala=new Attrezzo("pala",3);
		this.spada=new Attrezzo("spada", 1);
		this.martello=new Attrezzo("martello",3);
		
		this.stanzaMagica=new StanzaMagicaProtected("mensa");
		this.partita=new Partita();
		this.partita.setStanzaCorrente(stanzaMagica);
	}
	
	@Test
	public void addAttrezzo() {
		this.stanzaMagica.addAttrezzo(martello);
		assertTrue(this.stanzaMagica.attrezzi.contains(martello));
	}

	@Test
	public void testModificaAttrezzo() {
		this.stanzaMagica.addAttrezzo(osso);
		this.stanzaMagica.addAttrezzo(pala);
		this.stanzaMagica.addAttrezzo(spada);
		this.stanzaMagica.addAttrezzo(martello);
		assertEquals("olletram (6kg)  ",this.partita.getStanzaCorrente().getAttrezzo("olletram").toString());
	}

}
