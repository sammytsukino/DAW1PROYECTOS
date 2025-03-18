package simulacro;

public class Ejercicio1 {
public static void main(String[] args) {
	int num1 = 10;
	double num2 = 5.0;
	String mensaje = "Hola! Este es el resultado de la operación: ";
	
	double suma = num1 + num2;
	String resultado = mensaje + suma;
	System.out.println(resultado);

	String mensajeConcatenado = String.valueOf(resultado);
	String mensajeConcatenado2 = mensajeConcatenado + " . Adiós!";
	String mensajeConcatenado3 = mensajeConcatenado.concat(mensajeConcatenado2);
	
	String mensajeReemplazado = mensajeConcatenado2.replace("operación", "suma");
	
	String mensajeSubstringeado = mensajeReemplazado.substring(0,5);
	
	boolean mensajeComprobado = mensajeSubstringeado.matches(".*\\d+.*");
	System.out.println(mensajeComprobado);

	
	
	
	
	
	
	
	
	
	
}

}
