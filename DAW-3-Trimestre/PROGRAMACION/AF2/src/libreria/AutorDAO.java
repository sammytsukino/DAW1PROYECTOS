package libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AutorDAO {
	
	

    private static final String URL = "jdbc:mysql://localhost:3306/libreria";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    
    public static void mostrarMenu(Scanner scanner) throws SQLException {
        int opcion;
        do {
            System.out.println("\n--- Menú Autor ---");
            System.out.println("1. Insertar Autor");
            System.out.println("2. Listar Autores");
            System.out.println("3. Actualizar Autor");
            System.out.println("4. Eliminar Autor");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    insertarAutor(scanner);
                    break;
                case 2:
                    listarAutores();
                    break;
                case 3:
                    actualizarAutor(scanner);
                    break;
                case 4:
                    eliminarAutor(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del menú Autor.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    public static void insertarAutor(Scanner scanner) throws SQLException {
        System.out.println("--- Insertar Autor ---");
        System.out.print("ID del autor: ");
        int idAutor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("Nacionalidad del autor: ");
        String nacionalidad = scanner.nextLine();

        String sql = "INSERT INTO autor (id_autor, nombre_autor, nacionalidad) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idAutor);
            pstmt.setString(2, nombreAutor);
            pstmt.setString(3, nacionalidad);
            pstmt.executeUpdate();
            System.out.println("Autor insertado correctamente.");
        }
    }

    public static void listarAutores() throws SQLException {
        System.out.println("--- Listado de Autores ---");
        String sql = "SELECT id_autor, nombre_autor, nacionalidad FROM autor";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_autor") + ", Autor: " + rs.getString("nombre_autor") + ", Nacionalidad: " + rs.getString("nacionalidad"));
            }
        }
    }

    public static void actualizarAutor(Scanner scanner) throws SQLException {
        System.out.println("--- Actualizar Autor ---");
        System.out.print("ID del autor a actualizar: ");
        int idAutor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre del autor: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Nueva nacionalidad del autor: ");
        String nuevaNacionalidad = scanner.nextLine();

        String sql = "UPDATE autor SET nombre_autor = ?, nacionalidad = ? WHERE id_autor = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevaNacionalidad);
            pstmt.setInt(3, idAutor);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Autor actualizado correctamente.");
            } else {
                System.out.println("No se encontró el autor con ID: " + idAutor);
            }
        }
    }

    public static void eliminarAutor(Scanner scanner) throws SQLException {
        System.out.println("--- Eliminar Autor ---");
        System.out.print("ID del autor a eliminar: ");
        int idAutor = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM autor WHERE id_autor = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idAutor);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Autor eliminado correctamente.");
            } else {
                System.out.println("No se encontró el autor con ID: " + idAutor);
            }
        }
    }
}