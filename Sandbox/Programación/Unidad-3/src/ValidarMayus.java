import java.util.Scanner;
public class ValidarMayus {

	public static void main (String []args) {
		String cadena = "HOLA";
		boolean esMayuscula = cadena.matches("^[A-Z]+$");
		System.out.println(esMayuscula);
		
		
		Scanner sc = new Scanner(System.in);
		String cadena1 = sc.next();
		boolean esMayuscula2 = cadena1.matches("^[A-Z]+$");
		System.out.println(esMayuscula2);
		
	}
}

