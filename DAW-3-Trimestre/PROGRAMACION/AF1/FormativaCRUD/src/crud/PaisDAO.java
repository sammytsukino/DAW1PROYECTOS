package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PaisDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/pelis";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	public static void insertarPais(Scanner scanner) {

		

		System.out.println("Dame el ID del país");
		String idPais = scanner.nextLine();
		System.out.println("Dame el nombre del país");
		String nombrePais = scanner.nextLine();


		String sql = "INSERT INTO pais (idPais, nombrePais) VALUES (?,?)";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, idPais);
			pstmt.setString(2, nombrePais);
			pstmt.executeUpdate();
			System.out.println("País agregadado correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
