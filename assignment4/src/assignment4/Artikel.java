package assignment4;

public class Artikel {
	private String[] forfattere;
	public String titel;
	private Tidsskrift tidsskrift;
	private Artikel[] referenceliste;
	public Artikel(String[] forfattere, String titel, Tidsskrift tidsskrift) {
		//Konstruktør
		this.forfattere = forfattere;
		this.titel = titel;
		this.tidsskrift = tidsskrift;
	}
	
	public void setReferenceliste (Artikel[] referenceliste) {
		this.referenceliste = referenceliste;
	}
	
	public String toString() {
		String forfattere_string = "";
		String referenceliste_string = "";
		forfattere_string += this.forfattere[0];
		
		
		for(int i =1; i < this.forfattere.length; i++) {
			forfattere_string += " & " + this.forfattere[i];
		}
		if(referenceliste != null) {
			referenceliste_string += referenceliste[0].titel;
			for(int i =1; i < this.referenceliste.length; i++) {
			referenceliste_string += "& " + referenceliste[i].titel;
		
			}
		}
		else {
			referenceliste_string = " N/A";
		}
		return forfattere_string + ": \"" + titel + "\". " + tidsskrift.toString() + ". Referencer: " + referenceliste_string ;
	}
}
