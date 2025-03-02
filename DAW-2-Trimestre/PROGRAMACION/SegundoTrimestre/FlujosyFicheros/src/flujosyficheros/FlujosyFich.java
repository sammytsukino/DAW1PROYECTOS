package flujosyficheros;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FlujosyFich {
	    public static void main(String[] args) {
	        // Se define el texto que se va a escribir en el fichero
	        String texto = "Hola, este es un ejemplo de flujos y ficheros en Java.";
	        // Se define la ruta del fichero donde se realizará la escritura y lectura
	        String rutaArchivo = "ejemplo1.txt";
	        //Escribir en el fichero utilizando try-with-resources 
	        //para asegurar el cierre del flujo
	        //La instrucción try-with-resources es una característica de Java (introducida en Java 7)
	        //que permite gestionar recursos de forma automática. Esto significa que cualquier objeto
	        //que implemente la interfaz AutoCloseable (como flujos de archivos, conexiones de base de
	        //datos, etc.) se cerrará automáticamente al finalizar el bloque, sin necesidad de 
	        //invocar explícitamente el método close().
	        try (FileOutputStream fos = new FileOutputStream(rutaArchivo)) {
	            // Se convierte el texto a un flujo de bytes
	            byte[] bytesTexto = texto.getBytes();
	            // Se escribe el flujo de bytes en el fichero
	            fos.write(bytesTexto);
	            // Se notifica en la consola que la escritura fue exitosa
	            System.out.println("Se ha escrito correctamente en el archivo.");
	        } catch (IOException e) {
	            // Si ocurre un error de entrada/salida, se muestra un mensaje de error en la consola
	            System.err.println("Error al escribir en el archivo: " + e.getMessage());
	        }

	        // Leer del fichero utilizando try-with-resources para asegurar el cierre del flujo
	        try (FileInputStream fis = new FileInputStream(rutaArchivo)) {
	            int contenido;
	            System.out.println("Contenido del archivo:");
	            // Se lee byte a byte el contenido del fichero hasta que read() retorna -1 (fin del fichero)
	            while ((contenido = fis.read()) != -1) {
	                // Se convierte cada byte leído a carácter y se imprime en la consola
	                System.out.print((char) contenido);
	            }
	            // Se imprime un salto de línea final para finalizar la salida
	            System.out.println();
	        } catch (IOException e) {
	            // Si ocurre un error durante la lectura, se muestra un mensaje de error en la consola
	            System.err.println("Error al leer el archivo: " + e.getMessage());
	        }
	    }
	}
