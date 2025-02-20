import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    private ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.agregarProducto(new Scanner(System.in));
    }

    Scanner scanner = new Scanner(System.in);

    public void agregarProducto(Scanner scanner) {

        String nombre;
        double precio = 0.0;
        System.out.print("Ingrese el nombre del producto: ");
        nombre = scanner.nextLine();

        String precioString;
        String regex = "\\d+(\\.\\d{1,2})?";

        System.out.println("Ingrese el precio del producto: ");
        precioString = scanner.nextLine();

        while (!precioString.matches(regex)) {
            System.out.println("Ingrese un precio valido: ");
            precioString = scanner.nextLine();
        }

        try {
            precio = Double.parseDouble(precioString);
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un precio valido: ");
        }

        Producto producto = new Producto(nombre, precio);
        productos.add(producto);
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void buscarProducto(String nombreBusqueda) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto a buscar: ");
        nombreBusqueda = scanner.nextLine();
        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("El nombre " + nombreBusqueda + " se encuentra en la lista.");
        } else {
            System.out.println("El nombre " + nombreBusqueda + " no se encuentra en la lista.");
        }
        scanner.close();
    }

    public void modificarPrecio(double precio){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nuevo precio: ");
        precio = scanner.nextDouble();
        scanner.close();
        System.out.println("El nuevo precio es:" + precio);
    }

    public void eliminarProducto(String nombreEliminado) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto a buscar: ");
        nombreEliminado = scanner.nextLine();
        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreEliminado)) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("El nombre " + nombreEliminado + " se encuentra en la lista.");
        } else {
            System.out.println("El nombre " + nombreEliminado + " no se encuentra en la lista.");
        }
        scanner.close();
    }

    }
