package conectores;

import java.sql.*;

public class PruebaConex {
		private static final String URL = "jdbc:mysql://localhost:3306/pelis";
		private static final String USER = "root";
		private static final String PASSWORD = "CEI1234";
		
		public static void main(String[] args) {
			try {
				Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
				System.out.println("Conexión establecida");
				
			} catch (SQLException e ) {
				System.err.println("Error al conectar con la base de datos: " + e.getMessage());
			}
		}
}
