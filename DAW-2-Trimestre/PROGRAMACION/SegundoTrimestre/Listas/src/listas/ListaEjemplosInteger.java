package listas;

import java.util.ArrayList;
import java.util.Collections;
public class ListaEjemplosInteger {
	public static void main(String[] args) {
		ArrayList<Integer> numeros=new ArrayList<Integer>();
		ArrayList<Integer> numerosA=new ArrayList<Integer>();
		numeros.add(19);
		numeros.add(29);
		numeros.add(90);
		numeros.add(25);
		Collections.sort(numeros);
		for (int i: numeros) {
			System.out.println(i);
		}
		Collections.reverse(numeros);
		for (int i: numeros) {
			System.out.println(i);
		}
		
		for(int i=1;i<=20;i++) {
			numerosA.add(i);
		}
		System.out.println(numerosA);
		
	}
}
