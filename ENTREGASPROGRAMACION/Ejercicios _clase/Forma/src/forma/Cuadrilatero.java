package forma;

public class Cuadrilatero extends Forma{
	private double tamanyo, anchura;
	
	public Cuadrilatero (double tamanyo, double anchura,String nombre, boolean isRegular, boolean tieneVolumen) {
		super(nombre,isRegular,tieneVolumen);
		this.tamanyo=tamanyo;
		this.anchura=anchura;
	}
	public double perimetro() {
		return ((2*tamanyo)+(2*anchura));
	}
	public double area() {
		return (anchura*tamanyo);
	}
	public double volumen() {
		return 0;
	}
	// Declaración de nuevos métodos
}
