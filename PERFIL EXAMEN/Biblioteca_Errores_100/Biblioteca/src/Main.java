import dao.AutorDAO;
import model.Autor;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutorDAO autorDAO = new AutorDAO();
        int opcion;
        do {
            System.out.println("\n--- Menú Autor ---");
            System.out.println("1. Insertar autor");
            System.out.println("2. Listar autores");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Nacionalidad: ");
                    String nacionalidad = scanner.nextLine();
                    autorDAO.insertar(new Autor(nombre, nacionalidad));
                    break;
                case 2:
                    List<Autor> lista = autorDAO.obtenerTodos();
                    for (Autor a : lista) {
                        System.out.println(a);
                    }
                    break;

            }
        } while (opcion != 3);
        scanner.close();
    }
}

