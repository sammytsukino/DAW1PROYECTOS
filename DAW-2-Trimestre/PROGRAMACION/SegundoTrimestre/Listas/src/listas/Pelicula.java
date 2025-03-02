package listas;

public class Pelicula {
	private String nombre;
	private String director;
	private String genero;
	private int duracion;
	private int anyo;
	private int calificacion;
	private boolean esSimilar;
	
	public Pelicula(String nombre, String director, String genero, int duracion, int anyo, int calificacion) {
		this.nombre = nombre;
		this.director = director;
		this.genero = genero;
		this.duracion = duracion;
		this.anyo = anyo;
		this.calificacion=calificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public int getCalificacion() {
		return calificacion;
	}

	public String calcularValoracion() {
		if (calificacion>=0 && calificacion<=2) {
			return "Muy mala";
		}else if (calificacion>2 && calificacion<5) {
			return "Mala";
		}else if (calificacion>=5 && calificacion<=7) {
			return "Buena";
		}else if (calificacion>7&&calificacion<=10) {
			return "Magnífica";
		}else {
			return "La valoración no es válida";
		}
	}
	@Override
	public String toString() {
		return "Pelicula [nombre=" + this.getNombre() + ", director=" + this.getDirector() + ", genero=" + this.getGenero() + ", duracion=" + this.getDuracion()
				+ ", anyo=" + this.getAnyo() + ", epica=" + this.esPeliculaEpica()+ ", calificacion="+ this.getCalificacion()+ ", valoracion="+ this.calcularValoracion()+", similar="+ esSimilar+"]";
	}
	
	public boolean esPeliculaEpica() {
		if (this.getDuracion()>=180) {
			return true;
		}else {
			return false;
		}
	}
	public boolean esSimilar(Pelicula pelicula) {
		if(pelicula.getGenero()==genero && pelicula.calcularValoracion()==this.calcularValoracion()) {
			this.esSimilar=true;
			pelicula.esSimilar=true;
		}else {
			this.esSimilar=false;
			pelicula.esSimilar=false;
		}
		return esSimilar;
	}
	
}
