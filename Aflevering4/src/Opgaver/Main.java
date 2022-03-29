package Opgaver;
import java.util.Scanner;
public class Main {
	public static void main (String [] args) { 

		mandal();

	}
	public static void mandal() {
		int max = 20;
		Scanner console = new Scanner(System.in);
		System.out.print("Enter Grid size: ");
		double re = console.nextDouble();
		double im = console.nextDouble();
		Complex center = new Complex(re,im);
		int g = 5; 
		Scanner console1 = new Scanner(System.in);
		int s = console.nextInt();


		for (int j = 0; j < g-1 ; j++) { 
			double x = ((center.getReal())-(s/2)+(s*j)/(g-1));

			for (int k = 0; k < g-1 ; k++) { 
				double y = ((center.getIm())-(s/2)+(s*k)/(g-1));

				Complex z0 = new Complex(x,y);
				System.out.println(z0);
			

			}
		}
	}
	public static int iterate(Complex z0) {
		int max = 20; 
		Complex z = new Complex(z0);
		for (int i = 0; i < max; i++) {
			if (z.abs() > 2.0) {
				return i;
			}
			z = z.times(z).plus(z0);
		}
		return max;
	}
}


