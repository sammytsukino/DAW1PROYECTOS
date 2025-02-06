public class Ejercicio2 {

	public static void main (String [] args) {
		String texto1 = "kajale44ienakmema887899788wnwkwk8";
		String texto2 = "AJWOEMA876NUWN8S9";
		String caracteres = texto1.replaceAll("[a-z]", "");
		System.out.println(caracteres);
		String caracteres1 = texto2.replaceAll("[A-Z]", "");
		System.out.println(caracteres1);
		
	}
}