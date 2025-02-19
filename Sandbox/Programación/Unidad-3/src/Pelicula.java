import java.util.ArrayList;
import java.util.Iterator;

public class Pelicula {
    private String titulo;
    private String director;
    private String genero;
    private int duracion;
    private int fecha;
    private int calificacion;

    public Pelicula(String titulo, String director, String genero, int duracion, int fecha, int calificacion) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.fecha = fecha;
        this.calificacion = calificacion;
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

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public boolean esPeliculaEpica() {
        if (this.getDuracion() >= 180) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esSimilar(Pelicula pelicula){
        if (pelicula.getGenero()==genero && pelicula.calcularValoracion()==this.calcularValoracion()){
            return true;
        } else {
            return false;
        }
    }

    public String calcularValoracion() {
        if (this.calificacion >= 0.0 && this.calificacion <= 3.0) {
            return "Muy malo";
        } else if (this.calificacion > 3.0 && this.calificacion <= 5.0) {
            return "Malo";
        } else if (this.calificacion > 5.0 && this.calificacion <= 6.0) {
            return "Regular";
        } else if (this.calificacion > 6.0 && this.calificacion <= 8.0) {
            return "Buena";
        } else {
            return this.calificacion > 8.0 && this.calificacion <= 10.0 ? "Magnífica" : "Valoración no válida";
        }
    }

    @Override
    public String toString() {
        return "Pelicula [titulo=" + titulo + ", director=" + director + ", genero=" + genero + ", duracion=" + duracion
                + ", fecha=" + fecha + ", calificacion=" + calificacion + ", esPeliculaEpica()=" + esPeliculaEpica()
                + ", calcularValoracion()=" + calcularValoracion() + ", esSimilar()=" + esSimilar(null) + "]";
    }


    }

