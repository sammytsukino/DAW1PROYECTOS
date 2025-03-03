import java.io.FileOutputStream; // Importa la clase FileOutputStream para escribir en archivos.
import java.util.ArrayList; // Importa la clase ArrayList para manejar listas dinámicas.
import javax.swing.JOptionPane; // Importa la clase JOptionPane para mostrar cuadros de diálogo.
import java.io.IOException; // Importa la clase IOException para manejar excepciones de entrada/salida.

public class GuardaNombres { // Declara la clase pública GuardaNombres.

    public static void main(String[] args) { // Declara el método principal que se ejecuta al iniciar el programa.
        ArrayList<String> nombres = new ArrayList<>(); // Crea una lista dinámica para almacenar los nombres ingresados.
        String input; // Declara una variable para almacenar la entrada del usuario.

        while (true) { // Inicia un bucle infinito.
            input = JOptionPane.showInputDialog("Ingresa los nombres"); // Muestra un cuadro de diálogo para que el usuario ingrese un nombre.
            if (input == null || input.equalsIgnoreCase("FIN")) { // Verifica si el usuario no ingresó un nombre o ingresó "FIN".
                break; // Sale del bucle si se cumple la condición.
            }
            
            nombres.add(input); // Agrega el nombre ingresado a la lista.
        }

        try (FileOutputStream fos = new FileOutputStream("nombres.txt")) { // Intenta abrir el archivo "nombres.txt" para escritura utilizando un FileOutputStream.
            for (String nombre : nombres) { // Itera sobre cada nombre en la lista.
                fos.write((nombre + "\n").getBytes()); // Escribe el nombre en el archivo, seguido de un salto de línea.
            }
            JOptionPane.showMessageDialog(null, "Nombres guardados exitosamente en 'nombres.txt'"); // Muestra un mensaje indicando que los nombres se guardaron exitosamente.
        } catch (IOException e) { // Captura cualquier excepción de entrada/salida que ocurra durante la escritura del archivo.
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // Muestra un mensaje de error con la descripción de la excepción.
        }
    }
}