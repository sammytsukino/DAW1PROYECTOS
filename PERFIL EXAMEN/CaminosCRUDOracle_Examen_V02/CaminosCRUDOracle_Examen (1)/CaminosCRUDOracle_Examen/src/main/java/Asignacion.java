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

    public int getIdAsignacion() { return idAsignacion; }
    public String getFecha() { return fecha; }
    public Trabajador getTrabajador() { return trabajador; }
    public Proyecto getProyecto() { return proyecto; }
}
