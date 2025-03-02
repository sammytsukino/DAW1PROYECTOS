package listas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class ListadePeliculas {
	public static void main (String [] args) {
	ArrayList <Pelicula> peliculas=new ArrayList <Pelicula>();
	Pelicula p1=new Pelicula("Forrest Gump", "Robert Cemex", "Aventuras", 120, 2002,8);
	Pelicula p2=new Pelicula("21 Blackjack","Robert Lucketick", "Acción", 90, 2008,5);
	Pelicula p3=new Pelicula("Dos tontos muy tontos","Nilet Ojeda", "Comedia", 100, 2000,2);
	Pelicula p4=new Pelicula("El gato con botas","Antonio Banderas", "Animación", 120, 2004,10);
	
	peliculas.add(p1);
	peliculas.add(p2);
	peliculas.add(p3);
	peliculas.add(p4);
	p1.esSimilar(p2);
	p2.esSimilar(p1);
	
	try {
	Scanner sc=new Scanner(System.in);
	System.out.println("Dime el nombre de la pelicula");
	String nomPel=sc.nextLine();
	System.out.println("Dime la duración de la pelicula");
	int durPel=sc.nextInt();
		Iterator <Pelicula> itrPeliculas=peliculas.iterator();
	while (itrPeliculas.hasNext()) {
		Pelicula pelicula=itrPeliculas.next();
		if (nomPel.equals(pelicula.getNombre())){
			pelicula.setDuracion(durPel);
		}
		
		System.out.println(pelicula.toString());
	}
	sc.close();
	}catch(Exception e) {
		e.getMessage();
	}
	
	}
}
