package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PeliculaDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/pelis";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	public static void insertarPelicula(Scanner scanner) {

		System.out.println("Dame el nombre del actor");
		String titulo = scanner.nextLine();
		System.out.println("Dame el ID del director");
		int directorID = scanner.nextInt();
		System.out.println("Dame el ID del genero");
		int generoID = scanner.nextInt();
		System.out.println("Dime el año de la pelicula");
		int anio = scanner.nextInt();
		System.out.println("Dime la duración de la peli en minutos: ");
		int duracion = scanner.nextInt();

		String sql = "INSERT INTO pelicula (tituloPelicula, directorPelicula, generoPelicula, anyoPelicula, duracionPelicula) VALUES (?,?,?,?,?)";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, titulo);
			pstmt.setInt(2, directorID);
			pstmt.setInt(3, generoID);
			pstmt.setInt(4, anio);
			pstmt.setInt(5, duracion);
			pstmt.executeUpdate();
			System.out.println("Pelicula agregadada correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
