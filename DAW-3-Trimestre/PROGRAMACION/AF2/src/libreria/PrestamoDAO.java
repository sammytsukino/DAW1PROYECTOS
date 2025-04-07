package libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PrestamoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/libreria";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void insertarPrestamo(Scanner scanner) throws SQLException {
        System.out.println("--- Insertar Préstamo ---");
        System.out.print("ID del libro: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fecha de préstamo (YYYY-MM-DD): ");
        String fechaPrestamo = scanner.nextLine();
        System.out.print("Devuelto (true/false): ");
        boolean devuelto = scanner.nextBoolean();
        scanner.nextLine();

        String sql = "INSERT INTO prestamo (id_libro, fecha_prestamo, devuelto) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idLibro);
            pstmt.setString(2, fechaPrestamo);
            pstmt.setBoolean(3, devuelto);
            pstmt.executeUpdate();
            System.out.println("Préstamo insertado correctamente.");
        }
    }

    public static void listarPrestamos() throws SQLException {
        System.out.println("--- Listado de Préstamos ---");
        String sql = "SELECT id_libro, fecha_prestamo, devuelto FROM prestamo";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID Libro: " + rs.getInt("id_libro") + ", Fecha Préstamo: " + rs.getString("fecha_prestamo") + ", Devuelto: " + rs.getBoolean("devuelto"));
            }
        }
    }

    public static void actualizarPrestamo(Scanner scanner) throws SQLException {
        System.out.println("--- Actualizar Préstamo ---");
        System.out.print("ID del libro: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nueva fecha de préstamo (YYYY-MM-DD): ");
        String nuevaFechaPrestamo = scanner.nextLine();
        System.out.print("Devuelto (true/false): ");
        boolean nuevoDevuelto = scanner.nextBoolean();
        scanner.nextLine();

        String sql = "UPDATE prestamo SET fecha_prestamo = ?, devuelto = ? WHERE id_libro = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevaFechaPrestamo);
            pstmt.setBoolean(2, nuevoDevuelto);
            pstmt.setInt(3, idLibro);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Préstamo actualizado correctamente.");
            } else {
                System.out.println("No se encontró el préstamo con ID de libro: " + idLibro);
            }
        }
    }

    public static void eliminarPrestamo(Scanner scanner) throws SQLException {
        System.out.println("--- Eliminar Préstamo ---");
        System.out.print("ID del libro: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM prestamo WHERE id_libro = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idLibro);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Préstamo eliminado correctamente.");
            } else {
                System.out.println("No se encontró el préstamo con ID de libro: " + idLibro);
            }
        }
    }
}