// Importa las clases necesarias para el programa
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.IOException;

public class ContarPalabras {
    public static void main(String[] args) {
        // Crea un StringBuilder para almacenar el contenido del archivo
        StringBuilder contenido = new StringBuilder();

        // Abre el archivo "nombres.txt" para lectura dentro de un bloque try-with-resources
        try (FileInputStream fis = new FileInputStream("nombres.txt")) {
            int caracter;
            // Lee el archivo carácter por carácter
            while ((caracter = fis.read()) != -1) {
                // Añade cada carácter al StringBuilder
                contenido.append((char) caracter);
            }

            // Convierte el contenido del StringBuilder a una cadena y elimina espacios en blanco al principio y al final
            String texto = contenido.toString().trim();
            // Cuenta el número de palabras en el texto
            int numPalabras = texto.isEmpty() ? 0 : texto.split("\\s+").length;

            // Muestra un cuadro de diálogo con el número de palabras encontradas
            JOptionPane.showMessageDialog(null, "El archivo contiene " + numPalabras + " palabra(s).");
        } catch (IOException e) {
            // Si ocurre una excepción, muestra un cuadro de diálogo con un mensaje de error
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}