package conectores;

/* No te olvides de importar el conector
 * mariadb en formato jar
 */
import java.sql.Connection;

import java.sql.DriverManager;
/* El objetivo de la clase DriverManager, 
 * realmente, es gestionar los drivers que 
 * poseemos en nuestra aplicación y permitir 
 * en una misma capa el acceso a todos y cada 
 * uno de ellos. Algo que debemos tener en cuenta 
 * es que DriverManager necesita que todos y cada 
 * uno de los drivers estén registrados antes de su 
 * uso. Las conexiones deben quedar almacenadas 
 * antes de acceder a la base de datos.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author decodigo
 */
public class ConexionMysqlDB {
	
	/*
	 * La clase DriverManager es una clase que se encarga de gestionar los drivers de
	 * la base de datos. La clase DriverManager es la encargada de cargar los drivers
	 * de la base de datos y de devolvernos una conexión a la base de datos. La clase
	 * DriverManager es una clase estática, por lo que no es necesario instanciar un
	 * objeto de la clase DriverManager para poder utilizar sus métodos.
	 */
	
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL_CONEXION = "jdbc:mariadb://localhost:3306/Empresa";
	/*
	 * La URL de conexión a la base de datos es una cadena de texto que contiene
	 * información sobre cómo conectarse a la base de datos. La URL de conexión
	 * contiene información sobre el tipo de base de datos a la que se conecta, el
	 * servidor de base de datos, el puerto y el nombre de la base de datos.
	 */
	
	

	public static void main(String args[]) throws SQLException {
		final String usuario = "root";
		/*
		 * Conectar con root no es lo recomendable, por eso he creado un usuario nuevo
		 * miguel
		 */

		final String password = "";
		/*
		 * Connection es una interfaz que representa una conexión directa con una bbdd.
		 * El motivo de que sea una interfaz es porque tendrá distintas implementaciones
		 * posibles
		 */
		Connection dbConnection = null;
		/*
		 * Un objeto de la clase Statement sirve para procesar una sentencia SQL
		 * estática y obtener los resultados producidos por ella. Solo puede haber un
		 * ResultSet abierto para cada objeto Statement en un momento dado
		 */
		Statement statement = null;
		try {
			/*
			 * La primera instrucción que daremos es: “Class.forName()”, de esta forma
			 * registraremos el driver que anteriormente hemos indicado en la variable
			 * estática “DRIVER”.
			 */
			Class.forName(DRIVER);

			/*
			 * Después de haber registrado el driver, se pueden usar los métodos estáticos
			 * para hacer “getConnection”, usándolo directamente para establecer conexiones.
			 */
			Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
			/*
			 * Una vez que DriverManager nos ha devuelto la conexión a base de datos,
			 * realizaremos un ejemplo sencillo de consulta simple y la almacenaremos en una
			 * variable de tipo String para más tarde ser ejecutada.
			 */
			String selectTableSQL = "SELECT ID,USERNAME,PASSWORD,NOMBRE FROM Usuarios";
			String selectTableSQL1 = "SELECT ID,USERNAME FROM Usuarios";
			// String selectTableSQL2 = "SELECT NOMBRE, EDAD FROM Directores WHERE
			// salarioDirector > 10000";
			/*
			 * Con la variable Connection, ejecutamos el método “createStatement” y lo
			 * asignamos a la variable definida al principio del ejercicio de tipo
			 * Statement. Más tarde, simplemente, tendremos que realizar la consulta con el
			 * método “executeQuery” pasándole como parámetro la query previamente definida
			 * en la variable de tipo String.
			 */
			statement = conn.createStatement();
			/*
			 * El resultado de la query se asignará a una variable de tipo Resulset. Como
			 * podemos comprobar en el código, dicho ResultSet está envuelto en un bucle
			 * “while”, ya que por cada fila que nos devuelva esta tabla, podremos ir dando
			 * una vuelta más al bucle y seguir mostrando los resultados. En esta ocasión,
			 * hemos decidido realizar la operación de mostrar por pantalla tanto el ID, el
			 * USERNAME, el PASSWORD y el NOMBRE, que son columnas de la tabla Usuarios que
			 * hemos consultado de prueba.
			 */
			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {
				String id = rs.getString("ID");
				String usr = rs.getString("USERNAME");
				String psw = rs.getString("PASSWORD");
				String nombre = rs.getString("NOMBRE");
				System.out.println("userid : " + id);
				System.out.println("usr : " + usr);
				System.out.println("psw : " + psw);
				System.out.println("nombre : " + nombre);
			}
			ResultSet rs1 = statement.executeQuery(selectTableSQL1);

			while (rs1.next()) {
				String id1 = rs1.getString("ID");
				String usr1 = rs1.getString("USERNAME");
				System.out.println("userid : " + id1);
				System.out.println("usr : " + usr1);

			}
		} catch (SQLException e) {
			/*
			 * Inicialmente, nos encontramos con SQLException, dicha excepción es capturada
			 * si a la hora de ejecutar el método “executeQuery” algo va mal en base de
			 * datos, ya sea gramaticalmente, sintácticamente, etc.
			 */
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			/*
			 * La excepción ClassNotFoundException es lanzada y capturada en este punto si
			 * en nuestra línea: “Class.forName(DRIVER)”, el fichero del driver que le
			 * estamos indicando no encontrara la librería.
			 */
			System.out.println(e.getMessage());
		} finally {

			/*
			 * Por último, comentar y recordar que la sentencia finally se ejecutará
			 * siempre, hayamos capturado excepción o no. En esta, simplemente, se realizan
			 * los cierres de la clase Statement y del objeto Connection que, a su vez, en
			 * este punto pueden lanzar una excepción que será recogida y lanzada a la capa
			 * superior a través de la palabra clave “Throws” en la definición de nuestro
			 * método.
			 */
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		/*
		 * Por último mostramos una estrategia implementada en código para conectarnos a
		 * cualquier bbdd. Podemos enganchar con PHP para ver algo de full-stack
		 */

		/*
		 * private Connection getDBConnection(String Driver, String url, String usuario,
		 * String password) { Connection connection = null; try { Class.forName(Driver);
		 * connection= DriverManager.getConnection(url, usuario, password); } catch
		 * (ClassNotFoundException e) { e.printStackTrace(); } catch (SQLException e) {
		 * e.printStackTrace(); } return connection;}
		 */
	}
}
