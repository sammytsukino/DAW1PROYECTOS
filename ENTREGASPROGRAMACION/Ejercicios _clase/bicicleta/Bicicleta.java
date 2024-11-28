package bicicleta;

public class Bicicleta {
	
	public enum tipo {MONTAÑA, CARRETERA, CIUDAD}
	public enum tamaño {NIÑO, ADULTO}
	
		private String color;
		private int pulgadas;
		private String marca;
		private boolean esElectrica;
		private float precio;
		private boolean tieneLuces;
		private tipo tipo;
		private tamaño tamaño;
		private static final int velocidadMaxima=25;
		private int velocidad;
		
	
	public Bicicleta(String color, int pulgadas, String marca, boolean esElectrica, float precio, boolean tieneLuces, tipo tipo, tamaño tamaño, int velocidad) {
		
		this.color=color;
		this.pulgadas=pulgadas;
		this.marca=marca;
		this.esElectrica = esElectrica;
		this.precio = precio;
		this.tieneLuces = tieneLuces;
		this.tipo = tipo;
		this.tamaño = tamaño;
		this.velocidad = velocidad;
	
}
	public int getVelocidad() {
		return velocidad;
	}
	
	public Bicicleta (String color) {
		
		this.color=color;
	
}
	
	public Bicicleta (float precio) {
		
		this.precio=precio;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(int pulgadas) {
		if (pulgadas >= 27) { System.out.println("No se puede cambiar la rueda.");
			
		} else {
		
			this.pulgadas = pulgadas;
		
		}
	}
	public boolean isEsElectrica() {
		return esElectrica;
	}
	public void setEsElectrica(boolean esElectrica) {
		this.esElectrica = esElectrica;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
		System.out.println("El precio es " + precio);
	}
	public boolean isTieneLuces() {
		return tieneLuces;
	}

	public String getMarca() {
		return marca;
	}
	public tipo getTipo() {
		return tipo;
	}
	public tamaño getTamaño() {
		return tamaño;
	}
	public boolean sePuedeRecargarBicicleta (){
		if (!esElectrica) { System.out.println("No se puede recargar. La bici no es eléctrica!");
		} else { System.out.println("Se puede recargar la bici");
		}
		return true;
}
	public boolean ponerLuces() {
		if (tieneLuces) { 
			System.out.println("Ya tiene luces"); 
			return false;
		} else {
			this.tieneLuces=true;
			return true;
		}
		}
		
		public void acelerar(int velocidad) {
			if (velocidad <0) { System.out.println("No puedes acelerar en negativo"); }
			if (this.velocidad+velocidad>=velocidadMaxima) { System.out.println("No puedes acelerar más!");
			} else {
				this.velocidad+=velocidad;
			}
		}
}
