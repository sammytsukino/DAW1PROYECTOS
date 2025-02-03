public class Factorial {

    public static void main(String[] args) {
        int numero = 5;
        long resultado =1;
        while (numero > 0) {
            resultado *= numero;
            numero--;
        }

        System.out.println("El factorial es: " + resultado);
    }

}


