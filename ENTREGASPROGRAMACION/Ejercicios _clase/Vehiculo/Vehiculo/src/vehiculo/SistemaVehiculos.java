package vehiculo;

public class SistemaVehiculos {
    public static void main(String[] args) {

        VehiculoTerrestre furgoneta = new VehiculoTerrestre(3, UsoVehiculo.CIVIL);
        

        System.out.println("--- Furgoneta ---");
        furgoneta.acelerar(20);
        furgoneta.imprimir();
        int revoluciones = furgoneta.calcularRevolucionesMotor(6, 10);
        System.out.println("Revoluciones del motor: " + revoluciones);
        

        VehiculoAcuatico barcoVelero = new VehiculoAcuatico(TipoVehiculoAcuatico.SUPERFICIE, 20);
        

        System.out.println("\n--- Barco Velero ---");
        barcoVelero.acelerar(10);
        barcoVelero.recomendarVelocidad(85);
        barcoVelero.imprimir();
        barcoVelero.frenar(20);
        System.out.println("Después de frenar:");
        barcoVelero.imprimir();
    }
}