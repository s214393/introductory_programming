package assignment4;

public class Forlag {
	
	private String navn;
	private String sted;
	
	public Forlag(String navn, String sted) {
		// KonstruktÝr
		this.navn = navn;
		this.sted = sted;
	}

	public String toString() {
		return navn + ", " + sted;
	}
}
