import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("Ingrese una opción");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Modificar precio");
            System.out.println("5. Eliminar producto");
            System.out.println("0. Salir");

            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    inventario.agregarProducto(teclado);
                    break;
                case 2:
                    inventario.mostrarProductos();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del producto a buscar:");
                    String nombreBusqueda = teclado.nextLine();
                    inventario.buscarProducto(nombreBusqueda);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del producto a modificar:");
                    String nombreProducto = teclado.nextLine();
                    System.out.println("Ingrese el nuevo precio:");
                    try {
                        double nuevoPrecio = Double.parseDouble(teclado.nextLine());
                        inventario.modificarPrecio(teclado, nombreProducto, nuevoPrecio);
                    } catch (NumberFormatException e) {
                        System.out.println("Precio no válido. Por favor, ingrese un número.");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del producto a eliminar:");
                    String nombreEliminado = teclado.nextLine();
                    inventario.eliminarProducto(nombreEliminado);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

        teclado.close();
    }
}