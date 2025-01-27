public class Excepcion {
    public static void main(String[] args) {
        try {
            System.out.println("Probando el primer try");
            double division = 5 / 0;
            System.out.println("El resultado de la division es: " + division);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Esto se ejecuta siempre");
        }

        try { 
            String titulo = "Programación";
            char caracter = titulo.charAt(19);

        } catch(IndexOutOfBoundsException e) {
            System.out.println("Índice del string fuera de rango");
        } finally {
            System.out.println("Esto se ejecuta siempre");
        }
    }

}
