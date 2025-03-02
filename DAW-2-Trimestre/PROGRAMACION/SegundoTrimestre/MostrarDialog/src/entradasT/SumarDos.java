package entradasT;
import javax.swing.JOptionPane;
public class SumarDos {
	public static void main(String[] args) {
		try {
            // Se solicita al usuario el ingreso del primer número
            String numeroStr1 = JOptionPane.showInputDialog("Ingrese el primer número:");
            // Se solicita al usuario el ingreso del segundo número
            String numeroStr2 = JOptionPane.showInputDialog("Ingrese el segundo número:");
            // Se convierten las cadenas a enteros
            float numero1 = Float.parseFloat(numeroStr1);
            float numero2 = Float.parseFloat(numeroStr2);
            // Se realiza la suma de los números
            float suma = numero1 + numero2;
            // Se muestra el resultado en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, "La suma de " + numero1 + " y " + numero2 + " es: " + suma);
        } catch (NumberFormatException e) {
            // En caso de que la conversión falle, se muestra un mensaje de error
        	// Es el título que aparecerá en la barra de la ventana emergente, 
        	// ayudando a identificar el propósito del mensaje
        	// Usar JOptionPane.ERROR_MESSAGE configura el diálogo para mostrar un 
        	// icono de error, lo que refuerza visualmente que se trata de una 
        	// notificación de error
            JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
	    }
}

