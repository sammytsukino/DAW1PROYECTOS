
package biblioteca;

import java.sql.*;

public class AutorDAO {

    public void insertarAutor(int id, String nombre, String nacionalidad) {
        String sql = "INSERT INTO autores_obj VALUES (?,?,?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, nacionalidad);
            stmt.executeUpdate();
            System.out.println("Autor insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarAutores() {
        String sql = "SELECT * FROM autores_obj";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + 
                                   ", Nombre: " + rs.getString(2) + 
                                   ", Nacionalidad: " + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarAutor(int id, String nuevoNombre) {
        String sql = "UPDATE autores_obj SET nombre = ? WHERE id_autor = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nuevoNombre);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Autor actualizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarAutor(int id) {
        String sql = "DELETE FROM autores_obj WHERE id_autor = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Autor eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
