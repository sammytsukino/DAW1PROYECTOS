package paquete1;

public class Superclase {
public void metodo1() {
System.out.println("Método público"); //Acceso desde cualquier sitio
}
private void metodo2() {
System.out.println("Método privado"); //No se puede acceder
}
protected void metodo3() {
System.out.println("Método protegido"); //Mismo paquete permite el acceso 
}
void metodo4() {
System.out.println("Método sin modificador"); //Visibilidad de paquete
}
}