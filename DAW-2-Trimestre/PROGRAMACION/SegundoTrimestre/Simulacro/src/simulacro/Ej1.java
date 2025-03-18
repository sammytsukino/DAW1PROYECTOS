package simulacro;
import java.util.regex.*;

public class Ej1 {
	 public static void main(String[] args) { 
	        // Declarar variables 
	        int num1 = 5;               // Variable entera 
	        double num2 = 3.2;          // Variable decimal 
	        String mensaje = "El resultado de la operación es: ";  // Variable de texto 
	        // Realizar operación matemática 
	        double resultado = num1 + num2; 
	        // Convertir el resultado a cadena de texto 
	        String resultadoCadena = String.valueOf(resultado); 
	        // Concatenar el resultado con otro mensaje 
	        String mensajeFinal = mensaje + resultadoCadena; 
	        // Manipulaciones adicionales de cadenas 
	        // Reemplazar una palabra en el mensaje 
	        mensajeFinal = mensajeFinal.replace("operación", "suma"); 
	        // Obtener un substring del resultado (tomando solo los primeros 5 caracteres) 
	        String substringResultado = mensajeFinal.substring(0, 5); 
	        // Usar expresión regular para buscar si existe un número en el mensaje 
	        Pattern pattern = Pattern.compile("\\d+");  // Expresión regular para buscar números 
	        Matcher matcher = pattern.matcher(mensajeFinal); 
	        if (matcher.find()) { 
	            System.out.println("Número encontrado en el mensaje: " + matcher.group()); 
	        } 
	        // Mostrar el resultado final con manipulaciones 
	        System.out.println("Mensaje Final: " + mensajeFinal); 
	        System.out.println("Substring del resultado: " + substringResultado); 
	    } 
	} 

