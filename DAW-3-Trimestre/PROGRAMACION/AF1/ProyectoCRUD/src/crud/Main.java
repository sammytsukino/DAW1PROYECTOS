package crud;

import java.util.Scanner;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Insertar Actor");
            System.out.println("2. Insertar Película");
            System.out.println("3. Insertar País");
            System.out.println("4. Listar Actores con País");
            System.out.println("5. Actualizar Nombre de Actor");
            System.out.println("6. Eliminar Actor por ID");
            System.out.println("7. Listar Películas con Género y Director");
            System.out.println("8. Eliminar País por ID");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            try {
                switch (opcion) {
                    case 1:
                        ActorDAO.insertarActor(scanner);
                        break;
                    case 2:
                        PeliculaDAO.insertarPelicula(scanner);
                        break;
                    case 3:
                        PaisDAO.insertarPais(scanner);
                        break;
                    case 4:
                        ActorDAO.listarActoresConPais();
                        break;
                    case 5:
                        ActorDAO.actualizarNombreActor(scanner);
                        break;
                    case 6:
                        ActorDAO.eliminarActor(scanner);
                        break;
                    case 7:
                        PeliculaDAO.listarPeliculasConGeneroDirector();
                        break;
                    case 8:
                        PaisDAO.eliminarPais(scanner);
                        break;
                    case 9:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (SQLException e) {
                System.err.println("Error al interactuar con la base de datos: " + e.getMessage());
                e.printStackTrace();
            }
        } while (opcion != 9);

        scanner.close();
    }
}