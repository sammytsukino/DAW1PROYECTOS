package vehiculo;

public class Main {
	public static void main(String[] args) {
		VehiculoTerrestre furgoneta = new VehiculoTerrestre(5, Uso.CIVIL, 90, 30);
		
		VehiculoAcuatico velero = new VehiculoAcuatico(Tipo.SUPERFICIE, 7);

		VehiculoTerrestre coche = new VehiculoTerrestre(4, Uso.CIVIL, 100, 20);

		

		furgoneta.imprimir();
		
		velero.imprimir();

		coche.imprimir();

		coche.acelerar(100);

		coche.frenar(20);	
		
		furgoneta.acelerar(60);
		
		furgoneta.acelerar(100);
		
		furgoneta.frenar(100);
		
		velero.acelerar(150);
		
		velero.frenar(15);
		
		furgoneta.calcularRevolucionesMotor(15, 10);
		
	}
	
	
}
