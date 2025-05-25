
package biblioteca;

import java.sql.*;

public class SocioDAO {

    public void insertarSocio(int id, String nombre, String direccion) {
        String sql = "INSERT INTO socios_obj VALUES (?,?,?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, direccion);
            stmt.executeUpdate();
            System.out.println("Socio insertado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarSocios() {
        String sql = "SELECT * FROM socios_obj";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + 
                                   ", Nombre: " + rs.getString(2) + 
                                   ", Dirección: " + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void actualizarSocio(int id, String nuevoNombre, String nuevaDireccion) {
        String sql = "UPDATE socios_obj SET nombre = ?, direccion = ? WHERE id_autor = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevaDireccion);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Socio actualizado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarSocio(int id) {
        String sql = "DELETE FROM socios_obj WHERE id_socio = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Socio eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

