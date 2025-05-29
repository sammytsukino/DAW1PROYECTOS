public class Trabajador {
    private int idTrabajador;
    private String nombre;
    private String especialidad;

    public Trabajador(int idTrabajador, String nombre, String especialidad) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getIdTrabajador() { return idTrabajador; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
}
