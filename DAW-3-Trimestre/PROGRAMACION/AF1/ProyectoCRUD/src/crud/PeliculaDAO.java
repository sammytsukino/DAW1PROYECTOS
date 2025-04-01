package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PeliculaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/pelis";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void insertarPelicula(Scanner scanner) throws SQLException {
        System.out.println("--- Insertar Película ---");
        System.out.print("Título de la película: ");
        String titulo = scanner.nextLine();
        System.out.print("ID del director: ");
        int directorPelicula = scanner.nextInt();
        System.out.print("ID del género: ");
        int generoPelicula = scanner.nextInt();
        System.out.print("Año de la película: ");
        int anyoPelicula = scanner.nextInt();
        System.out.print("Duración de la película (minutos): ");
        int duracionPelicula = scanner.nextInt();
        scanner.nextLine();

        String sql = "INSERT INTO pelicula (tituloPelicula, directorPelicula, generoPelicula, anyoPelicula, duracionPelicula) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, titulo);
            pstmt.setInt(2, directorPelicula);
            pstmt.setInt(3, generoPelicula);
            pstmt.setInt(4, anyoPelicula);
            pstmt.setInt(5, duracionPelicula);
            pstmt.executeUpdate();
            System.out.println("Película insertada correctamente.");

        }
    }

    public static void listarPeliculasConGeneroDirector() throws SQLException {
        System.out.println("--- Listado de Películas con Género y Director ---");
        String sql = "SELECT p.tituloPelicula, g.nombreGenero, d.nombreDirector FROM pelicula p JOIN genero g ON p.generoPelicula = g.idGenero JOIN director d ON p.directorPelicula = d.idDirector";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean hayPeliculas = false;
            while (rs.next()) {
                System.out.println("Título: " + rs.getString("tituloPelicula") + ", Género: " + rs.getString("nombreGenero") + ", Director: " + rs.getString("nombreDirector"));
                hayPeliculas = true;
            }
            if (!hayPeliculas) {
                System.out.println("No hay películas registradas.");
            }

        }
    }

    public static void actualizarPelicula(Scanner scanner) throws SQLException {
        System.out.println("Ingrese el ID de la pelicula a actualizar ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese nuevo título: ");
        String titulo = scanner.nextLine();

        String sql = "UPDATE pelicula SET tituloPelicula = ? WHERE idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, titulo);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Película actualizada correctamente.");
            } else {
                System.out.println("No se encontró la película con ID: " + id);
            }

        }
    }

    public static void eliminarPelicula(Scanner scanner) throws SQLException {
        System.out.println("Ingrese el ID de la pelicula a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM pelicula WHERE idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Película eliminada correctamente.");
            } else {
                System.out.println("No se encontró la película con ID: " + id);
            }

        }
    }
}