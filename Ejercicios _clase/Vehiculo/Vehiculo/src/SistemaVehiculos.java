public class SistemaVehiculos {
    public static void main(String[] args) {
        // Crear una furgoneta
        VehiculoTerrestre furgoneta = new VehiculoTerrestre(4, UsoVehiculo.CIVIL);
        
        // Invocar métodos de la furgoneta
        System.out.println("--- Furgoneta ---");
        furgoneta.acelerar(50);
        furgoneta.imprimir();
        int revoluciones = furgoneta.calcularRevolucionesMotor(5, 10);
        System.out.println("Revoluciones del motor: " + revoluciones);
        
        // Crear un barco velero
        VehiculoAcuatico barcoVelero = new VehiculoAcuatico(TipoVehiculoAcuatico.SUPERFICIE, 20);
        
        // Invocar métodos del barco velero
        System.out.println("\n--- Barco Velero ---");
        barcoVelero.acelerar(40);
        barcoVelero.recomendarVelocidad(85);
        barcoVelero.imprimir();
        barcoVelero.frenar(20);
        System.out.println("Después de frenar:");
        barcoVelero.imprimir();
    }
}