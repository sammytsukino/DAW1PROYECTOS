package vialactea;

public class ViaLactea {
    private String nombre = null;
    private double masa = 0.0;
    private double volumen = 0.0;
    private int diametro = 0;
    private enum Tipo {LIQUIDO, TERRESTRE, GASEOSO};
    private boolean esObservable = false;
    private boolean esExterior = false;

    public ViaLactea(String nombre, double masa, double volumen, int diametro, boolean esObservable,
            boolean esExterior) {
        this.nombre = nombre;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.esObservable = esObservable;
        this.esExterior = esExterior;
    }

    public void imprimirXPantalla(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Masa: " + masa);
        System.out.println("Volumen: " + volumen);
        System.out.println("Diametro: " + diametro);
        System.out.println("Es Observable: " + esObservable);
        System.out.println("Es Exterior: " + esExterior);
    }

    public void getDensidad(){
        System.out.println("La densidad es: " + masa/volumen);
    }
    public void dentroVia(){
        if (esExterior = true) {
            System.out.println("Este planeta está dentro de la Vía Láctea");
        }
    }

public static void main(String[] args) {
    ViaLactea p1 = new ViaLactea("Mercurio", 3.3023, 4879.0, 2439, true, false);
    ViaLactea p2 = new ViaLactea("Venus", 4.869, 12104.0, 6052, true, false);
    ViaLactea p3 = new ViaLactea("Marte", 3.3023, 4879.0, 2439, true, false);
    ViaLactea p4 = new ViaLactea("Júpiter", 1.898, 88.9, 147, true, false);


System.out.println("El planeta " + p1.nombre + " tiene una densidad de " + p1.masa/p1.volumen + " y un diametro de " + p1.diametro);
System.out.println("El planeta " + p2.nombre + " tiene una densidad de " + p2.masa/p2.volumen + " y un diametro de " + p2.diametro);
System.out.println("El planeta " + p3.nombre + " tiene una densidad de " + p3.masa/p3.volumen + " y un diametro de " + p3.diametro);
System.out.println("El planeta " + p4.nombre + " tiene una densidad de " + p4.masa/p4.volumen + " y un diametro de " + p4.diametro);

    }

}