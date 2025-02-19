import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListaPeliculas {
    public static void main(String[] args) {

        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

        Pelicula p1 = new Pelicula("El Padrino", "Francis Ford Coppola", "Drama", 175, 1972, 4);
        Pelicula p2 = new Pelicula("La lista de Schindler", "Steven Spielberg", "Drama", 195, 1993, 7);
        Pelicula p3 = new Pelicula("El Señor de los Anillos", "Peter Jackson", "Fantasia", 201, 2001, 6);
        Pelicula p4 = new Pelicula("Titanic", "James Cameron", "Romance", 195, 1997, 10);

        peliculas.add(p1);
        peliculas.add(p2);
        peliculas.add(p3);
        peliculas.add(p4);

        Scanner sc = new Scanner(System.in);
        /*
         * System.out.println("Introduce el titulo de la pelicula");
         * String titulo = sc.nextLine();
         * System.out.println("Introduce la duración de la película");
         * int duracion = sc.nextInt();
         */

        /*
         * if (titulo.equals(pelicula.getTitulo())){
         * pelicula.setDuracion(duracion);
         * }
         * System.out.println(pelicula.toString());
         * } sc.close();
         * } catch (Exception e) {
         * System.out.println("Error al introducir los datos");
         */

        Iterator<Pelicula> itPelicuIterator = peliculas.iterator();
        while (itPelicuIterator.hasNext()) {
            Pelicula pelicula = itPelicuIterator.next();
            pelicula.calcularValoracion();
            System.out.println(pelicula.toString());
        }
    }
}
