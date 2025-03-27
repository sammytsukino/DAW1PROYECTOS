package peliculas;

import java.sql.*;
import java.util.Scanner;

public class Peliculas {

	private static final String URL = "jdbc:mysql://localhost:3306/pelis";
	private static final String USER = "root";
	private static final String PASSWORD = "CEI1234";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;
		try {
			while (true) {
				System.out.println("---CRUD PELIS----");
				System.out.println("1. Agrega una peli");
				System.out.println("2. Muestra todas las películas");
				System.out.println("3. Muestra película por ID");
				System.out.println("4. Actualiza una pelicula");
				System.out.println("5. Elimina una pelicula");
				System.out.println("6. Salir");
				opcion = scanner.nextInt();
				scanner.nextLine();

				switch (opcion) {
				case 1:
					agregarPelicula(scanner);
					break;
				case 2:
					mostrarTodasLasPeliculas();
					break;
				case 3:
					mostrarPorID(scanner);
					break;

				case 4:
					actualizarPelicula(scanner);
					break;

				case 5:
					eliminarPelicula(scanner);
					break;
				case 6:
					System.out.println("Saliendo del menú...");
					opcion = -1;
					return;

				default:
					System.out.println("No existe esa opción");
					throw new IllegalArgumentException("Unexpected value: " + opcion);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void agregarPelicula(Scanner scanner) {
		String sql = "INSERT INTO pelicula (tituloPelicula, directorPelicula, generoPelicula, anio, duracion)";
		System.out.println("Dame el título de la peli");

	}
}
