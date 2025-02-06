import java.util.Scanner;

public class Comprador {
    String nombre;
    String apellidos;
    String dni;
    int edad;

public Comprador (String nombre, String apellidos) {
    this.nombre=nombre;
    this.apellidos=apellidos;
}

    public Comprador(String nombre, String apellidos, String dni, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public void imprimirComprador() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellidos: " + this.getApellidos());
        System.out.println("DNI: " + this.getDni());
        System.out.println("Edad: " + this.getEdad());
    }

    public void comprobarEdad(int edad) {
        if (edad<18) {
            throw new IllegalArgumentException("El comprador debe ser mayor de edad");
        } if (edad >= 0 && edad <98) {
            this.edad=edad;
        } else throw new IllegalArgumentException("La edad no es válida");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del comprador: ");
        String a = sc.nextLine();
        System.out.println("Introduce los apellidos del comprador: ");
        String b = sc.nextLine();
        System.out.println("Introduce el DNI del comprador: ");
        String c = sc.nextLine();
        System.out.println("Introduce la edad del comprador: ");
        int d = sc.nextInt();
        
        Comprador comprador = new Comprador (a, b);
        comprador.comprobarEdad(d);

    }
}
