import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.IOException;

public class ContarPalabras {
    public static void main(String[] args) {
        StringBuilder contenido = new StringBuilder();

        try (FileInputStream fis = new FileInputStream("nombres.txt")) {
            int caracter;
            while ((caracter = fis.read()) != -1) {
                contenido.append((char) caracter);
            }

            String texto = contenido.toString().trim();
            int numPalabras = texto.isEmpty() ? 0 : texto.split("\\s+").length;

            JOptionPane.showMessageDialog(null, "El archivo contiene " + numPalabras + " palabra(s).");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
