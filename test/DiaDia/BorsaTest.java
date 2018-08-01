package DiaDia;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;

public class BorsaTest {
	private Borsa borsa;
	private Attrezzo martello;
	private Attrezzo coltello;
	
	@Before
	public void setUp() throws Exception {
		this.borsa=new Borsa();
		this.martello=new Attrezzo("martello",3);
		this.coltello=new Attrezzo("coltello",2);
		this.borsa.addAttrezzo(coltello);
		
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(martello));
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(10, this.borsa.getPesoMax());
	}

	@Test
	public void TestGetAttrezzo() {
		assertEquals(coltello,this.borsa.getAttrezzo("coltello"));
	}
	

	@Test
	public void testgetContenutoOrdinatoPerPeso() {
		Attrezzo pala=new Attrezzo("pala",5);
		this.borsa.addAttrezzo(martello);
		this.borsa.addAttrezzo(pala);
		assertEquals("[coltello (2kg)  , martello (3kg)  , pala (5kg)  ]",this.borsa.getContenutoOrdinatoPerPeso().toString());
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNome(){
		Attrezzo z=new Attrezzo("z",5);
		this.borsa.addAttrezzo(z);
		this.borsa.addAttrezzo(martello);
		assertEquals("[coltello (2kg)  , martello (3kg)  , z (5kg)  ]",this.borsa.getContenutoOrdinatoPerNome().toString());
	}
	
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso(){
		Attrezzo z=new Attrezzo("s",2);
		Attrezzo q=new Attrezzo("z",2);
		this.borsa.addAttrezzo(q);
		this.borsa.addAttrezzo(z);
		this.borsa.addAttrezzo(martello);
		String s=new String();
		Set<Integer> lista=this.borsa.getContenutoRaggruppatoPerPeso().keySet();
		Iterator <Integer> it=lista.iterator();
		Integer appoggio;
		while(it.hasNext()){
			appoggio=it.next();
			s+="#peso: "+appoggio.toString()+"kg -> attrezzi :(";
			Iterator <Attrezzo> iteratore=this.borsa.getContenutoRaggruppatoPerPeso().get(appoggio).iterator();
			while(iteratore.hasNext()){
				s+=iteratore.next().getNome()+" ";
			}
			s+=");\n\n";
		}
		System.out.println(s);
		assertEquals("#peso: 2kg -> attrezzi :(coltello s z );\n\n#peso: 3kg -> attrezzi :(martello );\n\n", s);
	}
}
