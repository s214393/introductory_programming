package assignment4;

public class ArtikelTest {

	public static void main(String[] args) {
		Forlag uniPress = new Forlag("University Press", "Denmark");
		Tidsskrift journal = new Tidsskrift("Journal of Logic");
		journal.setForlag(uniPress);
		Tidsskrift brain = new Tidsskrift("Brain");
		brain.setForlag(uniPress);
		String[] forfattere_A = {"A. Abe", "A. Turing"}; 
		Artikel A = new Artikel(forfattere_A, "A", journal);
		String[] forfattere_B = {"B. Bim"};
		Artikel B = new Artikel(forfattere_B,"B", journal);
		Artikel[] referenceliste_A = {B};
		A.setReferenceliste(referenceliste_A);
		
		System.out.println(A);
		System.out.println(B);
	}

}
