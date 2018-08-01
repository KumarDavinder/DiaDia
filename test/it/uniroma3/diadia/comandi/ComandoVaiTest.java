package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {
	private ComandoVai comando;
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		this.comando=new ComandoVai();
		this.partita=new Partita();
		comando.setParametro("nord");
	}

	@Test
	public void testComandoVai() {
		this.comando.esegui(partita);
		assertEquals("biblioteca",this.partita.getStanzaCorrente().getNome());
	}
}
