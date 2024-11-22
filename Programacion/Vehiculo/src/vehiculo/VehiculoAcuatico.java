package vehiculo;

public class VehiculoAcuatico extends Vehiculo implements Vela {
    private TipoVehiculoAcuatico tipo;
    private int capacidadPasajeros;

    public VehiculoAcuatico(TipoVehiculoAcuatico tipo, int capacidadPasajeros) {
        super();
        this.tipo = tipo;
        this.capacidadPasajeros = capacidadPasajeros;
    }


    public void recomendarVelocidad(int velocidadViento) {
        if (velocidadViento > 80 || velocidadViento < 10) {
            velocidadActual = 0;
            System.out.println("No se recomienda navegar con esta velocidad de viento.");
        }
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Tipo: " + tipo);
        System.out.println("Capacidad de pasajeros: " + capacidadPasajeros);
    }
    public TipoVehiculoAcuatico getTipo() {
        return tipo;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }
}