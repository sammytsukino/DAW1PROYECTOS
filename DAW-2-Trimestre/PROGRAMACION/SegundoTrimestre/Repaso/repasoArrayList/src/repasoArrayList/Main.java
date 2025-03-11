package repasoArrayList;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<String> paises = new ArrayList<>();
		
		//agregar paises
		paises.add("España");
		paises.add("Italia");
		paises.add("Francia");
		paises.add("Bégica");
		paises.add("Portugal");

		//comprobar si existe un país
		
		System.out.println(paises.contains("Francia"));
		
		//obtener país
		System.out.println(paises.get(2));
		
		//modificar elemento
		paises.set(2, "Alemania");
		
		//mostrar lista paises
		for (String pais : paises) {
			System.out.println(pais);
		}
		
		//borrar
		paises.remove(2);
		paises.remove("Portugal");
		
		
		//mostrar lista paises
		for (String pais : paises) {
			System.out.println(pais);
		}
		
		
		//obtener tamaño list
		System.out.println(paises.size());
	}

}
