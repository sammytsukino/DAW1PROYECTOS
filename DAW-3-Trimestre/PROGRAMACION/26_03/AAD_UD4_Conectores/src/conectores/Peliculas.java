package conectores;

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
				System.out.println("---CRUD PELIS----");
				System.out.println("Dame una opción");
				opcion = scanner.nextInt();
				scanner.nextLine();

				switch (opcion) {
				case 1: {
					agregarPelicula(scanner);
					break;
				}
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
}
