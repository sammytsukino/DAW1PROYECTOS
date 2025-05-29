import java.sql.*;
import java.util.Scanner;

public class MainAsignaciones {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "tu_usuario";
        String contrasena = "tu_contraseña";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conexión establecida con Oracle.");
            while (true) {
                System.out.println("\n--- MENÚ GESTIÓN ASIGNACIONES ---");
                System.out.println("1. Insertar asignación");
                System.out.println("2. Listar asignaciones");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");
                int opcion = scanner.nextInt(); scanner.nextLine();

                switch (opcion) {
                case 1:
                    System.out.print("ID Asignación: ");
                    int idAsignacion = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();

                    System.out.print("ID Trabajador: ");
                    int idTrabajador = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nombre Trabajador: ");
                    String nombreTrab = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = scanner.nextLine();

                    System.out.print("ID Proyecto: ");
                    int idProyecto = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nombre Proyecto: ");
                    String nombreProyecto = scanner.nextLine();
                    System.out.print("Fecha inicio proyecto (YYYY-MM-DD): ");
                    String fechaInicio = scanner.nextLine();

                    System.out.print("ID Camino: ");
                    int idCamino = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nombre Camino: ");
                    String nombreCamino = scanner.nextLine();
                    System.out.print("Longitud: ");
                    double longitud = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Tipo Terreno: ");
                    String terreno = scanner.nextLine();

                    String insertSQL = """
                        INSERT INTO asignaciones_obj 
                        VALUES (
                            tipo_asignacion(
                                ?, 
                                TO_DATE(?, 'YYYY-MM-DD'), 
                                tipo_trabajador(?, ?, ?),
                                tipo_proyecto(?, ?, TO_DATE(?, 'YYYY-MM-DD'), tipo_camino(?, ?, ?, ?))
                            )
                        )
                    """;

                    try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {
                        ps.setInt(1, idAsignacion);         
                        ps.setString(2, fecha);             
                        ps.setInt(3, idTrabajador);          
                        ps.setString(4, nombreTrab);         
                        ps.setString(5, especialidad);       
                        ps.setInt(6, idProyecto);            
                        ps.setString(7, nombreProyecto);    
                        ps.setString(8, fechaInicio);     
                        ps.setInt(9, idCamino);            
                        ps.setString(10, nombreCamino);     
                        ps.setDouble(11, longitud);         
                        ps.setString(12, terreno);          

                        ps.executeUpdate();
                        System.out.println("Asignación insertada correctamente.");
                    } catch (SQLException e) {
                        System.out.println("Error al insertar asignación: " + e.getMessage());
                    }
                    break;


                    case 2:
                        String selectSQL = "SELECT * FROM asignaciones_obj";
                        try (Statement stmt = conn.createStatement();
                             ResultSet rs = stmt.executeQuery(selectSQL)) {

                            while (rs.next()) {
                                System.out.printf(
                                    "Asignación ID: %d | Fecha: %s | Trabajador: %s (%s) | Proyecto: %s | Camino: %s%n",
                                    rs.getInt("id_asignacion"),
                                    rs.getDate("fecha"),
                                    rs.getString("trabajador"),
                                    rs.getString("especialidad"),
                                    rs.getString("proyecto"),
                                    rs.getString("camino")
                                );
                            }

                        } catch (SQLException e) {
                            System.out.println("Error al consultar asignaciones: " + e.getMessage());
                        }
                        break;


                    case 3:
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opción inválida.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
