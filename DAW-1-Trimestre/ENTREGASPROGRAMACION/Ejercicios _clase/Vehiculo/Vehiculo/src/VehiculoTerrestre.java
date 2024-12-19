package Vehiculo.Vehiculo.src;
public class VehiculoTerrestre extends Vehiculo implements Motor {
    private int cantidadRuedas;
    private UsoVehiculo uso;

    public VehiculoTerrestre(int cantidadRuedas, UsoVehiculo uso) {
        super();
        this.cantidadRuedas = cantidadRuedas;
        this.uso = uso;
    }

    @Override
    public int calcularRevolucionesMotor(int fuerza, int radio) {
        return fuerza * radio;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Cantidad de ruedas: " + cantidadRuedas);
        System.out.println("Uso: " + uso);
    }

    // Getters
    public int getCantidadRuedas() {
        return cantidadRuedas;
    }

    public UsoVehiculo getUso() {
        return uso;
    }
}