package biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibroDAO {

	public void insertarLibro(String isbn, String titulo, int anio, int idAutor, String nomAutor, String nacAutor) {
		String sql = "INSERT INTO libros_obj VALUES (?,?, tipo_autor (?, ?, ?))";
		try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, isbn);
			stmt.setString(2, titulo);
			stmt.setInt(3, anio);
			stmt.setInt(4, idAutor);
			stmt.setString(5, nomAutor);
			stmt.setString(6, nacAutor);
			stmt.executeUpdate();
			System.out.println("Libro insertado.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void listarLibros() {
		String sql = "SELECT isbn, titulo, anio, autor.id_autor, autor.nombre, autor.nacionalidad FROM libros_obj";
		try (Connection conn = Conexion.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println("ISBN: " + rs.getString(1) + ", Titulo: " + rs.getString(2) + ", Anio: "
						+ rs.getInt(3) + "ID Autor:" + rs.getInt(4) + "Nombre:" + rs.getString(5) + "Nacionalidad:"
						+ rs.getString(6)

				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
