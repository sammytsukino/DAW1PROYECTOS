import javax.swing.JOptionPane; // Importa la clase JOptionPane para mostrar cuadros de diálogo.
import java.io.FileInputStream; // Importa la clase FileInputStream para leer archivos.
import java.io.IOException; // Importa la clase IOException para manejar excepciones de entrada/salida.

public class BuscarNombre { // Declara la clase pública BuscarNombre.
    public static void main(String[] args) { // Declara el método principal que se ejecuta al iniciar el programa.

        String nombreBuscado = JOptionPane.showInputDialog("Ingresa el nombre que deseas buscar:"); 
        // Muestra un cuadro de diálogo para que el usuario ingrese el nombre que desea buscar y lo almacena en la variable nombreBuscado.

        if (nombreBuscado == null || nombreBuscado.trim().isEmpty()) { 
            // Verifica si el usuario no ingresó un nombre válido (es nulo o está vacío).
            JOptionPane.showMessageDialog(null, "No ingresaste un nombre válido.", "Advertencia", JOptionPane.WARNING_MESSAGE); 
            // Muestra un mensaje de advertencia indicando que no se ingresó un nombre válido.
            return; // Termina la ejecución del método principal.
        }

        StringBuilder contenido = new StringBuilder(); 
        // Crea un objeto StringBuilder para almacenar el contenido del archivo.

        try (FileInputStream fis = new FileInputStream("nombres.txt")) { 
            // Intenta abrir el archivo "nombres.txt" para lectura utilizando un FileInputStream.
            int caracter; 
            // Declara una variable para almacenar cada carácter leído del archivo.
            while ((caracter = fis.read()) != -1) { 
                // Lee el archivo carácter por carácter hasta llegar al final (cuando read() devuelve -1).
                contenido.append((char) caracter); 
                // Convierte el carácter leído a char y lo agrega al StringBuilder.
            }

            String texto = contenido.toString(); 
            // Convierte el contenido del StringBuilder a una cadena de texto.
            boolean encontrado = texto.lines().anyMatch(linea -> linea.equalsIgnoreCase(nombreBuscado)); 
            // Verifica si alguna línea del texto coincide con el nombre buscado (ignorando mayúsculas/minúsculas).

            if (encontrado) { 
                // Si el nombre fue encontrado en el archivo:
                JOptionPane.showMessageDialog(null, "El nombre '" + nombreBuscado + "' fue encontrado en el archivo."); 
                // Muestra un mensaje indicando que el nombre fue encontrado.
            } else { 
                // Si el nombre no fue encontrado en el archivo:
                JOptionPane.showMessageDialog(null, "El nombre '" + nombreBuscado + "' NO está en el archivo.", "No encontrado", JOptionPane.INFORMATION_MESSAGE); 
                // Muestra un mensaje indicando que el nombre no fue encontrado.
            }
        } catch (IOException e) { 
            // Si ocurre una excepción de entrada/salida durante la lectura del archivo:
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
            // Muestra un mensaje de error con la descripción de la excepción.
        }
    }
}
