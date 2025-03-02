package listas;
import java.util.ArrayList;
public class ListaEjemplosFloat {
	public static void main(String[] args) {
		ArrayList <Float> numerosFloat=new ArrayList<Float>();
		int  [] numeros=new int[3];
		numeros[0]=1;
		numeros[1]=1;
		numeros[2]=1;
		int suma1=0;
		for (int num:numeros) {
			suma1+=num;
		}
		System.out.println(suma1);
		numerosFloat.add(2.5f);
		numerosFloat.add(6.5f);
		numerosFloat.add(4.5f);
		numerosFloat.add(2.3f);
		numerosFloat.add(2.8f);
		float suma=0;
		for (int i=0; i<numerosFloat.size();i++) {
		suma+=numerosFloat.get(i);
		}
		System.out.println(suma);
		for (float num:numerosFloat) {
			suma+=num;
		}
		System.out.println(suma);
		
		}
	}
