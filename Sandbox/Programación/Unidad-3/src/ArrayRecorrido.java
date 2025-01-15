public class ArrayRecorrido {

    public static void main(String[] args) {

        int[] arrayReves = new int[50];
        for (int i = arrayReves.length - 1; i >= 0; i--) {
            arrayReves[i] = i + 1;
            System.out.println(arrayReves[i]);
        }
        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.println(array[i]);
        }
    }
}
