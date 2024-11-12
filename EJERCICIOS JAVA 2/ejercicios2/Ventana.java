package ejercicios2;

public class Ventana {
    private boolean abierta;

    public Ventana() {
        abierta = false;
    }

    public void abrirVentana() {
        if (!abierta) {
            abierta = true;
            System.out.println("La ventana se ha abierto");
        } else {
            System.out.println("La ventana ya está abierta");
        }

    }

    public void cerrarVentana() {
        if (abierta) {
            abierta = false;
            System.out.println("La ventana se ha cerrado");
        } else {
            System.out.println("La ventana ya está cerrada");
        }

    }

    public boolean estaAbierta() {
        return abierta;

    }

    public void abiertoCerrado() {
        if (abierta == true) {
            System.out.println("La ventana está abierta");
        } else {
            System.out.println("La ventana está cerrada");
        }

    }

    public static void main(String[] args) {
        Ventana ventana1 = new Ventana();
        System.out.println("Vamos a abrir la ventana.");
        ventana1.abrirVentana();
        System.out.println("Vamos a cerrar la ventana.");
        ventana1.cerrarVentana();
        System.out.println("Vamos a abrir la ventana.");
        ventana1.abrirVentana();
        System.err.println("Cómo está ahora mismo la ventana?");
        ventana1.abiertoCerrado();

    }

    public boolean isAbierta() {
        return abierta;
    }

}
