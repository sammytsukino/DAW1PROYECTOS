package paquete2;

import paquete1.Superclase;
public class Subclase extends Superclase {
public static void main(String[] args) {
Subclase c1 = new Subclase();
c1.metodo1();
//c1.metodo2(); // ERROR DE
//VISIBILIDAD
c1.metodo3();
//c1.metodo4(); // ERROR DE VISIBILIDAD
}
}