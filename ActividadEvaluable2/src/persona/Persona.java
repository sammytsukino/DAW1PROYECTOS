package persona;

public class Persona {
	
    private String nombre;
    private String apellidos;
    private String dni;
    private int anyoDeNacimiento;
    //Ejercicio 2
    private char genero;
    
    
    
    public Persona(String nombre, String apellidos, String dni, int anyoDeNacimiento, char genero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.anyoDeNacimiento = anyoDeNacimiento;
        this.genero = genero;
    }
    
    public void imprimirXPantalla() {
        System.out.println("Datos de la persona:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("DNI: " + dni);
        System.out.println("A�o de nacimiento: " + anyoDeNacimiento);
        System.out.println("G�nero: " + genero);
        System.out.println("------------------------");
    }
}