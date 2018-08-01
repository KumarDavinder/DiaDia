package DiaDia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.*;

public class LabirintoTest {
	private Labirinto labirinto;
	
	
	@Before
	public void setUp() throws Exception {
		this.labirinto=new Labirinto();
		
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("biblioteca",this.labirinto.getStanzaVincente().getNome());
	}

	@Test
	public void testGetStanzaCorrente() {
		assertEquals("atrio",this.labirinto.getStanzaCorrente().getNome());
	}
}
