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
	
	
	public Bicicleta(String color, int pulgadas, String marca, boolean esElectrica, float precio, boolean tieneLuces, tipo tipo, tamaño tamaño) {
		
		this.color=color;
		this.pulgadas=pulgadas;
		this.marca=marca;
		this.esElectrica = esElectrica;
		this.precio = precio;
		this.tieneLuces = tieneLuces;
		this.tipo = tipo;
		this.tamaño = tamaño;
	
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
	}
	public boolean isTieneLuces() {
		return tieneLuces;
	}
	public void setTieneLuces(boolean tieneLuces) {
		this.tieneLuces = tieneLuces;
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
	public void ponerLuces() {
}
}
