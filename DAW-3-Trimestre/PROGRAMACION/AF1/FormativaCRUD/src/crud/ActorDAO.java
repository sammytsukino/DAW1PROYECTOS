package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ActorDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/pelis";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	public static void insertarActor(Scanner scanner) {

		System.out.println("Dame el ID del actor");
		String idActor = scanner.nextLine();
		System.out.println("Dame el nombre del actor");
		String nombreActor = scanner.nextLine();
		System.out.println("Dame la nacionalidad del actor");
		int nacionalidadActor = scanner.nextInt();


		String sql = "INSERT INTO actor (idActor, nombreActor, nacionalidadActor) VALUES (?,?,?,?,?)";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, idActor);
			pstmt.setString(2, nombreActor);
			pstmt.setInt(3, nacionalidadActor);
			pstmt.executeUpdate();
			System.out.println("Actor agregadado correctamente");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
