public class Estudiante {

    private String nombre;
    private String apellidos;
    private String DNI;
    private int edad;
    private String ciclo;
    private String telefono;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Estudiante(String nombre, String apellidos, String DNI, int edad, String ciclo, String telefono, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.edad = edad;
        this.ciclo = ciclo;
        this.telefono = telefono;
        this.email = email;
    }

    public static void main(String[] args) {
        Estudiante[] estudiantes = new Estudiante[5];
        estudiantes[0] = new Estudiante("Juan", "Garcia", "12345678A", 20, "DAW", "666666666", "juan@gmail.com");
        estudiantes[1] = new Estudiante("Pedro", "Gomez", "87654321B", 21, "DAW", "666666666", "pedro@gmail.com");
        estudiantes[2] = new Estudiante("Maria", "Lopez", "12348765C", 22, "DAW", "666666666", "maria@gmail.com");
        estudiantes[3] = new Estudiante("Ana", "Martinez", "56781234D", 23, "DAW", "666666666", "ana@gmail.com");
        estudiantes[4] = new Estudiante("Luis", "Perez", "43218765E", 24, "DAW", "666666666", "luis@gmail.com");

        int totalEdad = 0;
        int numeroEstudiantes = estudiantes.length;

        for (int i = 0; i < numeroEstudiantes; i++) {
            totalEdad += estudiantes[i].getEdad();
        }

        double mediaEdad = (double) totalEdad / numeroEstudiantes;
        System.out.println("La media de las edades de los estudiantes es: " + mediaEdad);
    }

}
