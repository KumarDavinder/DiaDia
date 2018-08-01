package DiaDia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	private Stanza n11;
	private Stanza biblioteca;

	private Attrezzo mitragliatrice;
	private Attrezzo libro;
	private Attrezzo martello;
	
	@Before
	public void setUp() throws Exception {
		
		this.mitragliatrice=new Attrezzo("mitragliatrice",9);
		this.martello=new Attrezzo("martello",9);
		this.libro=new Attrezzo("libro",2);
		
		this.biblioteca=new Stanza("biblioteca");
		this.n11=new Stanza("n11");
		
		this.n11.addAttrezzo(mitragliatrice);
		this.n11.addAttrezzo(martello);
		this.biblioteca.addAttrezzo(libro);

		this.n11.impostaStanzaAdiacente("nord",biblioteca);
		this.biblioteca.impostaStanzaAdiacente("sud",n11);

	}
	
	@Test
	public void testGetStanzaAdiacente() {
		assertEquals(biblioteca, n11.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetAttrezzi() {
		Attrezzo [] Array=new Attrezzo[2];
		Array[0]=mitragliatrice;
		Array[1]=martello;
		assertArrayEquals(Array, n11.getAttrezzi());
	}
	
	@Test
	public void testGetDescrizione() {
		assertEquals("biblioteca\nUscite: sud \nAttrezzi nella stanza: libro (2kg)  ",biblioteca.getDescrizione());
	}
	
	@Test
	public void testGetStanzaCorrente(){
		assertEquals(n11,this.n11.getStanzaCorrente());
	}
	
	@Test
	public void testGetNumeroAttrezzi() {
		assertTrue(2==this.n11.getNumeroAttrezzi());
	}
	
	@Test
	public void testAddAttrezzo() {
		this.n11.addAttrezzo(mitragliatrice);
		this.n11.addAttrezzo(mitragliatrice);
		this.n11.addAttrezzo(mitragliatrice);
		this.n11.addAttrezzo(mitragliatrice);
		this.n11.addAttrezzo(mitragliatrice);
		this.n11.addAttrezzo(mitragliatrice);
		this.n11.addAttrezzo(mitragliatrice);
		this.n11.addAttrezzo(mitragliatrice);
		assertTrue(false==this.n11.addAttrezzo(mitragliatrice));
		this.n11.removeAttrezzo(mitragliatrice);
		assertTrue(true==this.n11.addAttrezzo(mitragliatrice));
	}
	
	@Test
	public void testToString() {
		assertEquals("biblioteca\nUscite: sud \nAttrezzi nella stanza: libro (2kg)  ",this.biblioteca.toString());
	}
	
	@Test
	public void testHasAttrezzo() {
		assertTrue(true==this.biblioteca.hasAttrezzo("libro"));
	}
	
	@Test
	public void testGetAttrezzo() {
		assertEquals(libro,this.biblioteca.getAttrezzo("libro"));
	}
	
	@Test
	public void testGetDirezioni() {
		Stanza nuova=new Stanza("ds1");
		this.n11.impostaStanzaAdiacente("ovest", nuova);
		String [] a={"nord","ovest"};
		assertArrayEquals(a, this.n11.getDirezioni());
	}
}
