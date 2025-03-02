package entradasT;
import javax.swing.JOptionPane;

public class Conversiones {
    public static void main(String[] args) {
        try {
            // Solicita y convierte un valor a tipo Byte
            String byteStr = JOptionPane.showInputDialog("Ingrese un valor para Byte:");
            byte valorByte = Byte.parseByte(byteStr);
            
            // Solicita y convierte un valor a tipo Short
            String shortStr = JOptionPane.showInputDialog("Ingrese un valor para Short:");
            short valorShort = Short.parseShort(shortStr);

            // Solicita y convierte un valor a tipo Long
            String longStr = JOptionPane.showInputDialog("Ingrese un valor para Long:");
            long valorLong = Long.parseLong(longStr);

            // Solicita y convierte un valor a tipo Boolean
            // Boolean.parseBoolean retorna true si la cadena es "true" (sin importar mayúsculas o minúsculas)
            String booleanStr = JOptionPane.showInputDialog("Ingrese un valor para Boolean (true/false):");
            boolean valorBoolean = Boolean.parseBoolean(booleanStr);

            // Crea un mensaje con los resultados de las conversiones
            String mensaje = "Valor Byte: " + valorByte + "\n" +
                             "Valor Short: " + valorShort + "\n" +
                             "Valor Long: " + valorLong + "\n" +
                             "Valor Boolean: " + valorBoolean;

            // Muestra el mensaje en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, mensaje, "Resultado de conversiones", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            // Captura la excepción en caso de que la conversión de números falle
            JOptionPane.showMessageDialog(null, "Error: Uno de los valores numéricos ingresados no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
