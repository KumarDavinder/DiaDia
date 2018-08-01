package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StanzaBuiaTest {
	private StanzaBuia stanzaBuia;
	private Attrezzo lampada;
	@Before
	public void setUp() throws Exception {
		this.stanzaBuia=new StanzaBuia("Ds2","lampada");
		this.lampada=new Attrezzo("lampada",1);

	}

	@Test
	public void testStanzaBuia() {
		assertEquals("qui c'è un buio pesto", this.stanzaBuia.getDescrizione());
		this.stanzaBuia.addAttrezzo(this.lampada);
		assertEquals("Ds2\nUscite: \nAttrezzi nella stanza: lampada (1kg)  ", this.stanzaBuia.getDescrizione());
	}
}
