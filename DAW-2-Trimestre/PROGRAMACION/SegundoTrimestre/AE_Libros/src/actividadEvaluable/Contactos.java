package actividadEvaluable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Contactos {

	public static void main(String[] args) {
	    String[] opciones = {"Guardar Nombres", "Leer Nombres", "Buscar Nombre", "Buscar Nombre", "Salir"};
	    
        while (true) {
            int opcion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Gestión de Nombres",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == -1) {
                break; // o System.exit(0);
            }
            
            switch (opcion) {
                case 0: 
                    guardarContactos();
                    break;
                case 1: 
                    leerContactos();
                    break;
                case 2: 
                    buscarNombre();
                    break;
                case 3: 
                    break;
                case 4: // Opción "Salir"
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    return; // Sale del método main y termina el programa
            }
        }
    }
	
	public static void leerContactos() {
		StringBuilder contacto = new StringBuilder(); // Crea un objeto StringBuilder para almacenar el contenido del archivo.

        try (FileInputStream fis = new FileInputStream("contactos.txt")) { // Intenta abrir el archivo "nombres.txt" para lectura utilizando un FileInputStream.
            int caracter; // Declara una variable para almacenar cada carácter leído del archivo.
            while ((caracter = fis.read()) != -1) { // Lee el archivo carácter por carácter hasta llegar al final (cuando read() devuelve -1).
            	contacto.append((char) caracter); // Convierte el carácter leído a char y lo agrega al StringBuilder.
            }

            JOptionPane.showMessageDialog(null, "Nombres guardados:\n" + contacto.toString()); // Muestra un mensaje con el contenido del archivo.
        } catch (IOException e) { // Captura cualquier excepción de entrada/salida que ocurra durante la lectura del archivo.
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // Muestra un mensaje de error con la descripción de la excepción.
        }
    }
	
	public static void guardarContactos() {
	    ArrayList<String> contactos = new ArrayList<>();
	    
	    while (true) {
	        String nombre = JOptionPane.showInputDialog("Introduce un nombre. Pon FIN para salir");
	        if (nombre == null || nombre.equalsIgnoreCase("FIN")) {
	            break;
	        }
	        
	        String telefono = JOptionPane.showInputDialog("Introduce el teléfono para " + nombre);
	        if (telefono == null) {  // Si el usuario cancela la entrada del teléfono
	            break;
	        }
	        
	        // Guardamos nombre y teléfono en formato "Nombre: xxx, Teléfono: xxx"
	        contactos.add(nombre + ": " + telefono);
	    }
	    
	    // Guardar los contactos en el archivo
	    try (java.io.FileWriter fw = new java.io.FileWriter("contactos.txt")) {
	        for (String contacto : contactos) {
	            fw.write(contacto + "\n");  // Escribimos cada contacto en una línea nueva
	        }
	        JOptionPane.showMessageDialog(null, "Contactos guardados correctamente");
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al guardar los contactos: " + e.getMessage(), 
	                                      "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public static void buscarNombre(){
	    String nombreBuscado = JOptionPane.showInputDialog("¿Qué nombres quieres buscar?");

	    try (FileInputStream fis = new FileInputStream("contactos.txt")) {
	        byte [] bytes = fis.readAllBytes();
	        String contenido = new String(bytes);

	        if (contenido.contains(nombreBuscado)) {
	            JOptionPane.showMessageDialog(null, "El nombre buscado: " + nombreBuscado + " está en la lista");
	        } else {
	            JOptionPane.showMessageDialog(null, "El nombre buscado " + nombreBuscado + " no está en la lista");
	        }

	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al leer el archivo");
	    }

	}
	
	}
	
	