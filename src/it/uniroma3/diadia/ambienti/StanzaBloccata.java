package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String attrezzoSblocco;
	
	public StanzaBloccata(String nome,String direzioneBloccata, String attrezzoSblocco){
		super(nome);
		this.direzioneBloccata=direzioneBloccata;
		this.attrezzoSblocco=attrezzoSblocco;
	}
	
	public Stanza getStanzaAdiacente(String direzione) {
		if(!this.hasAttrezzo(this.attrezzoSblocco)){
				if(this.direzioneBloccata.equals(direzione)){
					System.out.println("la stanza è bloccata");
					return super.getStanzaCorrente();
				}
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	public void setNomeAttrezzo(String nomeAttrezzo) {
		this.attrezzoSblocco = nomeAttrezzo;
	}
	
	public String getNomeAttrezzo() {
		return attrezzoSblocco;
	}
	
	public StanzaBloccata getStanzaCorrente(){
		return this;
	}
}
