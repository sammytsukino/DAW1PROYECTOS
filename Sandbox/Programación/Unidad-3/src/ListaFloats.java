import java.util.*;

public class ListaFloats {
    public static void main(String[] args) {
        ArrayList<Float> numeros = new ArrayList<Float>();
        int [] numeros2 = new int[4];
        numeros2[0] = 19;
        numeros2[1] = 29;
        numeros2[2] = 90;
        numeros2[3] = 22;

        int suma1 = 0;
        for (int i : numeros2) {
            suma1 += i;
        }

        System.out.println("La suma de los números es: " + suma1);

        /*for (float i = 1; i <= 20; i++) {
            numeros.add(i);*/

        numeros.add(19.0f);
        numeros.add(29.0f);
        numeros.add(90.0f);
        numeros.add(22.0f);
        float suma = 0;
        for (int i = 0; i <numeros.size(); i++){
            suma += numeros.get(i);
        }

        System.out.println("La suma de los números es: " + suma);

        }
}
