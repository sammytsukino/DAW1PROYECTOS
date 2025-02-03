public class ArrayMayorQue {

    public static void main(String[] args) {
        int[] array = { 4, 3, 2, 5, 2, 4, 4, 8 };

        int mayor = 0;
        for (int i =0; i< array.length; i++){
            if (array[i] > mayor){
                mayor = array[i];
            }
        }
        System.out.println("El mayor valor es: " + mayor);

        int menor = mayor;
        for (int i =0; i< array.length; i++){
            if (array[i] < menor){
                menor = array[i];
            }
        }
        System.out.println("El menor valor es: " + menor);

        
    }
}
