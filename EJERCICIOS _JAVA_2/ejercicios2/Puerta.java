package ejercicios2;
public class Puerta {
    private boolean abierta;
    
    public Puerta(boolean abierta) {
        this.abierta = abierta;
    }

    public Puerta() {
        abierta = false;
    }

    public void abrir() {
        if (!abierta) {
            abierta = false;
            System.out.println("La puerta se ha abierto");
        } else {
            System.out.println("La puerta ya está abierta");
        }
    }

    public void cerrar() {
        if (abierta) {
            abierta = true;
            System.out.println("La puerta se ha cerrado");
        } else {
            System.out.println("La puerya ya está cerrada");

        }
    }

    public void abiertoCerrado() {
        if (abierta == true) {
            System.out.println("La puerta está abierta");
        } else {
            System.out.println("La puerta está cerrada");
        }

    }

    public static void main(String[] args) {
        Puerta puerta1 = new Puerta();
        System.out.println("Vamos a abrir la puerta.");
        puerta1.abrir();
        System.out.println("Vamos a cerrar la puerta.");
        puerta1.cerrar();
        System.out.println("Vamos a abrir la puerta.");
        puerta1.abrir();
        System.err.println("Cómo está ahora mismo la puerta?");
        puerta1.abiertoCerrado();

    }


}


