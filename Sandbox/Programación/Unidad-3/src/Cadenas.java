public class Cadenas {

	public static void main(String[] args) {
		String cadena = "456 @#4 gmT42";
		String nuevaCadena1 = cadena.replaceAll(" ", "b");
		String nuevaCadena2 = nuevaCadena1.replaceAll("[0-9]", "N");
		System.out.println(nuevaCadena2);
		
		
		
		String texto = "abc473827bnh4893082";
		String numeros = texto.replaceAll("[0-9]","");
		System.out.println(numeros);

	}

}