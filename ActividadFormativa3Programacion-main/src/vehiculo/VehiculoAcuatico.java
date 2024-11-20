package vehiculo;

public class VehiculoAcuatico extends Vehiculo implements Vela {
	private Tipo tipo;
	private int capacidadPasajeros;
	
	public VehiculoAcuatico (Tipo tipo, int capacidadPasajeros) {
		super();
		this.tipo = tipo;
		this.capacidadPasajeros = capacidadPasajeros;
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
	
	public boolean recomendarVelocidad(int velocidadViento) {
		boolean recomendarSalir;
		if (velocidadViento > 80) {
			recomendarSalir = false;
			System.out.println("No se recomienda salir con viento tan fuerte");
			velocidadActual = 0;
		} else if (velocidadViento < 10) {
			recomendarSalir = false;
			System.out.println("No se recomienda salir con viento con suave");
			velocidadActual = 0;
		} else {
			recomendarSalir = true;
			System.out.println("¡El viento está perfecto para salir!");
		}
		return recomendarSalir;
	}
}
