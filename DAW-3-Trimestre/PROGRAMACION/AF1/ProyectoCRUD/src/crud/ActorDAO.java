package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ActorDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/pelis";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void insertarActor(Scanner scanner) throws SQLException {
        System.out.println("--- Insertar Actor ---");
        System.out.print("Nombre del actor: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del país del actor: ");
        int nacionalidadActor = scanner.nextInt(); // Usando el nombre de tu columna
        scanner.nextLine();

        String sql = "INSERT INTO actor (nombreActor, nacionalidadActor) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setInt(2, nacionalidadActor);
            pstmt.executeUpdate();
            System.out.println("Actor insertado correctamente.");

        }
    }

    public static void listarActoresConPais() throws SQLException {
        System.out.println("--- Listado de Actores con País ---");
        String sql = "SELECT a.idActor, a.nombreActor, p.nombrePais FROM actor a JOIN pais p ON a.nacionalidadActor = p.idPais";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean hayActores = false;
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idActor") + ", Actor: " + rs.getString("nombreActor") + ", País: " + rs.getString("nombrePais"));
                hayActores = true;
            }
            if (!hayActores) {
                System.out.println("No hay actores registrados.");
            }

        }
    }

    public static void actualizarNombreActor(Scanner scanner) throws SQLException {
        System.out.println("--- Actualizar Nombre de Actor ---");
        System.out.print("ID del actor a actualizar: ");
        int actorId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre del actor: ");
        String nuevoNombre = scanner.nextLine();

        String sql = "UPDATE actor SET nombreActor = ? WHERE idActor = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoNombre);
            pstmt.setInt(2, actorId);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Nombre del actor actualizado correctamente.");
            } else {
                System.out.println("No se encontró el actor con ID: " + actorId);
            }

        }
    }

    public static void eliminarActor(Scanner scanner) throws SQLException {
        System.out.println("--- Eliminar Actor por ID ---");
        System.out.print("ID del actor a eliminar: ");
        int actorId = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM actor WHERE idActor = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, actorId);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Actor eliminado correctamente.");
            } else {
                System.out.println("No se encontró el actor con ID: " + actorId);
            }

        }
    }
}