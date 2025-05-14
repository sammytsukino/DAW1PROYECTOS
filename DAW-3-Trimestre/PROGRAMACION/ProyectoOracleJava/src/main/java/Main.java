package main.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "SYS AS SYSDBA";
        String contrasena = "miguel";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena)) {
            System.out.println("Conexión exitosa a Oracle.");

            List<Telefono> telefonos = new ArrayList<>();
            telefonos.add(new Telefono("Móvil", "123456789"));
            telefonos.add(new Telefono("Casa", "987654321"));
            Cliente cliente = new Cliente(1, "Fernando Garcia", telefonos);

            String insertSql = "INSERT INTO clientes_tabla VALUES (cliente_obj(?, ?, lista_telefonos(telefono_obj(?, ?), telefono_obj(?, ?))))";
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                ps.setInt(1, cliente.getIdCliente());
                ps.setString(2, cliente.getNombre());
                ps.setString(3, cliente.getTelefonos().get(0).getTipo());
                ps.setString(4, cliente.getTelefonos().get(0).getNumero());
                ps.setString(5, cliente.getTelefonos().get(1).getTipo());
                ps.setString(6, cliente.getTelefonos().get(1).getNumero());
                ps.executeUpdate();
                System.out.println("Cliente insertado exitosamente.");
            }

            String selectSql = "SELECT c.id_cliente, c.nombre FROM clientes_tabla c";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSql)) {
                while (rs.next()) {
                    int id = rs.getInt("id_cliente");
                    String nombre = rs.getString("nombre");
                    System.out.println("Cliente encontrado: " + nombre + " (ID: " + id + ")");
                }
            }

            String updateSql = "UPDATE clientes_tabla c SET c.nombre = ? WHERE c.id_cliente = ?";
            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                ps.setString(1, "Fernando García Modificado");
                ps.setInt(2, 1);
                int filas = ps.executeUpdate();
                System.out.println("Filas actualizadas: " + filas);
            }

            String deleteSql = "DELETE FROM clientes_tabla c WHERE c.id_cliente = ?";
            try (PreparedStatement ps = conn.prepareStatement(deleteSql)) {
                ps.setInt(1, 1);
                int filas = ps.executeUpdate();
                System.out.println("Filas eliminadas: " + filas);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
