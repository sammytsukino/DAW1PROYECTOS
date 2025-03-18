package simulacro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio11 {
	public static void main(String[] args) {
		int num1 = 10;
		double num2 = 10.5;
		String mensaje = "Hola! ";
		
		///Operaciones
		double suma = num1 + num2;
		System.out.println(mensaje + suma);
		
		//Suma a texto
		String sumaTexto = String.valueOf(suma);
		System.out.println(mensaje + "Este es el resultado de la suma: " + sumaTexto);
		
		//Texto concat
		String sumaTextoConcat = mensaje.concat(sumaTexto);
		
		//Texto sustituido
		String sumaSustituida = sumaTextoConcat.replace("Hola! ", "Saludos! ");
		
		//Substring
		String sumaSubstringeada = sumaSustituida.substring(0,5);
		
		//Buscamos si hay números
		Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
		Matcher matcher = pattern.matcher(sumaSustituida);
		
		if (matcher.find()) {
			String numeroExtraido = matcher.group();
			System.out.println(numeroExtraido);
		} else {
			System.out.println("No hay números en la cadena");
		}
		
		
	}

}
