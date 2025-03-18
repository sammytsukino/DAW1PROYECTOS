package simulacro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<>();
		int suma = 0;
		double promedio = 0;

		System.out.println("Indique 5 números enteros: ");
		for (int i = 0; i < 5; i++) {
			int numero = scanner.nextInt();
			numeros.add(numero);
		}

		for (Integer numero : numeros) {
			suma += numero;
		}
		
		promedio = suma / numeros.size();
		
	
		int max = Collections.max(numeros);
		int min = Collections.min(numeros);
		
		Collections.sort(numeros);
		
		System.out.println("Esta es la suma: " + suma);
		System.out.println("Este es el promedio: " + promedio);
		System.out.println("Este es el max: " + max);
		System.out.println("Este es el min: " + min);
		System.out.println("Esta es la lista ordenada de menor a mayor: " + numeros);
		

		scanner.close();
	}

}
