package paquete1;

public class Superclase {
public void metodo1() {
System.out.println("M�todo p�blico"); //Acceso desde cualquier sitio
}
private void metodo2() {
System.out.println("M�todo privado"); //No se puede acceder
}
protected void metodo3() {
System.out.println("M�todo protegido"); //Mismo paquete permite el acceso 
}
void metodo4() {
System.out.println("M�todo sin modificador"); //Visibilidad de paquete
}
}