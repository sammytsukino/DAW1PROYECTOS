package dao;
import model.Socio;
import util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SocioDAO {

    public void insertar(Socio socio) {
        String sql = "INSERT INTO socio (nombre, email) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, socio.getNombre());
            stmt.setString(2, socio.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Socio> obtenerTodos() {
        List<Socio> lista = new ArrayList<>();
        String sql = "SELECT * FROM socio";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Socio(rs.getInt("id"), rs.getString("nombre"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}