package DiaDia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;
public class GiocatoreTest {
	
	private Giocatore giocatore;
	private Attrezzo pala;
	
	@Before
	public void setUp() throws Exception {
		this.giocatore=new Giocatore();
		this.pala=new Attrezzo("pala", 7);
	}

	@Test
	public void testGetCfu() {
		assertEquals(20,this.giocatore.getCfu());
	}

	@Test
	public void testAggiungiAttrezzo() {
		assertTrue(this.giocatore.getBorsa().addAttrezzo(this.pala));
	}

}
