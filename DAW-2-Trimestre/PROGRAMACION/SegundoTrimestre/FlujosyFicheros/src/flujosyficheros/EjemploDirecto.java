package flujosyficheros;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class EjemploDirecto {

	    public static void main(String[] args) {
	        // Se define el directorio desde el cual se leerán los ficheros
	        File directorio = new File("c:\\directorioEjemplo");

	        // Se verifica que el directorio exista y sea efectivamente un directorio
	        if (directorio.exists() && directorio.isDirectory()) {
	            // Se obtiene la lista de archivos dentro del directorio
	            File[] archivos = directorio.listFiles();

	            // Se comprueba que el directorio no esté vacío
	            if (archivos != null && archivos.length > 0) {
	                // Se recorre cada archivo encontrado en el directorio
	                for (File archivo : archivos) {
	                    // Se asegura de que el elemento es un fichero y no otro directorio
	                    if (archivo.isFile()) {
	                        System.out.println("Leyendo el archivo: " + archivo.getName());
	                        // Se utiliza try-with-resources para asegurar que el flujo se cierra automáticamente
	                        try (FileInputStream fis = new FileInputStream(archivo)) {
	                            int contenido;
	                            // Se lee el archivo byte a byte hasta alcanzar el final (read() retorna -1)
	                            while ((contenido = fis.read()) != -1) {
	                                System.out.print((char) contenido);
	                            }
	                            System.out.println("\n----------------------------------\n");
	                        } catch (IOException e) {
	                            // Se maneja cualquier error que ocurra durante la lectura del archivo
	                            System.err.println("Error al leer el archivo " + archivo.getName() + ": " + e.getMessage());
	                        }
	                    }
	                }
	            } else {
	                // Mensaje si el directorio no contiene archivos
	                System.out.println("El directorio está vacío.");
	            }
	        } else {
	            // Mensaje si la ruta especificada no es un directorio válido o no existe
	            System.out.println("El directorio no existe o no es un directorio válido.");
	        }
	    }
	}
