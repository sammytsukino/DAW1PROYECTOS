import java.util.*;

public class BuscaCadena {
    public static void main(String[] args) {
        ArrayList <String> nombres = new ArrayList <String>();
        nombres.add("Juan");
        nombres.add("Pedro");
        nombres.add("Luis");
        nombres.add("Carlos");
        
        String buscar="Carlo";

        if (nombres.contains(buscar)){
            System.out.println("El nombre " + buscar + " se encuentra en la lista.");
        } else {
            System.out.println("El nombre " + buscar + " no se encuentra en la lista.");
        }

    }

}
