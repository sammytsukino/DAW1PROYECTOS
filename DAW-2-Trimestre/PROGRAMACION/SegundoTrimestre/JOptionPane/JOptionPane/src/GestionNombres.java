import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class GestionNombres {

    public static void guardarNombres(){
        ArrayList<String> nombres = new ArrayList<>();
        String nombre;

        while (true) {
            nombre = JOptionPane.showInputDialog("Introduce un nombre. Pon FIN para salir");
            if ( nombre == null || nombre.equalsIgnoreCase("FIN")) {
                break;
            }
            nombres.add(nombre);
        }
    }

    public static void leerNombres() {

        StringBuilder contenido = new StringBuilder();

        try (FileInputStream fis = new FileInputStream("nombres.txt")) {

            int caracter;
            while ((caracter = fis.read()) != -1) {
                contenido.append((char) caracter);
            }

            JOptionPane.showMessageDialog(null, "Nombres guardados:\n" + contenido.toString());
        } catch (IOException e) { 
            JOptionPane.showMessageDialog(null, "Error al ver los nombres", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


public static void contarPalabras() {
    int contador = 0;

    try (FileInputStream fis = new FileInputStream("nombres.txt")) {
        byte[] bytes = fis.readAllBytes();
        String contenido = new String(bytes);
        String[] palabras = contenido.split("\\s+");
        contador = palabras.length;
        JOptionPane.showMessageDialog(null, "El archivo tiene " + contador + " palabras.");

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al leer el archivo");
    }
    }

public static void buscarPalabras(){
    String nombreBuscado = JOptionPane.showInputDialog("¿Qué nombres quieres buscar?");

    try (FileInputStream fis = new FileInputStream("nombres.txt")) {
        byte [] bytes = fis.readAllBytes();
        String contenido = new String(bytes);

        if (contenido.contains(nombreBuscado)) {
            JOptionPane.showMessageDialog(null, "El nombre buscado: " + nombreBuscado + " está en la lista");
        } else {
            JOptionPane.showMessageDialog(null, "El nombre buscado " + nombreBuscado + " está en la lista");
        }

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al leer el archivo");
    }

}

public static void reemplazarNombre() {
    String nombreReemplazado = JOptionPane.showInputDialog("¿Qué nombre quieres reemplazar?");
    String nombreNuevo = JOptionPane.showInputDialog("Introduce el nuevo nombre");

    try (FileInputStream fis = new FileInputStream("nombres.txt")) {
        byte[] bytes = fis.readAllBytes();
        String contenido = new String(bytes);

        if (contenido.contains(nombreReemplazado)) {
            contenido = contenido.replace(nombreReemplazado, nombreNuevo);
            try (FileOutputStream fos = new FileOutputStream("nombres.txt")) {
                fos.write(contenido.getBytes());
                JOptionPane.showMessageDialog(null, "El nombre ha sido reemplazado exitosamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al escribir en el archivo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El nombre buscado no está en la lista");
        }

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al leer el archivo");
    }
}

public static void main(String[] args) {
    String[] opciones = {"Guardar Nombres", "Leer Nombres", "Contar Palabras", "Buscar Nombre", "Reemplazar Nombre", "Salir"};
    
    while (true) {
        int opcion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Gestión de Nombres",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
        switch (opcion) {
            case 0:
                guardarNombres();
                break;
            case 1:
                leerNombres();
                break;
            case 2:
                contarPalabras();
                break;
            case 3:
                buscarPalabras();
                break;
            case 4:
                reemplazarNombre();
                break; 
            case 5:
                return;
        }
    }
}


}



    