package libreria;

public class Prestamo {

	@Override
	public String toString() {
		return "Prestamo [id_libro=" + id_libro + ", fecha_prestamo=" + fecha_prestamo + ", devuelto=" + devuelto + "]";
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public int getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(int fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	public Prestamo(int id_libro, int fecha_prestamo, boolean devuelto) {
		super();
		this.id_libro = id_libro;
		this.fecha_prestamo = fecha_prestamo;
		this.devuelto = devuelto;
	}

	private int id_libro;
	private int fecha_prestamo;
	private boolean devuelto;

}
