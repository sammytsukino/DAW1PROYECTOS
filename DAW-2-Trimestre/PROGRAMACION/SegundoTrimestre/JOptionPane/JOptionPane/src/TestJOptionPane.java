import javax.swing.JOptionPane;

public class TestJOptionPane {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("¿Cómo te llamas?");
        JOptionPane.showMessageDialog(null, "Hola, " + nombre + "!");
    }
}
