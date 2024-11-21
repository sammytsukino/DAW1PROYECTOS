package vehiculo;

public abstract class Vehiculo {
    protected int velocidadActual;
    protected static final int VELOCIDAD_MAXIMA = 120;

    public Vehiculo() {
        this.velocidadActual = 0;
    }

    public void acelerar(int velocidad) {
        if (velocidadActual + velocidad <= VELOCIDAD_MAXIMA) {
            velocidadActual += velocidad;
        } else {
            velocidadActual = VELOCIDAD_MAXIMA;
        }
    }

    public void frenar(int velocidad) {
        if (velocidadActual - velocidad >= 0) {
            velocidadActual -= velocidad;
        } else {
            velocidadActual = 0;
        }
    }

    public void imprimir() {
        System.out.println("Velocidad actual: " + velocidadActual + " km/h");
        System.out.println("Velocidad máxima: " + VELOCIDAD_MAXIMA + " km/h");
    }
}