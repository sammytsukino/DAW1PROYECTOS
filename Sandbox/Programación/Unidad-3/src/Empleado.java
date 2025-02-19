import java.util.ArrayList;

public class Empleado {
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private double nomina;
    private String departamento;

    public Empleado(String nombre, String apellido, String email, String dni, double nomina, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.nomina = nomina;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return nombre.toLowerCase() + "." + apellido.toLowerCase() + "@daw.com";
        }

        public void setEmail(String email) {
        this.email = nombre.toLowerCase() + "." + apellido.toLowerCase() + "@daw.com";
        }

        public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getNomina() {
        return nomina;
    }

    public void setNomina(double nomina) {
        this.nomina = nomina;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String toString () {
        return "Nombre: " + this.nombre + " Apellido: " + this.apellido + " Email: " + this.email + " DNI: " + this.dni + " Nomina: " + this.nomina + " Departamento: " + this.departamento;
    }

}
