package simulacro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lista {

	public static void main(String[] args) {

		// Crear un objeto Scanner para leer entradas del usuario

		Scanner scanner = new Scanner(System.in);

		// Crear un ArrayList para almacenar los números enteros

		ArrayList<Integer> numeros = new ArrayList<>();

		// Pedir al usuario que ingrese 5 números

		System.out.println("Por favor, ingresa 5 números enteros:");

		for (int i = 0; i < 5; i++) {

			System.out.print("Número " + (i + 1) + ": ");

			// Leer el número entero y agregarlo al ArrayList

			int numero = scanner.nextInt();

			numeros.add(numero);

		}

		// Realizar las operaciones matemáticas

		int suma = 0;
		int maximo = numeros.get(0);
		int minimo = numeros.get(0);

		// Calcular la suma, el máximo y el mínimo

		for (int numero : numeros) {

			suma += numero;

			if (numero > maximo) {
				maximo = numero;
			}
			if (numero < minimo) {
				minimo = numero;

			}

		}

		// Calcular el promedio

		double promedio = (double) suma / numeros.size();

		// Mostrar resultados de las operaciones matemáticas

		System.out.println("\nOperaciones matemáticas:");
		System.out.println("Suma de los números: " + suma);
		System.out.println("Promedio de los números: " + promedio);
		System.out.println("Número máximo: " + maximo);
		System.out.println("Número mínimo: " + minimo);

		// Ordenar la lista de menor a mayor

		Collections.sort(numeros);

		// Mostrar la lista ordenada

		System.out.println("\nLista de números ordenada de menor a mayor:");

		for (int numero : numeros) {
			System.out.println(numero);

		}
		// Cerrar el objeto Scanner

		scanner.close();

	}

}
