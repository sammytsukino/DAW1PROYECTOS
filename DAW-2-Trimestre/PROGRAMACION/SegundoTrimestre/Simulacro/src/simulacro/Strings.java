package simulacro;

public class Strings {

	public static void main(String[] args) {
		String texto = "Hola-qué-tal";
		String textoDos = "Eing";

		System.out.println(texto.length());
		System.out.println(texto.charAt(10));
		System.out.println(texto.compareTo(textoDos));
		System.out.println(texto.substring(texto.length() - 3));
		System.out.println(texto.substring(0, 10));
		System.out.println(texto.concat(textoDos));
		System.out.println(texto.toUpperCase());
		System.out.println(texto.indexOf("é"));
		System.out.println(texto.equalsIgnoreCase(textoDos));
		System.out.println(texto.replace("qué", "what"));
		System.out.println(texto.trim());
		
		String[] matrizSeparada = texto.split("-");
		
		for (String string : matrizSeparada) {
			System.out.println(string);
		}

		
	}

}
