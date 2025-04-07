package libreria;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;

		do {
			System.out.println("=== MENÚ PRINCIPAL ===");
			System.out.println("1. Gestionar géneros");
			System.out.println("2. Gestionar autores");
			System.out.println("3. Gestionar libros");
			System.out.println("4. Gestionar préstamos");
			System.out.println("5. Consultas JOIN");
			System.out.println("6. Consultar préstamos con libros");
			System.out.println("0. Salir");
			System.out.print("Opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				GeneroDAO.mostrarMenu(scanner);
				break;
			case 2:
				AutorDAO.mostrarMenu(scanner);
				break;
			case 3:
				PrestamoDAO.mostrarMenu(scanner);
				break;
			case 4:
				LibroDAO.mostrarMenu(scanner);
				break;
			case 5:
				mostrarConsultasLibrosAutorGenero();;
				break;
			case 6:
				mostrarPrestamosConLibros();;
				break;
			case 7:
				System.out.println("Saliendo del programa...");
				return;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}

		} while (opcion != 0);
		scanner.close();
	}
}
