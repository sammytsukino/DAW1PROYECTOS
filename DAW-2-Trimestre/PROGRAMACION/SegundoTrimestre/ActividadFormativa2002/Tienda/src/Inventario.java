import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = 0.0;
        while (true) {
            String precioString = scanner.nextLine();
            try {
                precio = Double.parseDouble(precioString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Precio no válido. Por favor, ingrese un número.");
            }
        }

        Producto producto = new Producto(nombre, precio);
        productos.add(producto);
        System.out.println("Producto agregado.");
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void buscarProducto(String nombreBusqueda) {
        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                System.out.println("Producto encontrado: " + producto);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El producto " + nombreBusqueda + " no se encuentra en la lista.");
        }
    }

    public void modificarPrecio(Scanner scanner, String nombreProducto, double nuevoPrecio) {
        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                producto.setPrecio(nuevoPrecio);
                System.out.println("El precio del producto " + nombreProducto + " ha sido modificado a " + nuevoPrecio);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El producto " + nombreProducto + " no se encuentra en la lista.");
        }
    }

    public void eliminarProducto(String nombreEliminado) {
        boolean eliminado = false;
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreEliminado)) {
                productos.remove(producto);
                System.out.println("El producto " + nombreEliminado + " ha sido eliminado.");
                eliminado = true;
                break;
            }
        }

        if (!eliminado) {
            System.out.println("El producto " + nombreEliminado + " no se encuentra en la lista.");
        }
    }
}