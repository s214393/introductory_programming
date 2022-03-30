package Opgaver;
import java.awt.Color;
import java.util.Scanner;
public class Main {
	public static void main (String [] args) { 
		mandal();
	}
	public static void mandal() {
		int max = 50;
		StdDraw.setCanvasSize(1000,1000);
		Scanner console = new Scanner(System.in);
		System.out.print("Enter Grid size: ");
		double re = console.nextDouble();
		double im = console.nextDouble();
		double g = 512.0; 
		Scanner console1 = new Scanner(System.in);
		double s = console.nextDouble();
		
		StdDraw.setXscale(0,g);
		StdDraw.setYscale(0,g);
		StdDraw.show(0);
		
		Complex center = new Complex(re,im);
		for (int j = 0; j <= g-1 ; j++) { 
			double x = (center.getReal())-(s/2)+((s*(double) j)/(g-1));

			for (int k = 0; k <= g-1 ; k++) { 
				double y = ((center.getIm())-(s/2)+(s* (double) k)/(g-1));

				Complex z0 = new Complex(x,y);
				
				iterate(z0);
				if (iterate(z0) == max) { 
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.setPenRadius(0.5/100);
					StdDraw.point(j+0.5,k+0.5);
				} 
				if (iterate(z0) < max) { 
					StdDraw.setPenColor(StdDraw.CYAN);
					StdDraw.setPenRadius(0.5/100);
					StdDraw.point(j+0.5,k+0.5);
				}	
				if (iterate(z0) != max) { 
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.setPenRadius(0.5/100);
					StdDraw.point(j+0.5,k+0.5);
				}	
				
			}
		} StdDraw.show(0);
 
	}
	public static int iterate(Complex z0) {
		int max = 50; 
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


