package listas;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Inventario {
	private final static Scanner scanner=new Scanner(System.in);
	private final static ArrayList<Producto> listaProductos=new ArrayList<>();
	private final static Pattern precioPatron = Pattern.compile("^\\d+(\\.d{1,2})?$");
	public static void main (String [] args) {
		
		int opcion;
		do {
			mostrarMenu();
			opcion = obtenerEntero("Seleccione una opción; ");
			
			switch(opcion) {
			case 1-> agregarProducto();
			case 2-> buscarProducto();
			case 3-> modificarPrecio();
			case 4-> eliminarProducto();
			case 5-> mostrarProductos();
			case 6-> System.out.println("Estás saliendo del programa");
			default-> System.out.println("Opción no válida. Inténtelo nuevamente");
			}
		}while (opcion!=6);
	}
	private static int obtenerEntero(String mensaje) {
		int numero;
		while (true) {
			try {
				System.out.print(mensaje);
				numero=Integer.parseInt(scanner.nextLine());
				break;
			}catch (NumberFormatException e) {
				System.out.println("Error: Ingrese un número entero válido");
			}
		}
		return numero;
	}
	private static void mostrarMenu() {
		System.out.println("\n---- Menú para Inventario ----");
		System.out.println("1. Agregar Producto");
		System.out.println("2. Buscar Producto");
		System.out.println("3. Modificar Precio");
		System.out.println("4. Eliminar Producto");
		System.out.println("5. Mostrar Productos");
		System.out.println("6. Salir");
	}
	
	private static boolean validarPrecio(String precioStr) {
		if (!precioPatron.matcher(precioStr).matches()) {
			System.out.println("Error: Ingrese un precio válido (Ejemplo 75 o 75.50).");
			return false;
		}
		return true;
	}
	
	private static void agregarProducto() {
		System.out.println("Ingresa el nombre del producto");
		String nombre=scanner.nextLine();
		String precioStr;
		do {
			System.out.println("Ingresa el precio del producto");
			precioStr=scanner.nextLine();
		}while(!validarPrecio(precioStr));
		double precio=Double.parseDouble(precioStr);
		listaProductos.add(new Producto(nombre,precio));
	}
	private static void buscarProducto() {
		System.out.println("Ingresa el nombre del producto a buscar: ");
		String nombre =scanner.nextLine();
		
		for (Producto p:listaProductos) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("Producto encontrado: \n"+p.toString());
				return;
			}
		}
		System.out.println("Producto no encontrado.");
	}
	private static void modificarPrecio() {
		System.out.println("Ingresa el nombre del producto a modificar: ");
		String nombre =scanner.nextLine();
		for (Producto p:listaProductos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				String precioStr;
				do {
					System.out.println("Ingrese el nuevo precio: ");
					precioStr=scanner.nextLine();
				}while(!validarPrecio(precioStr));
				double nuevoPrecio=Double.parseDouble(precioStr);
				p.setPrecio(nuevoPrecio);		
				System.out.println("Precio modificado correctamente");
				return;
			}
		}
		System.out.println("Producto no encontrado.");
	}
	private static void eliminarProducto() {
		System.out.println("Ingresa el nombre del producto a eliminar: ");
		String nombre =scanner.nextLine();
		for (Producto p:listaProductos) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("Producto encontrado: \n"+p.toString());
				listaProductos.remove(p);
				return;
			}
		}
		System.out.println("Producto no encontrado.");
	}
	private static void mostrarProductos() {
		if (listaProductos.isEmpty()) {
			System.out.println("No hay productos");
		}
		else {
			System.out.println("\nLista de productos");
			for (Producto p:listaProductos) {
				System.out.println(p.toString());
			}
		}
	}
}
