
package biblioteca;

import java.sql.*;

public class PrestamoDAO {

	public void insertarPrestamo(int id, Date fecha, int id_socio, String nombre_socio, String direccion, int id_libro,
			String genero, int id_autor, String nombre_autor, String nacionalidad) {
		String sql = "INSERT INTO prestamos_obj VALUES (?,?, tipo_socio (?, ?, ?), tipo_libro (?, ?, tipo_autor (?, ?, ?)))";
		try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.setDate(2, fecha);
			stmt.setInt(3, id_socio);
			stmt.setString(4, nombre_socio);
			stmt.setString(5, direccion);
			stmt.setInt(6, id_libro);
			stmt.setString(7, genero);
			stmt.setInt(8, id_autor);
			stmt.setString(9, nombre_autor);
			stmt.setString(10, nacionalidad);
			stmt.executeUpdate();
			System.out.println("Prestamo insertado.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void listarPrestamos() {
		String sql = "SELECT * FROM prestamos_obj";
		try (Connection conn = Conexion.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt(1) + ", Fecha: " + rs.getDate(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
