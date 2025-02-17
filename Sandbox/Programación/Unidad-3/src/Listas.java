import java.util.ArrayList;

public class Listas {

    public static void main(String[] args) {
        ArrayList<String> coches = new ArrayList<String>();
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        coches.add("Audi");
        coches.add("Seat");
        coches.add("Porsche");
        coches.add(0,"BMW");
        coches.remove(2);
        //coches.clear();
        System.out.println(coches);
        int tamano = coches.size();
        System.out.println("Tamaño de la lista: " + tamano);
        for(int i=0; i<coches.size(); i++){
            System.out.println(coches.get(i));
        }
        for (String i:coches) {
            System.out.println(i);
        }

        

    }




}
