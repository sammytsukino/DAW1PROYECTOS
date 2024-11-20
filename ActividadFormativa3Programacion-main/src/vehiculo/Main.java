package vehiculo;

public class Main {
	public static void main(String[] args) {
		VehiculoTerrestre furgoneta = new VehiculoTerrestre(5, Uso.CIVIL, 90, 30);
		
		VehiculoAcuatico velero = new VehiculoAcuatico(Tipo.SUPERFICIE, 7);

		furgoneta.imprimir();
		
		velero.imprimir();
		
		furgoneta.acelerar(60);
		
		furgoneta.acelerar(100);
		
		furgoneta.frenar(100);
		
		velero.acelerar(150);
		
		velero.frenar(15);
		
		furgoneta.calcularRevolucionesMotor()
		
	}
	
	
}
