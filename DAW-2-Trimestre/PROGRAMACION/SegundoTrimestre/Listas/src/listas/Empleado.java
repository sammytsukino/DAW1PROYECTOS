package listas;

public class Empleado {
	private String nombre;
	private String apellidos;
	private String email;
	private String dni;
	private double nomina;
	private String departamento;
	
	public Empleado(String nombre, String apellidos, String email, String dni, double nomina, String departamento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "Empleado [nombre=" + this.getNombre() + ", apellidos=" + this.getApellidos() + ", email=" + this.getEmail() + ", dni=" + this.getDni()
				+ ", nomina=" + this.getNomina() + ", departamento=" + this.getDepartamento()+ "]";
	}
	
	
	
	
}
