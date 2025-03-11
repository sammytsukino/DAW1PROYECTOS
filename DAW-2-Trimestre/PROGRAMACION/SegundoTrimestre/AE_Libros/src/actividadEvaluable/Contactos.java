package actividadEvaluable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Contactos {
    
    // ArrayList para almacenar los contactos (requisito 1)
    private static ArrayList<String> listaContactos = new ArrayList<>();
    
    public static void main(String[] args) {
        // Cargar contactos al iniciar (paso 1)
        cargarContactos();
        
        String[] opciones = {"Añadir Contacto", "Listar Contactos", "Buscar Contacto", "Salir"};
        
        while (true) {
            int opcion = JOptionPane.showOptionDialog(
                null, 
                "Selecciona una opción:", 
                "Gestión de Contactos",
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                opciones, 
                opciones[0]
            );

            if (opcion == -1) {
                guardarContactos(); // Guardar antes de salir
                break;
            }
            
            switch (opcion) {
                case 0: 
                    añadirContacto();
                    break;
                case 1: 
                    listarContactos();
                    break;
                case 2: 
                    buscarContacto();
                    break;
                case 3: // Opción "Salir"
                    guardarContactos(); // Guardar antes de salir (paso 2)
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    return;
            }
        }
    }
    
    // Método para cargar contactos desde el archivo al iniciar (paso 1)
    private static void cargarContactos() {
        File archivo = new File("contactos.txt");
        
        // Verificar si el archivo existe antes de intentar leerlo
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, 
                    "Error al crear el archivo de contactos: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
            return;
        }
        
        // Usando flujos de entrada para leer el archivo (requisito 3)
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                listaContactos.add(linea);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al cargar los contactos: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para guardar contactos en el archivo antes de salir (paso 2)
    private static void guardarContactos() {
        // Usando flujos de salida para escribir en el archivo (requisito 3)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contactos.txt"))) {
            for (String contacto : listaContactos) {
                bw.write(contacto);
                bw.newLine();
            }
            // No mostramos mensaje aquí para evitar mensajes redundantes al salir
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al guardar los contactos: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para añadir un contacto (paso 3)
    private static void añadirContacto() {
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del contacto:");
        if (nombre == null || nombre.trim().isEmpty()) {
            return;
        }
        
        String telefono = JOptionPane.showInputDialog("Introduce el teléfono para " + nombre + ":");
        if (telefono == null) {
            return;
        }
        
        // Formato de contacto: "Nombre: xxx, Teléfono: xxx"
        String contacto = "Nombre: " + nombre + ", Teléfono: " + telefono;
        listaContactos.add(contacto);
        
        JOptionPane.showMessageDialog(null, "Contacto añadido correctamente");
    }
    
    // Método para listar todos los contactos (paso 4)
    private static void listarContactos() {
        if (listaContactos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay contactos guardados");
            return;
        }
        
        StringBuilder sb = new StringBuilder("Lista de contactos:\n\n");
        for (String contacto : listaContactos) {
            sb.append(contacto).append("\n");
        }
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    
    // Método para buscar contactos por nombre (paso 5, requisito 4)
    private static void buscarContacto() {
        String nombreBuscado = JOptionPane.showInputDialog("Introduce el nombre a buscar:");
        if (nombreBuscado == null || nombreBuscado.trim().isEmpty()) {
            return;
        }
        
        ArrayList<String> contactosEncontrados = new ArrayList<>();
        
        // Manipulación de cadenas para buscar contactos (requisito 4)
        for (String contacto : listaContactos) {
            if (contacto.toLowerCase().contains(nombreBuscado.toLowerCase())) {
                contactosEncontrados.add(contacto);
            }
        }
        
        if (contactosEncontrados.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "No se encontraron contactos con el nombre '" + nombreBuscado + "'");
        } else {
            StringBuilder sb = new StringBuilder("Contactos encontrados:\n\n");
            for (String contacto : contactosEncontrados) {
                sb.append(contacto).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}