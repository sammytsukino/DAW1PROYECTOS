package simulacro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio22 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<>();
		int suma = 0;
		double promedio = 0;
		double multiplicacion = 1;
		System.out.println("Ingresa un número");
		
		for(int i=0; i<5; i++) {
			int numero = scanner.nextInt();
			numeros.add(numero);
		}
		
		for (Integer numero : numeros) {
			suma += numero;
			multiplicacion *= numero;
		}
		
		promedio = suma / numeros.size();
		
		int min = Collections.min(numeros);
		int max = Collections.max(numeros);
		
		Collections.sort(numeros.reversed());
		
		System.out.println(suma);
		System.out.println(promedio);
		System.out.println(max);
		System.out.println(min);
		System.out.println(numeros);
		System.out.println(multiplicacion);
		
		scanner.close();
		
	}
	
}
