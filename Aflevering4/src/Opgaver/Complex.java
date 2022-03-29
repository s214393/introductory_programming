package Opgaver;

public class Complex {
	public static void main (String [] args) { 
	    	Complex c1 = new Complex(1,2);
	        Complex c2 = new Complex(4,5);
	        
		}
	 
	private double real,imag;
    public Complex(double re, double im) {
        real = re; 
        imag = im;
    }
    



public Complex(Complex z0) {
		 real = z0.real;
		 imag = z0.imag;
		
	}



public double getReal() {
	   return real;
   }
   
   public double getIm() {
	   return imag;
   }
   
   public double abs() {
	   return Math.sqrt(real*real+imag*imag);
   }
   public Complex plus(Complex Other) { 
	   Complex y = new Complex(0,0);
	   y.real = getReal()+Other.getReal();
	   y.imag = getIm()+Other.getIm();
	   return y;
   }
   
   public String toString() {
	   
	   return real +  " +" + " i"+imag;
   }
  
   public Complex times(Complex Other) { 
	   Complex y = new Complex(0,0);
	   y.real = (getReal()*Other.getReal())-(getIm()*Other.getIm());
	   y.imag = (getIm()*Other.getReal())+(getReal()*Other.getIm());
	   return y;
   }
    	
  
  
}

