package listas;
import java.util.ArrayList;
public class ListaEjemplosString {
	public static void main(String[] args) {
	ArrayList <String> coches= new ArrayList<String>();
	//ArrayList <Integer> numeros=new ArrayList<Integer>();
	coches.add("Audi");
	coches.add("Seat");
	coches.add("Porsche");
	coches.add(0,"BMW");
	coches.set(0, "Audi");
	coches.set(1, "BMW");
	coches.remove(2);
	//coches.clear();
	int tam=coches.size();
	System.out.println(tam);
	System.out.println(coches);
	for(int i=0; i<coches.size();i++) {
		System.out.println(coches.get(i));
	}
	for (String i: coches) {
		System.out.println(i);
	}
	}
}
