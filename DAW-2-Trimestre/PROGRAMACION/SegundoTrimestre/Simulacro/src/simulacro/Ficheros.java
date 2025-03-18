package simulacro;

import java.io.*;
import java.util.*;

public class Ficheros {

	public static void main(String[] args) {

		// Ruta del archivo

		String nombreArchivo = "datos.csv";
		Scanner scanner = new Scanner(System.in);

		// Menú interactivo

		while (true) {

			System.out.println("\n--- Menú ---");
			System.out.println("1. Leer y mostrar el archivo.");
			System.out.println("2. Agregar una nueva línea al archivo.");
			System.out.println("3. Filtrar las líneas del archivo.");
			System.out.println("4. Ordenar las líneas del archivo.");
			System.out.println("5. Salir.");
			System.out.print("Elige una opción: ");

			int opcion = scanner.nextInt();

			scanner.nextLine(); // Consumir el salto de línea
			try {

				switch (opcion) {

				case 1:
					leerArchivo(nombreArchivo);
					break;
				case 2:
					agregarLinea(nombreArchivo, scanner);
					break;
				case 3:
					filtrarLineas(nombreArchivo, scanner);
					break;
				case 4:
					ordenarLineas(nombreArchivo);
					break;
				case 5:
					System.out.println("Saliendo...");
					scanner.close();
					return;
				default:
					System.out.println("Opción no válida. Intenta de nuevo.");
				}

			} catch (IOException e) {
				System.out.println("Error de I/O: " + e.getMessage());
			} catch (Exception e) {

				System.out.println("Error inesperado: " + e.getMessage());

			}

		}

	}

	// 1. Leer y mostrar el archivo CSV

	public static void leerArchivo(String nombreArchivo) throws IOException {
		
		
		File archivo = new File(nombreArchivo);
		
		
		
		if (!archivo.exists()) {
			System.out.println("El archivo no existe.");
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;
			System.out.println("\nContenido del archivo:");
			
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);

			}

		}

	}

	// 2. Agregar una nueva línea al archivo

	public static void agregarLinea(String nombreArchivo, Scanner scanner) throws IOException {
		System.out.print("Introduce el nombre: ");
		String nombre = scanner.nextLine();
		System.out.print("Introduce la edad: ");
		int edad = scanner.nextInt();
		scanner.nextLine(); // Consumir el salto de línea
		System.out.print("Introduce el departamento: ");
		String departamento = scanner.nextLine();
		
		
		
		
		

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
			writer.write(nombre + "," + edad + "," + departamento);
			writer.newLine();
			System.out.println("Línea agregada al archivo.");
		}

	}

	// 3. Filtrar las líneas del archivo

	public static void filtrarLineas(String nombreArchivo, Scanner scanner) throws IOException {
	    System.out.print("Introduce el departamento para filtrar: ");
	    String filtro = scanner.nextLine();
	    File archivo = new File(nombreArchivo);

	    if (!archivo.exists()) {
	        System.out.println("El archivo no existe.");
	        return;
	    }

	    boolean encontrado = false;
	    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
	        String linea;
	        System.out.println("\nLíneas filtradas:");
	        while ((linea = reader.readLine()) != null) {
	            if (linea.contains(filtro)) {
	                System.out.println(linea);
	                encontrado = true;
	            }
	        }
	    }

	    if (!encontrado) {
	        System.out.println("No se encontraron líneas con el filtro '" + filtro + "'.");
	    }
	}


	// 4. Ordenar las líneas del archivo

	public static void ordenarLineas(String nombreArchivo) throws IOException {
		File archivo = new File(nombreArchivo);
		if (!archivo.exists()) {
			System.out.println("El archivo no existe.");
			return;
		}

		ArrayList<String> lineas = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				lineas.add(linea);

			}

		}

		// Ordenar las líneas alfabéticamente
		Collections.sort(lineas);
		// Reescribir el archivo con las líneas ordenadas

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
			for (String linea : lineas) {
				writer.write(linea);
				writer.newLine();
			}
			System.out.println("El archivo ha sido ordenado.");
		}

	}

}
