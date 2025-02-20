import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("Ingrese una opción");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Modificar precio");
            System.out.println("5. Eliminar producto");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    inventario.agregarProducto(teclado);
                    System.out.println("Producto agregado.");
                    break;
                case 2:
                    inventario.mostrarProductos();
                    break;
                case 3:
                    String nombreBusqueda = teclado.nextLine();
                    inventario.buscarProducto(nombreBusqueda);
                    break;
                case 4:
                System.out.println("Ingrese el nuevo precio:");
                double nuevoPrecio = Double.parseDouble(teclado.nextLine());
                inventario.modificarPrecio(nuevoPrecio);
                    break;
                case 5:
                    // Aquí puedes agregar la lógica para eliminar un producto
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);

        teclado.close();
    }
}