package libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GeneroDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/libreria";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void insertarGenero(Scanner scanner) throws SQLException {
        System.out.println("--- Insertar Género ---");
        System.out.print("ID del género: ");
        int idGenero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre del género: ");
        String nombreGenero = scanner.nextLine();

        String sql = "INSERT INTO genero (id_genero, nombre_genero) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idGenero);
            pstmt.setString(2, nombreGenero);
            pstmt.executeUpdate();
            System.out.println("Género insertado correctamente.");
        }
    }

    public static void listarGeneros() throws SQLException {
        System.out.println("--- Listado de Géneros ---");
        String sql = "SELECT id_genero, nombre_genero FROM genero";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_genero") + ", Género: " + rs.getString("nombre_genero"));
            }
        }
    }

    public static void actualizarGenero(Scanner scanner) throws SQLException {
        System.out.println("--- Actualizar Género ---");
        System.out.print("ID del género a actualizar: ");
        int idGenero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre del género: ");
        String nuevoNombre = scanner.nextLine();

        String sql = "UPDATE genero SET nombre_genero = ? WHERE id_genero = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoNombre);
            pstmt.setInt(2, idGenero);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Género actualizado correctamente.");
            } else {
                System.out.println("No se encontró el género con ID: " + idGenero);
            }
        }
    }

    public static void eliminarGenero(Scanner scanner) throws SQLException {
        System.out.println("--- Eliminar Género ---");
        System.out.print("ID del género a eliminar: ");
        int idGenero = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM genero WHERE id_genero = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idGenero);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Género eliminado correctamente.");
            } else {
                System.out.println("No se encontró el género con ID: " + idGenero);
            }
        }
    }
}