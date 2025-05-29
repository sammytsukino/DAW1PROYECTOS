import oracle.sql.DATE;

public class Proyecto {

	private int id_proyecto;
	private String nombre;
	private DATE fecha_inicio;
	private Camino camino;

	public Proyecto(int id_proyecto, String nombre, DATE fecha_inicio, Camino camino) {
		super();
		this.id_proyecto = id_proyecto;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.camino = camino;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DATE getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(DATE fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Camino getCamino() {
		return camino;
	}

	public void setCamino(Camino camino) {
		this.camino = camino;
	}
}
