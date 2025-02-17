import java.util.ArrayList;
import java.util.Iterator;

public class ListaIterador {
	public static void main (String [] args) {
		ArrayList <String> elementos = new ArrayList<>();
		
	for (int i=1; i<=20; i++) {
		elementos.add("Elemento "+i);
	}
		Iterator <String> elementosIterador=elementos.iterator();
		System.out.print("[ ");
		while(elementosIterador.hasNext()) {
			String elemento=elementosIterador.next();
			if (!elementos.getLast().equals(elemento))
			{
				System.out.print(elemento+" , ");
			}
			else
			{
			System.out.print(elemento+" ]");
			}
		}
	}
}