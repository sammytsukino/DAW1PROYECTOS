package dao;
import model.Autor;
import util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    public void insertar(Autor autor) {
        String sql = "INSERT INTO autor (nombre, nacionalidad) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor.getNombre());
            stmt.setString(2, autor.getNacionalidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Autor> obtenerTodos() {
        List<Autor> lista = new ArrayList<>();
        String sql = "SELECT * FROM autor";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Autor(rs.getInt("id"), rs.getString("nombre"), rs.getString("nacionalidad")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

