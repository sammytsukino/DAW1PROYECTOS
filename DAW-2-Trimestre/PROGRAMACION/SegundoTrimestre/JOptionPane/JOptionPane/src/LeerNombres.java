import javax.swing.JOptionPane; // Importa la clase JOptionPane para mostrar cuadros de diálogo.
import java.io.FileInputStream; // Importa la clase FileInputStream para leer archivos.
import java.io.IOException; // Importa la clase IOException para manejar excepciones de entrada/salida.

public class LeerNombres { // Declara la clase pública LeerNombres.
    public static void main(String[] args) { // Declara el método principal que se ejecuta al iniciar el programa.
        StringBuilder contenido = new StringBuilder(); // Crea un objeto StringBuilder para almacenar el contenido del archivo.

        try (FileInputStream fis = new FileInputStream("nombres.txt")) { // Intenta abrir el archivo "nombres.txt" para lectura utilizando un FileInputStream.
            int caracter; // Declara una variable para almacenar cada carácter leído del archivo.
            while ((caracter = fis.read()) != -1) { // Lee el archivo carácter por carácter hasta llegar al final (cuando read() devuelve -1).
                contenido.append((char) caracter); // Convierte el carácter leído a char y lo agrega al StringBuilder.
            }

            JOptionPane.showMessageDialog(null, "Nombres guardados:\n" + contenido.toString()); // Muestra un mensaje con el contenido del archivo.
        } catch (IOException e) { // Captura cualquier excepción de entrada/salida que ocurra durante la lectura del archivo.
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // Muestra un mensaje de error con la descripción de la excepción.
        }
    }
}