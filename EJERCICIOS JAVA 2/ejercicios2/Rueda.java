package ejercicios2;

public class Rueda {

    private final int capacidadMaxima;
    private int capacidadActual;

    public Rueda() {
        this.capacidadMaxima = 100;
        this.capacidadActual = 0;
    }

    public void llenarRueda() {
        if (capacidadActual == capacidadMaxima) {
            System.out.println("La rueda ya está completamente llena");
        } else {
            capacidadActual = capacidadMaxima;
            System.out.println("La rueda se ha llenado por completo");
        }
    }

    public void vaciarRueda() {
        if (capacidadActual == 0) {
            System.out.println("La rueda ya está vacía");
        } else {
            capacidadActual = 0;
            System.out.println("La rueda se ha vaciado por completo");
        }
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }
}
