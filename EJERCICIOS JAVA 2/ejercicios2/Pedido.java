package ejercicios2;

public class Pedido {
    private String primerPlato;
    private double costoPrimerPlato;
    private String bebida;
    private double costoBebida;
    private String segundoPlato;
    private double costoSegundoPlato;
    private String postre;
    private double costoPostre;
    
public Pedido(String primerPlato, double costoPrimerPlato, String bebida, double costoBebida, String segundoPlato, double costoSegundoPlato, String postre, double costoPostre){
    this.primerPlato= primerPlato;
    this.costoPrimerPlato=costoPrimerPlato;
    this.bebida=bebida;
    this.costoBebida=costoBebida;
    this.segundoPlato=segundoPlato;
    this.costoSegundoPlato=costoSegundoPlato;
    this.postre=postre;
    this.costoPostre=costoPostre;

    
}
public void hacerPedido (String primerPlato, double costoPrimerPlato, String bebida, double costoBebida){
    double totalPedido= costoPrimerPlato + costoBebida;
    System.out.println("El coste del primer pedido es " + totalPedido + "€.");

}

public void hacerPedido (String primerPlato, double costoPrimerPlato, String bebida, double costoBebida, String segundoPlato, double costoSegundoPlato){
    double totalPedido= costoPrimerPlato + costoBebida + costoSegundoPlato;
    System.out.println("El coste del primer pedido es " + totalPedido + "€.");

}

public void hacerPedido (String primerPlato, double costoPrimerPlato, String bebida, double costoBebida, String segundoPlato, double costoSegundoPlato, String postre, double costoPostre){
    double totalPedido= costoPrimerPlato + costoBebida + costoSegundoPlato + costoPostre;
    System.out.println("El coste del primer pedido es " + totalPedido + "€.");
}
public static void main(String[] args) {
    Pedido pedido1 = new Pedido("San Jacobo", 7.5, "Cocacola", 2.3, null, 0, null, 0);
    pedido1.hacerPedido("San Jacobo", 7.5, "Cocacola", 2.3, null, 0, null, 0);
    Pedido pedido2 = new Pedido("San Jacobo", 7, "Cocacola", 2, "Croquetas", 5, null, 0);
    pedido2.hacerPedido("San Jacobo", 7, "Cocacola", 2, "Croquetas", 5, null, 0);
    Pedido pedido3 = new Pedido("San Jacobo", 7, "Cocacola", 2, "Croquetas", 5, "Arroz con leche", 5);
    pedido3.hacerPedido("San Jacobo", 7, "Cocacola", 2, "Croquetas", 5, "Arroz con leche", 5);

}

}