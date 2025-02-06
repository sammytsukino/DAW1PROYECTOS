public class cadenaAMay {

	public static void main (String [] args) {
		
		String cadena = "234bmu786pel718";
		char [] arrayCadena = cadena.toCharArray();
		
		for(int i = 0; i < arrayCadena.length; i++) {
			if(Character.isLetter(arrayCadena[i])) {
				arrayCadena[i] = Character.toUpperCase(arrayCadena[i]);
			}
		}
		
		System.out.println(arrayCadena);
		
	}
	
	
}