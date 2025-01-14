public class ArrayEncontrarNumero {

    public static void main(String[] args) {
        int[] array = { 4, 3, 2, 5, 2, 4, 4, 8 };
        int numero = 5;

        for (int i = 0; i<array.length; i++){
            if (numero == array[i]){
                System.out.println("El numero " + numero + " se encuentra en la posicion " + i);
            }
        }

}

}
