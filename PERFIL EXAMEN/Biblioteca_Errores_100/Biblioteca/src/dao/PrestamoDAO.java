package dao;

import model.Prestamo;
import util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    public void insertar(Prestamo prestamo) {
        String sql = "INSERT INTO prestamo (id_libro, id_socio, fecha_prestamo, fecha_devolucion) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, prestamo.getIdLibro());
            stmt.setInt(2, prestamo.getIdSocio());
            stmt.setDate(3, prestamo.getFechaPrestamo());
            stmt.setDate(4, prestamo.getFechaDevolucion());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al insertar préstamo: " + e.getMessage());
        }
    }

    public List<Prestamo> obtenerTodos() {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM prestamo";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int idLibro = rs.getInt("id_libro");
                int idSocio = rs.getInt("id_socio");
                Date fechaPrestamo = rs.getDate("fecha_prestamo");
                Date fechaDevolucion = rs.getDate("fecha_devolucion");

                Prestamo prestamo = new Prestamo(id, idLibro, idSocio, fechaPrestamo, fechaDevolucion);
                lista.add(prestamo);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener préstamos: " + e.getMessage());
        }

        return lista;
    }
}
