package flujosyficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CrearDirectorio {
    public static void main(String[] args) {
        // Definición del nombre del directorio y del archivo
        String nombreDirectorio = "miDirectorio";
        String nombreArchivo = "archivo.txt";

        // Se crea un objeto File para representar el directorio
        File directorio = new File(nombreDirectorio);

        // Se verifica si el directorio existe; si no, se intenta crear
        if (!directorio.exists()) {
            if (directorio.mkdir()) { // mkdir() crea el directorio
                System.out.println("Directorio creado: " + directorio.getAbsolutePath());
            } else {
                System.out.println("No se pudo crear el directorio.");
                return; // Si falla la creación, se finaliza la ejecución
            }
        } else {
            System.out.println("El directorio ya existe: " + directorio.getAbsolutePath());
        }

        // Se crea un objeto File para el archivo dentro del directorio
        File archivo = new File(directorio, nombreArchivo);

        // Contenido que se desea escribir en el archivo
        String contenido = "Este es un ejemplo de escritura y lectura en un archivo ubicado en un directorio.";

        // Escritura en el archivo usando FileOutputStream y try-with-resources para asegurar el cierre automático
        try (FileOutputStream fos = new FileOutputStream(archivo)) {
            // Se convierte el contenido a bytes y se escribe en el archivo
            fos.write(contenido.getBytes());
            System.out.println("Se ha escrito en el archivo: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Lectura del contenido del archivo usando FileInputStream y try-with-resources
        try (FileInputStream fis = new FileInputStream(archivo)) {
            int byteLeido;
            System.out.println("Contenido del archivo:");
            // Se lee el archivo byte a byte hasta llegar al final (cuando read() retorna -1)
            while ((byteLeido = fis.read()) != -1) {
                System.out.print((char) byteLeido);
            }
            System.out.println(); // Salto de línea al finalizar la lectura
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        // Listado de todos los archivos presentes en el directorio
        File[] listaArchivos = directorio.listFiles();
        if (listaArchivos != null && listaArchivos.length > 0) {
            System.out.println("\nArchivos presentes en el directorio:");
            for (File f : listaArchivos) {
                if (f.isFile()) {
                    System.out.println("- " + f.getName());
                }
            }
        } else {
            System.out.println("El directorio está vacío.");
        }
    }
}

