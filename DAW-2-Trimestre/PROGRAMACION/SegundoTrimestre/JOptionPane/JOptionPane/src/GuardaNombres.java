import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.IOException;

public class GuardaNombres {

    public static void main(String[] args) {
        ArrayList <String> nombres = new ArrayList<>();
        String input;

        while (true) {
            input = JOptionPane.showInputDialog("Ingresa los nombres");
            if (input == null || input.equalsIgnoreCase("FIN")) {
                break;
            }
            
            nombres.add(input);
        }

                try (FileOutputStream fos = new FileOutputStream("nombres.txt")) {
            for (String nombre : nombres) {
                fos.write((nombre + "\n").getBytes());
            }
            JOptionPane.showMessageDialog(null, "Nombres guardados exitosamente en 'nombres.txt'");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
