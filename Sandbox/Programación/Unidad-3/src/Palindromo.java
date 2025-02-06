public class Palindromo {

	public static boolean  esPalindromo (String palabra) {
		String cadena = palabra;
		String cadenaR = "";
		for(int i = cadena.length()-1; i >= 0 ; i--) {
			cadenaR+=cadena.charAt(i);
		}
		
		return cadena.equals(cadenaR);
		
		/*if(cadenaR.equals(cadena)) {
			return 	true;
		}else {
			return false;
		}
		Sería lo mismo pero simplicidado en una sola linea
		*/
	}
	
	public static void main (String [] args) {
		System.out.println(esPalindromo("RECONOCER"));
		System.out.println(esPalindromo("java23"));
		
		
	}
}