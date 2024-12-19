package forma;

public abstract class Forma {
	private String nombreForma="";
	private boolean isRegular;
	private boolean tieneVolumen;
	
	public Forma(String nombreForma, boolean isRegular, boolean tieneVolumen) {
		this.nombreForma=nombreForma;
		this.isRegular=isRegular;
		this.tieneVolumen=tieneVolumen;
	}
	
	public abstract double area();
	public abstract double perimetro();
	public abstract double volumen();
	
}
