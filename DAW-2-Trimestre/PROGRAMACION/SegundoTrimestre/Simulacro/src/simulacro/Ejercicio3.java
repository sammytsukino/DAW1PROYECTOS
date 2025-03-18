package simulacro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		String rutaArchivo = "datos.txt";
		Scanner scanner = new Scanner(System.in);

		while (true) {
			
		System.out.println("Menu");
		System.out.println("Opción 1 - Lee el archivo");
		System.out.println("Opción 2 - Escribe una línea nueva");
		System.out.println("Opción 3 - Filtra por término");
		System.out.println("Opción 4 - Salir");

		int opcion = scanner.nextInt();
		scanner.nextLine();

	
				try {
					switch (opcion) {
					case 1:
						leerArchivo(rutaArchivo);
						break;
					case 2:
						escribirArchivo(rutaArchivo, scanner);
						break;
					case 3:
						filtrarArchivo(rutaArchivo, scanner);
						break;
					case 4:
						scanner.close();
						return;

					default:
						throw new IllegalArgumentException("Unexpected value: " + opcion);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

	}

	public static void leerArchivo(String rutaArchivo) throws FileNotFoundException, IOException {
		File archivo = new File(rutaArchivo);
		if (!archivo.exists()) {
			System.out.println("Este archivo no existe");
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void escribirArchivo(String rutaArchivo, Scanner scanner) throws IOException {
		System.out.println("Introduce un nombre");
		String nombre = scanner.nextLine();
		System.out.println("Introduce una edad");
		int edad = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Introduce un departamento");
		String departamento = scanner.nextLine();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
			writer.write(nombre + "," + edad + "," + departamento);
			writer.newLine();
			System.out.println("La línea ha sido escrita correctamente");
		}

	}

	public static void filtrarArchivo(String rutaArchivo, Scanner scanner) throws FileNotFoundException, IOException {
		System.out.println("Escribe un filtro");
		String filtro = scanner.nextLine();
		File archivo = new File(rutaArchivo);
		boolean encontrado = false;
		if (!archivo.exists()) {
			System.out.println("Este archivo no existe");
			return;
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				if (linea.contains(filtro)) {
					encontrado = true;
					System.out.println("Se ha encontrado la palabra " + filtro);
					System.out.println(linea);
				}
			}
			if (!encontrado) {
				System.out.println("No se ha encontrado el filtro");
			}
		}
	}
}
