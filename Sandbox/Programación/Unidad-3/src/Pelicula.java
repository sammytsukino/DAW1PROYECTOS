import java.util.ArrayList;
import java.util.Iterator;

public class Pelicula {
    private String titulo;
    private String director;
    private String genero;
    private int duracion;
    private int fecha;

    public Pelicula(String titulo, String director, String genero, int duracion, int fecha) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Pelicula [titulo=" + titulo + ", director=" + director + ", genero=" + genero + ", duracion=" + duracion
                + ", fecha=" + fecha + ", getTitulo()=" + getTitulo() + ", getDirector()=" + getDirector()
                + ", getGenero()=" + getGenero() + ", getDuracion()=" + getDuracion() + ", getFecha()=" + getFecha()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }

    

}
