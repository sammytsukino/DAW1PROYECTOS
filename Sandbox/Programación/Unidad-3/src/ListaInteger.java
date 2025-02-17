import java.util.ArrayList;
import java.util.Collections;

public class ListaInteger {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(19);
        numeros.add(29);
        numeros.add(90);
        numeros.add(22);
        Collections.sort(numeros);
        Collections.reverse(numeros);
        for (int i : numeros) {
            System.out.println(i);
        }
        
    }

}
