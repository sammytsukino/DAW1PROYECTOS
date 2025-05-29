public class Camino {
	

	private int id_camino;
	private String nombre;
	private int longitud;
	private String tipo_terreno;
	
	public Camino(int id_camino, String nombre, int longitud, String tipo_terreno) {
		super();
		this.id_camino = id_camino;
		this.nombre = nombre;
		this.longitud = longitud;
		this.tipo_terreno = tipo_terreno;
	}
	
	public int getId_camino() {
		return id_camino;
	}

	public void setId_camino(int id_camino) {
		this.id_camino = id_camino;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getTipo_terreno() {
		return tipo_terreno;
	}

	public void setTipo_terreno(String tipo_terreno) {
		this.tipo_terreno = tipo_terreno;
	}

}

