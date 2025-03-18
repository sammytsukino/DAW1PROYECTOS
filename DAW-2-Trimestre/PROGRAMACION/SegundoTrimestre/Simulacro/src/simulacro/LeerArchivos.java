package simulacro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeerArchivos {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String rutaArchivo = "datos.txt";

		while (true) {
			System.out.println("Elige una opción");
			System.out.println("Opción 1: Tal");
			System.out.println("Opción 2: Pascual");

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
					buscarFiltro(rutaArchivo, scanner);
					break;
				case 5:
					scanner.close();
					return;

				default:
					throw new IllegalArgumentException("Unexpected value: " + opcion);

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void leerArchivo(String rutaArchivo) {
		File archivo = new File(rutaArchivo);
		if (!archivo.exists()) {
			System.out.println("El archivo no existe");
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void escribirArchivo(String rutaArchivo, Scanner scanner) throws IOException {
		System.out.println("Escribe el nombre");
		String nombre = scanner.nextLine();
		System.out.println("Escribe la edad");
		int edad = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Escribe el departamento");
		String departamento = scanner.nextLine();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
			writer.write(nombre + "," + edad + "," + departamento);
			writer.newLine();
			System.out.println("Se ha escrito correctamente");

		}
	}

	public static void buscarFiltro(String rutaArchivo, Scanner scanner) throws FileNotFoundException, IOException {
		System.out.println("Introduce un filtro");
		String filtro = scanner.nextLine();
		File archivo = new File(rutaArchivo);

		if (!archivo.exists()) {
			System.out.println("El archivo no existe");
			return;
		}
		boolean encontrado = false;
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				if(linea.contains(filtro)) {
					System.out.println(linea);
					encontrado = true;
				}

			}
			if (!encontrado) {
				System.out.println("No se ha encontrado el filtro");
			}
		}
	}
}