import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DAO {
	private static final String URL = "jdbc:mysql://localhost:3306/libreria";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	//agregar autor nuevo
	public static void agregarAutor(Scanner scanner) {
	    // Paso 1: Recoger datos del usuario mediante interacción
	    System.out.println("Dime el nombre del autor a agregar: ");
	    String nombreAutor = scanner.nextLine();
	    System.out.println("Dime la nacionalidad del autor: ");
	    int nacionalidadAutor = scanner.nextInt();
	    
	    // Paso 2: Preparar la sentencia SQL para la operación (INSERT)
	    String sql = "INSERT INTO autor (nombreAutor, nacionalidad) VALUES (?,?)";

	    // Paso 3: Establecer conexión con la base de datos
	    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	            // Paso 4: Crear el PreparedStatement con la sentencia SQL
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        // Paso 5: Establecer los valores para los parámetros de la consulta
	        stmt.setString(1, nombreAutor);
	        stmt.setInt(2, nacionalidadAutor);
	        
	        // Paso 6: Ejecutar la actualización en la base de datos
	        stmt.executeUpdate();
	        
	        // Paso 7: Informar al usuario del resultado de la operación
	        System.out.println("Nombre del autor añadido correctamente");

	    // Paso 8: Manejar posibles excepciones durante el proceso
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	// Mostrar la lista de autores
	public static void listarAutor() {
	    // Paso 1: Preparar la sentencia SQL para consulta (SELECT)
	    String sql = "SELECT * FROM autor";

	    // Paso 2: Establecer conexión con la base de datos
	    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	            // Paso 3: Crear el PreparedStatement con la sentencia SQL
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            // Paso 4: Ejecutar la consulta y obtener los resultados
	            ResultSet rs = stmt.executeQuery()) {

	        // Paso 5: Mostrar cabecera de los resultados
	        System.out.println("Listado de autores: \n");
	        
	        // Paso 6: Recorrer el conjunto de resultados y procesar cada fila
	        while (rs.next()) {
	            // Paso 7: Extraer los datos de cada columna de la fila actual
	            int id = rs.getInt("idAutor");
	            String nombre = rs.getString("nombreAutor");
	            String nacionalidad = rs.getString("nacionalidadAutor");

	            // Paso 8: Mostrar los datos extraídos al usuario
	            System.out.println("ID: " + id);
	            System.out.println("Nombre: " + nombre);
	            System.out.println("Nacionalidad: " + nacionalidad);
	            System.out.println("--------------------");
	        }

	    // Paso 9: Manejar posibles excepciones durante el proceso
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
		
		// Actualizar un nombre de la lista
		public static void actualizarAutor(Scanner scanner) {
		    // Paso 1: Recoger datos del usuario para la actualización
		    System.out.println("Ingrese el ID del autor a actualizar: ");
		    int id = scanner.nextInt();
		    scanner.nextLine(); // Consumir el salto de línea
		    System.out.println("Ingrese el nombre del autor: ");
		    String nombreNuevo = scanner.nextLine();

		    // Paso 2: Preparar la sentencia SQL para la actualización (UPDATE)
		    String sql = "UPDATE autor SET nombreAutor = ? WHERE idAutor = ?";

		    // Paso 3: Establecer conexión con la base de datos
		    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		            // Paso 4: Crear el PreparedStatement con la sentencia SQL
		            PreparedStatement stmt = conn.prepareStatement(sql)) {

		        // Paso 5: Establecer los valores para los parámetros de la consulta
		        // NOTA: Hay un error en el código original, los parámetros están invertidos
		        stmt.setString(1, nombreNuevo); // Debería ser el primer parámetro
		        stmt.setInt(2, id);             // Debería ser el segundo parámetro
		        
		        // Paso 6: Ejecutar la actualización y obtener número de filas afectadas
		        int rowsUpdate = stmt.executeUpdate();
		        
		        // Paso 7: Verificar el resultado e informar al usuario
		        if (rowsUpdate > 0) {
		            System.out.println("Autor actualizado correctamente");
		        } else {
		            System.out.println("No se encontró autor con el id: " + id);
		        }
		        
		    // Paso 8: Manejar posibles excepciones durante el proceso
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		// Eliminar autor
		public static void eliminarAutor(Scanner scanner) {
		    // Paso 1: Recoger datos del usuario para la eliminación
		    System.out.println("Ingrese el ID del autor a eliminar:");
		    int id = scanner.nextInt();
		    scanner.nextLine(); // Consumir el salto de línea
		    
		    // Paso 2: Preparar la sentencia SQL para la eliminación (DELETE)
		    String deleteActor = "DELETE FROM autor WHERE idAutor = ?";

		    // Paso 3: Establecer conexión con la base de datos
		    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		            // Paso 4: Crear el PreparedStatement con la sentencia SQL
		            PreparedStatement stmtAutor = conn.prepareStatement(deleteActor)) {

		        // Paso 5: Establecer el valor del parámetro (ID del autor a eliminar)
		        stmtAutor.setInt(1, id);
		        
		        // Paso 6: Ejecutar la eliminación y obtener número de filas afectadas
		        int rowDeleted = stmtAutor.executeUpdate();
		        
		        // Paso 7: Verificar el resultado e informar al usuario
		        if (rowDeleted > 0) {
		            System.out.println("El autor se ha eliminado correctamente");
		        } else {
		            System.out.println("No se ha encontrado ningun autor con ID: " + id);
		        }

		    // Paso 8: Manejar posibles excepciones durante el proceso
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
}