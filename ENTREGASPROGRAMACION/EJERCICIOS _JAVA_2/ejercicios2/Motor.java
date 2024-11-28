package ejercicios2;
public class Motor {
    private boolean encendido;

    public Motor() {
        encendido = false;
    }

    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println("El motor se ha encendido");
        } else {
            System.out.println("El motoy ya está apagado");
        }

    }

    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println("El motor se ha apagado");
        } else {
            System.out.println("El motor ya está encendido");
        }

    }

    public boolean estaEncendido() {
        return encendido;
    }

    public static void main(String[] args) {

        Motor motor1 = new Motor();

        System.out.println("Vamos a encender el motor.");
        motor1.encender();

        System.out.println("Vamos a apagar el motor.");
        motor1.apagar();

    }

}
