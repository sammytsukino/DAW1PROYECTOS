package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	private static final String URL = "jdbc:mysql://localhost:3306/pelis";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion;
		try {
			while (true) {
				System.out.println("---DAO PELIS----");
				System.out.println("1. Insertar Actor");
				System.out.println("2. Insertar Película");
				System.out.println("3. Insertar Pais");
				System.out.println("4. Listar actores por país");
				System.out.println("5. Actualizar Actor");
				System.out.println("6. Eliminar Actor por ID");
				System.out.println("7. Listar Película por Género y Director");
				System.out.println("8. Eliminar país por ID");
				System.out.println("9. Salir");
				opcion = scanner.nextInt();
				scanner.nextLine();

				switch (opcion) {
				case 1:
					ActorDAO.insertarActor(scanner);
					break;
				case 2:
					PeliculaDAO.insertarPelicula(scanner);
					break;

				case 3:
					PaisDAO.insertarPais(scanner);
					break;

				case 4:
					listarActorPorPais(scanner);
					break;

				case 5:
					actualizarActor(scanner);
					break;
				case 6:
					eliminarActorId(scanner);
					break;
				case 7:
					listarPeliculasPorGeneroDirector(scanner);
					break;

				case 8:
					eliminarPaisID(scanner);
					break;

				case 9:
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
	
	
	public static void listarActorPorPais(Scanner scanner) {
		String sql = "SELECT  ";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			System.out.println("\nLista de actores");
			while (rs.next()) {
				System.out.println(rs.getInt("idPelicula") + ". " + rs.getString("tituloPelicula") + " - "
						+ rs.getInt("anyoPelicula") + " (" + rs.getInt("duracionPelicula") + " min)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		
	}


