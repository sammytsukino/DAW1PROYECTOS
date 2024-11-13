package bicicleta;

import bicicleta.Bicicleta.tamaño;
import bicicleta.Bicicleta.tipo;

public class PruebaBicicleta {
	public static void main(String[] args) {
		Bicicleta b1 = new Bicicleta ("blanco", 27, "Orbea", false, 500, true, tipo.MONTAÑA, tamaño.ADULTO, 25);
		System.out.println("Marca bicicleta " + b1.getMarca() +  ".");
		System.out.println("Color bicicleta " + b1.getColor()+ ".");
		System.out.println("Pulgadas bicicleta " + b1.getPulgadas()+ ".");
		System.out.println("Tipo " + b1.getTipo()+ "." );
		System.out.println("Tipo " + b1.getTamaño()+ "." );
		System.out.println("Precio " + b1.getPrecio()+ " €." );
		System.out.println("Tiene luces?");
		if (b1.isTieneLuces()) { 
			System.out.println("Sí");
		} else {System.out.println("No");}
		
		b1.acelerar(1);
		b1.setPulgadas(29);
	}

}
