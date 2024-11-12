package viaLactea;



public class ViaLactea {
	

public enum TipoElemento {
    LIQUIDO,
    TERRESTRE,
    GASEOSO

}

    private String nombre = null;
    private double masa = 0.0;
    private double volumen = 0.0;
    private int diametro = 0;
    private boolean esObservable = false;
    private boolean esExterior = false;
    private TipoElemento tipo;
    
    

    public ViaLactea(String nombre, double masa, double volumen, int diametro, boolean esObservable,
            boolean esExterior, TipoElemento tipo) {
        this.nombre = nombre;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.esObservable = esObservable;
        this.esExterior = esExterior;
        this.tipo = tipo;
    }

    public void imprimirXPantalla(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Masa: " + masa);
        System.out.println("Volumen: " + volumen);
        System.out.println("Diametro: " + diametro);
        System.out.println("Es Observable: " + esObservable);
        System.out.println("Es Exterior: " + esExterior);
        System.out.println("Su tipo es " + tipo);
        System.out.println("---------------");
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
    ViaLactea p1 = new ViaLactea("Mercurio", 3.3023, 4879.0, 2439, true, false, TipoElemento.GASEOSO);
    ViaLactea p2 = new ViaLactea("Venus", 4.869, 12104.0, 6052, true, false, TipoElemento.GASEOSO);
    ViaLactea p3 = new ViaLactea("Marte", 3.3023, 4879.0, 2439, true, false, TipoElemento.TERRESTRE);
    ViaLactea p4 = new ViaLactea("Júpiter", 1.898, 88.9, 147, true, false, TipoElemento.GASEOSO);
    
p1.imprimirXPantalla();
p2.imprimirXPantalla();
p3.imprimirXPantalla();
p4.imprimirXPantalla();


System.out.println("El planeta " + p1.nombre + " tiene una densidad de " + p1.masa/p1.volumen + " y un diametro de " + p1.diametro);
System.out.println("El planeta " + p2.nombre + " tiene una densidad de " + p2.masa/p2.volumen + " y un diametro de " + p2.diametro);
System.out.println("El planeta " + p3.nombre + " tiene una densidad de " + p3.masa/p3.volumen + " y un diametro de " + p3.diametro);
System.out.println("El planeta " + p4.nombre + " tiene una densidad de " + p4.masa/p4.volumen + " y un diametro de " + p4.diametro);

    }

}