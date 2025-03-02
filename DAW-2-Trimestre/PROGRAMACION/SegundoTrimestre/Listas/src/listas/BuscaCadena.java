package listas;
import java.util.ArrayList;
public class BuscaCadena {
	public static void main (String[] args) {
		ArrayList <String> nombres=new ArrayList<>();
		nombres.add("José");
		nombres.add("Carlos");
		nombres.add("Juanita");
		
		String buscar="Carlos";
		
		if (nombres.contains(buscar)) {
			System.out.println("Lo ha encontrado. Magnífico");
		}else {
			System.out.println("No lo ha encontrado. Horrible");
		}
	}
}
