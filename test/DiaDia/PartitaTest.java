package DiaDia;

import static org.junit.Assert.*;

import it.uniroma3.diadia.Partita;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		this.partita=new Partita();
	}

	@Test
	public void testGetStanzaVincente(){
		assertTrue("biblioteca".equals(this.partita.getStanzaVincente().getNome()));
	}

	@Test
	public void testGetStanzaCorrente() {
		Scanner Corrente;
	    Corrente = new Scanner(this.partita.getStanzaCorrente().getDescrizione());	
		assertEquals("atrio",Corrente.next());
	}
	@Test
	public void testgetCfu() {
		assertEquals(20,partita.getGiocatore().getCfu());
	}
}
