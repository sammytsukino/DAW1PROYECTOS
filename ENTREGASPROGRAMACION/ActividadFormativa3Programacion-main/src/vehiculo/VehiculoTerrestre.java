package vehiculo;

public class VehiculoTerrestre extends Vehiculo implements Motor {
	private int cantidadRuedas;
	private Uso uso;
	private int fuerza;
	private int radio;
	
	public VehiculoTerrestre (int cantidadReudas, Uso uso, int fuerza, int radio) {
		super();
		this.cantidadRuedas = cantidadRuedas;
		this.uso = uso;
		this.fuerza = fuerza;
		this.radio = radio;
	}
	
	public int acelerar(int velocidad) {
		if (velocidad <= 0) {
			System.out.println("No puedes usar una velocidad 0 o negativa");
		} else if (velocidadActual + velocidad > VELOCIDAD_MAXIMA) {
			System.out.println("No puedes superar la velocidad máxima permitida (" + VELOCIDAD_MAXIMA + ").");
		} else {
			velocidadActual += velocidad;
			System.out.println("Aumentada la velocidad a " + velocidadActual + "km/h.");
		}
		return velocidadActual;
	}

	public int frenar(int velocidad) {
		if (velocidad <= 0) {
			System.out.println("No puedes usar una velocidad 0 o negativa");
		} else if (velocidadActual - velocidad < 0) {
			System.out.println("No puedes frenar por debajo de 0");
		} else {
			velocidadActual -= velocidad;
			System.out.println("Velocidad reducida a " + velocidadActual + "km/h.");
		}
		return velocidadActual;
	}
	
	public void imprimir() {
		System.out.println("La velocidad actual del vehículo es " + velocidadActual + "\nLa velocidad máxima del vehículo es " + VELOCIDAD_MAXIMA + ".");
	}
	
	public int calcularRevolucionesMotor(int fuerza, int radio) {
		int revoluciones = fuerza * radio;
		System.out.println("Este vehiculo tiene hasta " + revoluciones);
		return revoluciones;
		
	}
}
