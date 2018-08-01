package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

import org.junit.Before;
import org.junit.Test;

public class ComandoInteragisciTest {
	private Partita partita;
	private ComandoInteragisci comando;
	
	@Before
	public void setUp() throws Exception {
		this.partita=new Partita();
		this.comando=new ComandoInteragisci();
	}

	@Test
	public void testInteragisciMago() {
		Mago personaggio=new Mago("merlino", "hi", new Attrezzo("spada",2));
		partita.getStanzaCorrente().setPersonaggio(personaggio);
		comando.esegui(partita);	
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("spada"));
	}
	
	@Test
	public void testInteragisciStregaPositivo() {
		Strega personaggio=new Strega("strega", "hi", new Attrezzo("coltello",2));
		this.partita.getStanzaCorrente().setPersonaggio(personaggio);
		
		this.partita.getStanzaCorrente().getStanzaAdiacente("sud").addAttrezzo(new Attrezzo("a",1));
		this.partita.getStanzaCorrente().getStanzaAdiacente("sud").addAttrezzo(new Attrezzo("b",1));
		this.partita.getStanzaCorrente().getStanzaAdiacente("sud").addAttrezzo(new Attrezzo("c",1));
		this.partita.getStanzaCorrente().getStanzaAdiacente("nord").addAttrezzo(new Attrezzo("e",1));

		personaggio.saluta();
		comando.esegui(partita);	
		assertEquals("N10",this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testInteragisciStregaNegativo() {
		Strega personaggio=new Strega("strega", "hi", new Attrezzo("coltello",2));
		this.partita.getStanzaCorrente().setPersonaggio(personaggio);
		
		this.partita.getStanzaCorrente().getStanzaAdiacente("sud").addAttrezzo(new Attrezzo("a",1));
		this.partita.getStanzaCorrente().getStanzaAdiacente("sud").addAttrezzo(new Attrezzo("b",1));
		this.partita.getStanzaCorrente().getStanzaAdiacente("sud").addAttrezzo(new Attrezzo("c",1));
		this.partita.getStanzaCorrente().getStanzaAdiacente("nord").addAttrezzo(new Attrezzo("e",1));
		
		comando.esegui(partita);	
		assertEquals("laboratorio",this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testInteragisciCane() {
		Cane personaggio=new Cane("rex", "hi", new Attrezzo("spada",2));
		partita.getStanzaCorrente().setPersonaggio(personaggio);
		int appoggio=this.partita.getGiocatore().getCfu();
		comando.esegui(partita);	
		assertTrue(this.partita.getGiocatore().getCfu()==appoggio-1);
	}
}
