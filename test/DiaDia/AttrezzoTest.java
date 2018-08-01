package DiaDia;


import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class AttrezzoTest {
	private Attrezzo forbici;

	@Before
	public void setUp() throws Exception {
		this.forbici=new Attrezzo("Forbici",1);
	}

	@Test
	public void testGetNome() {
		assertEquals("Forbici", forbici.getNome());
	}

	@Test
	public void testGetPeso() {
		assertEquals(1, forbici.getPeso());

	}

	@Test
	public void testToString() {
		assertEquals("Forbici (1kg)  ", forbici.toString());
	}

}
