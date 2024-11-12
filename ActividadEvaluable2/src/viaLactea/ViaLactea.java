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
        System.out.println("Nombre: " + nombre + ".");
        System.out.println("Masa: " + masa + " kilogramos.");
        System.out.println("Volumen: " + volumen + " kilómetros cúbicos.");
        System.out.println("Diametro: " + diametro + " kilómetros.");
        System.out.println("Es Observable: " + (esObservable ? "Sí" : "No") + ".");
        System.out.println("Es Exterior: " + (esExterior ? "Sí" : "No") + ".");
        System.out.println("Su tipo es " + tipo + ".");

    }

    public void getDensidad(){
        System.out.println("La densidad es: " + masa/volumen + " Kg/m3.");
        System.out.println("---------------");
    }
    public void dentroVia(){
        if (esExterior = true) {
            System.out.println("Este planeta está dentro de la Vía Láctea.");
        }
    }

public static void main(String[] args) {
    ViaLactea p1 = new ViaLactea("Mercurio", 3.3023, 4879.0, 2439, true, false, TipoElemento.GASEOSO);
    ViaLactea p2 = new ViaLactea("Venus", 4.869, 12104.0, 6052, true, false, TipoElemento.GASEOSO);
    ViaLactea p3 = new ViaLactea("Marte", 3.3023, 4879.0, 2439, true, false, TipoElemento.TERRESTRE);
    ViaLactea p4 = new ViaLactea("Júpiter", 1.898, 88.9, 147, true, false, TipoElemento.GASEOSO);
    
p1.imprimirXPantalla();
p1.getDensidad();
p2.imprimirXPantalla();
p2.getDensidad();
p3.imprimirXPantalla();
p3.getDensidad();
p4.imprimirXPantalla();
p4.getDensidad();

    }

}