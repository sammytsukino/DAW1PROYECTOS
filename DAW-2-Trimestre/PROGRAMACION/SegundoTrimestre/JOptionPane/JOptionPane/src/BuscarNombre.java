import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.IOException;

public class BuscarNombre {
    public static void main(String[] args) {

        String nombreBuscado = JOptionPane.showInputDialog("Ingresa el nombre que deseas buscar:");

        if (nombreBuscado == null || nombreBuscado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ingresaste un nombre válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder contenido = new StringBuilder();


        try (FileInputStream fis = new FileInputStream("nombres.txt")) {
            int caracter;
            while ((caracter = fis.read()) != -1) {
                contenido.append((char) caracter);
            }


            String texto = contenido.toString();
            boolean encontrado = texto.lines().anyMatch(linea -> linea.equalsIgnoreCase(nombreBuscado));


            if (encontrado) {
                JOptionPane.showMessageDialog(null, "El nombre '" + nombreBuscado + "' fue encontrado en el archivo.");
            } else {
                JOptionPane.showMessageDialog(null, "El nombre '" + nombreBuscado + "' NO está en el archivo.", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
