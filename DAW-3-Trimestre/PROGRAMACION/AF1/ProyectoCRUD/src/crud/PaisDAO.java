package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PaisDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/pelis";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void insertarPais(Scanner scanner) throws SQLException {
        System.out.println("--- Insertar País ---");
        System.out.print("Nombre del país: ");
        String nombre = scanner.nextLine();

        String sql = "INSERT INTO pais (nombrePais) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
            System.out.println("País insertado correctamente.");

        }
    }

    public static void mostrarPais(int idPais) throws SQLException {
        String sql = "SELECT idPais, nombrePais FROM pais WHERE idPais = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPais);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("idPais") + ", Nombre: " + rs.getString("nombrePais"));
            } else {
                System.out.println("No se encontró el país con ID: " + idPais);
            }
        }
    }

    public static void actualizarPais(Scanner scanner) throws SQLException {
        System.out.println("--- Actualizar País ---");
        System.out.print("ID del país a actualizar: ");
        int idPais = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre del país: ");
        String nombre = scanner.nextLine();

        String sql = "UPDATE pais SET nombrePais = ? WHERE idPais = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setInt(2, idPais);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("País actualizado correctamente.");
            } else {
                System.out.println("No se encontró el país con ID: " + idPais);
            }

        }
    }

    public static void eliminarPais(Scanner scanner) throws SQLException {
        System.out.println("--- Eliminar País por ID ---");
        System.out.print("ID del país a eliminar: ");
        int paisId = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM pais WHERE idPais = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, paisId);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("País eliminado correctamente.");
            } else {
                System.out.println("No se encontró el país con ID: " + paisId);
            }

        }
    }
}