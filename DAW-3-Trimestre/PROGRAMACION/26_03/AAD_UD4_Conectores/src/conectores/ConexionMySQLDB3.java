package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMySQLDB3 {

	// DECLARO DRIVER Y URL
	static String DRIVER = "org.mariadb.jdbc.Driver";
	static String URL_CONEXION = "jdbc:mariadb://localhost:3306/Empresa";

	// HAGO MAIN

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		// DECLARO USUARIO Y PASSWORD
		String usuario = "sammy";
		String password = "password";

		// INICIALIZADO CONEXION Y STATEMENT A NULL
		Connection conexion = null;
		Statement statement = null;

		// CONECTO EL DRIVER CON FORNAME
		Class.forName(DRIVER);

		// HAGO LA CONEXION DEL DRIVERMANAGER.GETCONNECTION PASÁNDOLE LA URL, USER Y
		// PASS (EN STRINGS)
		Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);

		// DECLARO LAS CONSULTAS
		String consulta1 = "SELECT ID, USERNAME FROM Usuarios";
		String consulta2 = "SELECT USERNAME From Directores WHERE salarioDirecto > 1000";

		// CREO LOS STATEMENTS
		statement = conn.createStatement();

		// CREO EL RESULTSET PARA CADA CONSULTA CON EXECUTEQUERY
		ResultSet rs = statement.executeQuery(consulta1);
		ResultSet rs2 = statement.executeQuery(consulta2);

		// CON UN BUCLE WHILE, IMPRIMIMOS LOS RESULTADOS
		while (rs.next()) {
			System.out.println("ID" + rs.getInt("ID"));
			System.out.println("USERNAME" + rs.getString("USERNAME"));
		}

		while (rs2.next()) {
			System.out.println("USERNAME" + rs2.getString("USAERNAME"));
		}

	}

}
