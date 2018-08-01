package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.FormatoFileNonValidoException;

import org.junit.Before;
import org.junit.Test;

public class CaricatoreLabirintoTest {
	
	CaricatoreLabirinto c;
	String M1;

	@Before
	public void setUp() throws Exception {
		c=new CaricatoreLabirinto("/Users/Davinder/Documents/ProgrammiJava/DiaDia/src/it/uniroma3/diadia/stanze.txt");
	}

	@Test
	public void testLeggiRigaCheCominciaPer() throws FormatoFileNonValidoException {
		this.M1="Stanze:";
		assertEquals("biblioteca, N10, N11, laboratorio, atrio", this.c.leggiRigaCheCominciaPer(this.M1));
	}
	
	@Test
	public void testSeparaStringheAlleVirgole(){
		assertEquals("[aaa, bbb, ccc]",c.separaStringheAlleVirgole("aaa, bbb, ccc").toString());
	}

}
