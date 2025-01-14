public class ArrayBucle {

    /*
     * static float [][] m = new float[3][4];
     * public static void main(String[] args) {
     * 
     * for (int i = 0; i< m.length; i++){
     * for (int j=0; j < m[i].length; j++){
     * m[i][j] = i*4+j+1;//inicializa la matriz
     * for (int k = 0; k < m.length; k++) {
     * for (int l = 0; l < m[k].length; l++) {
     * System.out.print(m[k][l] + " ");
     * }
     * System.out.println();
     * }
     * }
     * }
     * }
     */

    // Encontrar los elementos duplicados en un ARRAY

    public static void main(String[] args) {
        int[] array = { 4, 3, 2, 3, 2, 4, 4 };

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println("Elemento duplicado: " + array[i]);
                }
            }
        }
    }
}
