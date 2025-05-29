public class Asignacion {
    private int idAsignacion;
    private String fecha;
    private Trabajador trabajador;
    private Proyecto proyecto;

    public Asignacion(int idAsignacion, String fecha, Trabajador trabajador, Proyecto proyecto) {
        this.idAsignacion = idAsignacion;
        this.fecha = fecha;
        this.trabajador = trabajador;
        this.proyecto = proyecto;
    }

    public void setIdAsignacion(int idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public int getIdAsignacion() { return idAsignacion; }
    public String getFecha() { return fecha; }
    public Trabajador getTrabajador() { return trabajador; }
    public Proyecto getProyecto() { return proyecto; }
}
