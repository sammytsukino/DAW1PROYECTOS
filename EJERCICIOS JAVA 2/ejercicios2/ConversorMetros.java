
package ejercicios2;

public class ConversorMetros {
    double metros;
    final int FACTOR_METROS_CM = 100;
    final int FACTOR_METROS_MM = 1000;
    final double FACTOR_METROS_INCH = 39.7;
    final double FACTOR_METROS_PIES = 3.28;
    final double FACTOR_METROS_YARDAS = 1.09361;

    public ConversorMetros(double metros) {
        this.metros = metros;
    }

    public double convertirMetrosToCentímetros() {
        double centímetros;
        centímetros = FACTOR_METROS_CM * metros;
        return centímetros;
    }

    public double convertirMetrosToMilimetros() {
        double milimetros;
        milimetros = FACTOR_METROS_MM * metros;
        return milimetros;
    }

    public double convertirMetrosToInches() {
        double inches;
        inches = FACTOR_METROS_INCH * metros;
        return inches;
    }

    public double convertirMetrosToPies() {
        double pies;
        pies = FACTOR_METROS_PIES * metros;
        return pies;
    }

    public double convertirMetrosToYardas (){
            double yardas;
            yardas = FACTOR_METROS_YARDAS * metros;
            return yardas;
        }

public static void main(String[] args) {
    ConversorMetros conversor = new ConversorMetros(3.5);
    System.out.println("Metros a centímetros = " + conversor.convertirMetrosToCentímetros());
    System.out.println("Metros a milímetros = " + conversor.convertirMetrosToMilimetros());
    System.out.println("Metros a inches = " + conversor.convertirMetrosToInches());
    System.out.println("Metros a pies = " + conversor.convertirMetrosToPies());
    System.out.println("Metros a yardas = " + conversor.convertirMetrosToYardas());

}

}