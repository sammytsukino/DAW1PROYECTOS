package libreria;

public class Autor {

	@Override
	public String toString() {
		return "Autor [id_autor=" + id_autor + ", nombre_autor=" + nombre_autor + ", nacionalidad=" + nacionalidad
				+ "]";
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getNombre_autor() {
		return nombre_autor;
	}

	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	private int id_autor;
	private String nombre_autor;
	private String nacionalidad;

	public Autor(int id_autor, String nombre_autor, String nacionalidad) {
		super();
		this.id_autor = id_autor;
		this.nombre_autor = nombre_autor;
		this.nacionalidad = nacionalidad;
	}
}
