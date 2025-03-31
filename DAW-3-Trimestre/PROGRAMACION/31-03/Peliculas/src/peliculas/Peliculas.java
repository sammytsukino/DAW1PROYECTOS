package peliculas;

import java.sql.*;
import java.util.Scanner;

public class Peliculas {

	private static final String URL = "jdbc:mysql://localhost:3306/pelis";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

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
					mostrarPeliculas();
					break;
				case 3:
					mostrarPeliculas();
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

	private static void agregarPelicula(Scanner scanner) throws SQLException {

		System.out.println("Dame el título de la peli");
		String titulo = scanner.nextLine();
		System.out.println("Dame el ID del director");
		int directorID = scanner.nextInt();
		System.out.println("Dame el ID del genero");
		int generoID = scanner.nextInt();
		System.out.println("Dime el año de la pelicula");
		int anio = scanner.nextInt();
		System.out.println("Dime la duración de la peli en minutos: ");
		int duracion = scanner.nextInt();
		scanner.nextLine();

		String sql = "INSERT INTO pelicula (tituloPelicula, directorPelicula, generoPelicula, anyoPelicula, duracionPelicula)";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, titulo);
			pstmt.setInt(1, directorID);
			pstmt.setInt(3, generoID);
			pstmt.setInt(4, anio);
			pstmt.setInt(5, duracion);
			pstmt.executeUpdate();
			System.out.println("Pelicula agregadada correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void mostrarPeliculas() throws SQLException {
		String sql = "SELECT * FROM pelicula";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			System.out.println("\nLista de películas");
			while (rs.next()) {
				System.out.println(rs.getInt("idPelicula") + ". " + rs.getString("tituloPelicula") + " - "
						+ rs.getInt("anyoPelicula") + " (" + rs.getInt("duracionPelicula") + " min)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void actualizarPelicula(Scanner scanner) throws SQLException {
		System.out.println("Ingrese el ID de la pelicula a actualizar ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese nuevo título: ");
		String titulo = scanner.nextLine();

		String sql = "UPDATE pelicula SET tituloPelicula = ? WHERE idPelicula = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, titulo);
			pstmt.setInt(2, id);
			int rowsUpdated = pstmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Se ha actualizado correctamente");
			} else {
				System.out.println("No se encuentra la pelicula con ID:  + id");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	private static void eliminarPelicula(Scanner scanner) throws SQLException {
		System.out.println("Ingrese el ID de la pelicula a eliminar: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		String deleteInterpretacionesSQL = "DELE FROM interpretacion WHERE idPelcula = =";
		String deletePeliculaSQL = "DELETE FROM pelicula WHERE idPelicula = ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmtInterpretaciones = conn.prepareStatement(deleteInterpretacionesSQL);
				PreparedStatement pstmtPelicula = conn.prepareStatement(deletePeliculaSQL)) {

			pstmtInterpretaciones.setInt(1, id);
			pstmtInterpretaciones.executeUpdate();

			pstmtPelicula.setInt(1, id);
			int rowsDeleted = pstmtPelicula.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Pelicula eliminada correctamente");

			} else {
				System.out.println("No se encontró la película con ID: " + id);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
