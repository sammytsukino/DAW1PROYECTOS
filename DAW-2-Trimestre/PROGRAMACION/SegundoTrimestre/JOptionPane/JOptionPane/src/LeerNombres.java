import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerNombres {
    public static void main(String[] args) {
        StringBuilder contenido = new StringBuilder();

        try (FileInputStream fis = new FileInputStream("nombres.txt")) {
            int caracter;
            while ((caracter = fis.read()) != -1) {
                contenido.append((char) caracter);
            }

            JOptionPane.showMessageDialog(null, "Nombres guardados:\n" + contenido.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
