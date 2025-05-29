import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Ajustar a tu servidor
        String usuario = "tu_usuario";
        String contrasena = "tu_contraseña";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conexión establecida con Oracle.");
            while (true) {
                System.out.println("\n--- MENÚ GESTIÓN CAMINOS ---");
                System.out.println("1. Insertar camino");
                System.out.println("2. Listar caminos");
                System.out.println("3. Actualizar nombre de camino");
                System.out.println("4. Eliminar camino");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");
                int opcion = scanner.nextInt(); scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("ID Camino: ");
                        int id = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Longitud (km): ");
                        double longitud = scanner.nextDouble(); scanner.nextLine();
                        System.out.print("Tipo de terreno: ");
                        String tipoTerreno = scanner.nextLine();

                      
                        break;

                    case 2:
                       
                            while (rs.next()) {
                                System.out.printf("ID: %d, Nombre: %s, Longitud: %.2f km, Terreno: %s\n",
                                        rs.getInt("id_camino"), rs.getString("nombre"),
                                        rs.getDouble("longitud"), rs.getString("tipo_terreno"));
                            }
                        }
                        break;

                    case 3:
                        System.out.print("ID Camino a actualizar: ");
                        int idAct = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        String updateSQL = "UPDATE caminos_obj SET nombre = ? WHERE id_camino = ?";
                        try (PreparedStatement ps = conn.prepareStatement(updateSQL)) {
                            ps.setString(1, nuevoNombre);
                            ps.setInt(2, idAct);
                            int filas = ps.executeUpdate();
                            System.out.println(filas > 0 ? "Camino actualizado." : "Camino no encontrado.");
                        }
                        break;

                    case 4:
                        System.out.print("ID Camino a eliminar: ");
                        int idDel = scanner.nextInt(); scanner.nextLine();
                        String deleteSQL = "DELETE FROM caminos_obj WHERE id_camino = ?";
                        try (PreparedStatement ps = conn.prepareStatement(deleteSQL)) {
                            ps.setInt(1, idDel);
                            int filas = ps.executeUpdate();
                            System.out.println(filas > 0 ? "Camino eliminado." : "Camino no encontrado.");
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opción inválida.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en la conexión o ejecución SQL.");
            e.printStackTrace();
        }
    }
}
