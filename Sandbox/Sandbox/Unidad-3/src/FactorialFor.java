public class FactorialFor {

    public static void main(String[] args) {
        int numero = 5;
        long resultado = 1;
        
        for (int i = numero; i > 0; i--) {
            resultado *= i;
        }
        
        System.out.println("El factorial es: " + resultado);
    }

}
