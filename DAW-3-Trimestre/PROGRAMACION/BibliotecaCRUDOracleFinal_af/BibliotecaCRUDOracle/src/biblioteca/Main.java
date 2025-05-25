
package biblioteca;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AutorDAO autorDAO = new AutorDAO();
        LibroDAO libroDAO = new LibroDAO();
        SocioDAO socioDAO = new SocioDAO();
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE BIBLIOTECA ---");
            System.out.println("1. Insertar autor");
            System.out.println("2. Listar autores");
            System.out.println("3. Insertar libro");
            System.out.println("4. Listar libros");
            System.out.println("5. Insertar socio");
            System.out.println("6. Listar socios");
            System.out.println("7. Insertar préstamo");
            System.out.println("8. Listar préstamos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nacionalidad: ");
                    String nac = sc.nextLine();
                    autorDAO.insertarAutor(id, nombre, nac);
                    break;
                case 2:
                    autorDAO.listarAutores();
                    break;
                case 3:
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Año: ");
                    int anio = sc.nextInt(); sc.nextLine();
                    System.out.print("ID autor: ");
                    int idAutor = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre autor: ");
                    String nomAutor = sc.nextLine();
                    System.out.print("Nacionalidad autor: ");
                    String nacAutor = sc.nextLine();
                    libroDAO.insertarLibro(isbn, titulo, anio, idAutor, nomAutor, nacAutor);
                    break;
                case 4:
                    libroDAO.listarLibros();
                    break;
                case 5:
                    System.out.print("ID socio: ");
                    int idSoc = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre socio: ");
                    String nomSoc = sc.nextLine();
                    System.out.print("Dirección: ");
                    String dir = sc.nextLine();
                    socioDAO.insertarSocio(idSoc, nomSoc, dir);
                    break;
                case 6:
                    socioDAO.listarSocios();
                    break;
                case 7:
                	 System.out.print("ID préstamo: ");
                	    int idPres = sc.nextInt(); sc.nextLine();

                	    System.out.print("Fecha (YYYY-MM-DD): ");
                	    String fechaStr = sc.nextLine();
                	    Date fecha = Date.valueOf(fechaStr); // Convertir string a java.sql.Date

                	    System.out.print("ID socio: ");
                	    int idSocio = sc.nextInt(); sc.nextLine();
                	    System.out.print("Nombre socio: ");
                	    String nombreSocio = sc.nextLine();
                	    System.out.print("Dirección socio: ");
                	    String direccionSocio = sc.nextLine();

                	    System.out.print("ID libro: ");
                	    int idLibro = sc.nextInt(); sc.nextLine();
                	    System.out.print("Género del libro: ");
                	    String genero = sc.nextLine();

                	    System.out.print("ID autor: ");
                	    int idAutorP = sc.nextInt(); sc.nextLine();
                	    System.out.print("Nombre autor: ");
                	    String nombreAutor = sc.nextLine();
                	    System.out.print("Nacionalidad autor: ");
                	    String nacionalidad = sc.nextLine();

                	    prestamoDAO.insertarPrestamo(
                	        idPres, fecha, idSocio, nombreSocio, direccionSocio,
                	        idLibro, genero, idAutorP, nombreAutor, nacionalidad
                	    );
                	    break;
                case 8:
                    prestamoDAO.listarPrestamos();
                    break;
            }
        } while (opcion != 0);
    }
}
