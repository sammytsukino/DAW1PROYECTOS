package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMysqlDB2 {

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL_CONEXION = "jdbc:mariadb://localhost:3306/Empresa";

	public static void main(String[] args) {

		final String usuario = "root";
		final String password = "";

		// Conecto con la interfaz Connection y con la clase Statement e inicializo en
		// null. Solo puede haber un ResultSet abierto para cada objeto Statement en un
		// momento dado.

		Connection conexion = null;
		Statement statement = null;

		// Empiezo a dar instrucciones. En primer caso, tengo que dar "Class.forName()"
		// para registrar el driver que he indicado en la variable estática "DRIVER".

		try {
			Class.forName(DRIVER);

			// Después de haber registrado el driver, puedo usar los métodos estáticos de la
			// clase DriverManager para obtener una conexión a la base de datos. Le paso la
			// URL, el usuario y la password.

			Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);

			// Una vez tengo la conexión hecha, comienzo a declarar las consultas. Con la
			// tabla empleados creadas, vamos a seleccionar los usuarios. Aquí almacenamos
			// las consultas en variables de tipo String.

			String consulta1 = "SELECT ID,USERNAME,PASSWORD,NOMBRE FROM Usuarios";
			String consulta2 = "SELECT * FROM Empleados";
			String consulta3 = "SELECT NOMBRE,EDAD FROM Directores WHERE salarioDirector > 10000";

			// Con createStatement() ejecutamos la consulta y la almacenamos en una variable
			// de tipo String para ser ejecutada más tarde.

			statement = conn.createStatement();

			// El resultado de esta consulta se almacena en un objeto de tipo ResultSet.
			// Para comprobar si la consulta se ha ejecutado correctamente, se utiliza el
			// método executeQuery().

			ResultSet rs = statement.executeQuery(consulta1);

			// Con un bucle while, recorremos el ResultSet y mostramos los resultados por
			// pantalla.

			while (rs.next()) { // Mientras siga habiendo registros en el ResultSet, se ejecuta el bucle.
				System.out.println("ID: " + rs.getInt("ID"));
				System.out.println("Username: " + rs.getString("USERNAME"));
				System.out.println("Password: " + rs.getString("PASSWORD"));
				System.out.println("Nombre: " + rs.getString("NOMBRE"));

				// Hacemos la segunda consulta. En primer lugar se ejecuta la consulta y se
				// almacena en un objeto de tipo ResultSet.

				ResultSet rs2 = statement.executeQuery(consulta2);

				// Con un bucle while, recorremos el ResultSet y mostramos los resultados por
				// pantalla.

				while (rs2.next()) {
					System.out.println("ID: " + rs2.getInt("ID"));
					System.out.println("Nombre: " + rs2.getString("NOMBRE"));
					System.out.println("Edad: " + rs2.getInt("EDAD"));
					System.out.println("Salario: " + rs2.getDouble("SALARIO"));
				}

				// Hacemos la tercera consulta. En primer lugar se ejecuta la consulta y se
				// almacena en un objeto de tipo ResultSet.

				ResultSet rs3 = statement.executeQuery(consulta3);

				// Con un bucle while, recorremos el ResultSet y mostramos los resultados por
				// pantalla.

				while (rs3.next()) {
					System.out.println("Nombre: " + rs3.getString("NOMBRE"));
					System.out.println("Edad: " + rs3.getInt("EDAD"));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
