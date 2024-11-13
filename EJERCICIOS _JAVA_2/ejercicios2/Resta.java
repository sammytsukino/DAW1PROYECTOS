package ejercicios2;

public class Resta {

    private int int1;
    private int int2;
    private int int3;
    private double double1;
    private double double2;
    private double double3;

    public Resta(int int1, int int2, int int3, double double1, double double2, double double3) {

        this.int1 = int1;
        this.int2 = int2;
        this.int3 = int3;
        this.double1 = double1;
        this.double2 = double2;
        this.double3 = double3;
    }

    public void primeraOperacion(int int1, int int2) {
        int totalResta = int1 - int2;
        System.out.println("La primera resta da: " + totalResta);

    }

    public void segundaOperacion(int int1, int int2, int int3) {
        int totalResta = int1 - int2 - int3;
        System.out.println("La segunda resta da: " + totalResta);

    }

    public void terceraOperacion(double double1, double double2) {
        double totalResta = double1 - double2;
        System.out.println("La tercera resta da: " + totalResta);

    }

    public void cuartaOperacion(double double1, double double2, double double3) {
        double totalResta = double1 - double2 - double3;
        System.out.println("La cuarta resta da: " + totalResta);

    }

    public static void main(String[] args) {
        Resta resta1 = new Resta(5, 3, 0, 0, 0, 0);
        resta1.primeraOperacion(5, 3);
        Resta resta2 = new Resta(5, 3, 1, 0, 0, 0);
        resta2.segundaOperacion(5, 3, 1);
        Resta resta3 = new Resta(0, 0, 0, 1.5, 0.75, 0);
        resta3.terceraOperacion(1.5, 0.75);
        Resta resta4 = new Resta(0, 0, 0, 1.5, 0.75, 0.5);
        resta4.cuartaOperacion(1.5, 0.75, 0.5);

    }

}