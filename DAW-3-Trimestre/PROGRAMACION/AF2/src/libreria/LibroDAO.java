package libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LibroDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/libreria";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void insertarLibro(Scanner scanner) throws SQLException {
        System.out.println("--- Insertar Libro ---");
        System.out.print("ID del libro: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int anioPublicacion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID del autor: ");
        int idAutor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID del género: ");
        int idGenero = scanner.nextInt();
        scanner.nextLine();

        String sql = "INSERT INTO libro (id_libro, titulo, anio_publicacion, id_autor, id_genero) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idLibro);
            pstmt.setString(2, titulo);
            pstmt.setInt(3, anioPublicacion);
            pstmt.setInt(4, idAutor);
            pstmt.setInt(5, idGenero);
            pstmt.executeUpdate();
            System.out.println("Libro insertado correctamente.");
        }
    }

    public static void listarLibros() throws SQLException {
        System.out.println("--- Listado de Libros ---");
        String sql = "SELECT id_libro, titulo, anio_publicacion, id_autor, id_genero FROM libro";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_libro") + ", Título: " + rs.getString("titulo") + ", Año: " + rs.getInt("anio_publicacion") + ", Autor: " + rs.getInt("id_autor") + ", Género: " + rs.getInt("id_genero"));
            }
        }
    }

    public static void actualizarLibro(Scanner scanner) throws SQLException {
        System.out.println("--- Actualizar Libro ---");
        System.out.print("ID del libro a actualizar: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo título del libro: ");
        String nuevoTitulo = scanner.nextLine();
        System.out.print("Nuevo año de publicación: ");
        int nuevoAnioPublicacion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo ID del autor: ");
        int nuevoIdAutor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo ID del género: ");
        int nuevoIdGenero = scanner.nextInt();
        scanner.nextLine();

        String sql = "UPDATE libro SET titulo = ?, anio_publicacion = ?, id_autor = ?, id_genero = ? WHERE id_libro = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoTitulo);
            pstmt.setInt(2, nuevoAnioPublicacion);
            pstmt.setInt(3, nuevoIdAutor);
            pstmt.setInt(4, nuevoIdGenero);
            pstmt.setInt(5, idLibro);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Libro actualizado correctamente.");
            } else {
                System.out.println("No se encontró el libro con ID: " + idLibro);
            }
        }
    }

    public static void eliminarLibro(Scanner scanner) throws SQLException {
        System.out.println("--- Eliminar Libro ---");
        System.out.print("ID del libro a eliminar: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM libro WHERE id_libro = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idLibro);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Libro eliminado correctamente.");
            } else {
                System.out.println("No se encontró el libro con ID: " + idLibro);
            }
        }
    }
}