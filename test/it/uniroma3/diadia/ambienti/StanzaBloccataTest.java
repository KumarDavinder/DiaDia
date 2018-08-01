package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.Partita;

import org.junit.Before;
import org.junit.Test;


public class StanzaBloccataTest {
	private ComandoVai comando;
	private Partita partita;
	private StanzaBloccata stanzaBloccata;
	@Before
	public void setUp() throws Exception {
		this.partita=new Partita();
		this.comando=new ComandoVai();
		this.stanzaBloccata=new StanzaBloccata("ds1", "nord", "osso");
	}

	@Test
	public void testGetStanzaAdiacente() {
		this.comando.setParametro("nord");
		this.partita.setStanzaCorrente(stanzaBloccata);
		Stanza biblioteca=new  Stanza("Biblioteca");
		this.stanzaBloccata.impostaStanzaAdiacente("nord", biblioteca);
		this.comando.esegui(partita);
		assertEquals("ds1",this.partita.getStanzaCorrente().getNome() );
		Attrezzo osso=new Attrezzo("osso", 2);
		this.stanzaBloccata.addAttrezzo(osso);
		this.comando.esegui(partita);
		assertEquals("Biblioteca",this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGetStanzaCorrente(){
		assertEquals(stanzaBloccata,this.stanzaBloccata.getStanzaCorrente());
	}
	
	@Test
	public void testGetNomeAttrezzo() {
		assertEquals("osso", this.stanzaBloccata.getNomeAttrezzo());
	}
	
	@Test
	public void testSetNomeAttrezzo() {
		this.stanzaBloccata.setNomeAttrezzo("pala");
		assertEquals("pala", this.stanzaBloccata.getNomeAttrezzo());
	}
}
