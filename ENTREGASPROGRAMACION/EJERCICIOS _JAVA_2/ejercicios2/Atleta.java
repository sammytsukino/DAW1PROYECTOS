package ejercicios2;

public class Atleta {

    private int id;
    private String nombre;
    private double tiempo;
    private static int contadorAtletas = 0;
    private static String seleccion = "Francia";
    private static double tiempoEquipo = 0;

    public Atleta(String nombre, double tiempo) {
        this.id = ++contadorAtletas; 
        this.nombre = nombre;
        this.tiempo = tiempo;
        correr100Metros();
    }

    private void correr100Metros() {
        tiempoEquipo += this.tiempo;
    }

    public static void imprimirSeleccion() {
        System.out.println("Selección de Atletismo: " + seleccion);
    }

    public static void imprimirTiempoEquipo() {
        System.out.println("Tiempo total del equipo: " + tiempoEquipo + " segundos");
    }

    public static void main(String[] args) {
        Atleta atleta1 = new Atleta("Pierre Dupont", 11.5);
        Atleta atleta2 = new Atleta("Jean Luc", 10.9);
        Atleta atleta3 = new Atleta("Antoine Griez", 11.3);
        Atleta atleta4 = new Atleta("Louis Martin", 10.7);

        Atleta.imprimirSeleccion();
        Atleta.imprimirTiempoEquipo();
    }
}
