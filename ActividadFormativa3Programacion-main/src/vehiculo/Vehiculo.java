package vehiculo;

public abstract class Vehiculo {
	public static int velocidadActual = 0;
	public static final int VELOCIDAD_MAXIMA = 120;
	
	
	public abstract int acelerar(int velocidad);
	public abstract int frenar(int velocidad);
}
