package libro;

public class Libro {

    public enum Genero { HISTORIA, COMEDIA, NOVELA, TERROR}
private String escritor;
private Genero genero;
private int paginas;
private String fecha;
private double calificacion;

public Libro(String escritor, String fecha, Genero genero, int paginas, int par1, double calificacion) {
    this.escritor = escritor;
    this.genero = genero;
    this.paginas = paginas;
    this.fecha = fecha;
    this.calificacion = calificacion;
}

public String getEscritor() {
    return escritor;
}

private void setEscritor(String escritor) {
    this.escritor = escritor;
}

public Genero getGenero() {
    return genero;
}

private void setGenero(Genero genero) {
    this.genero = genero;
}

public int getPaginas() {
    return paginas;
}

private void setPaginas(int paginas) {
    this.paginas = paginas;
}

public String getFecha() {
    return fecha;
}

private void setFecha(String fecha) {
    this.fecha = fecha;
}

public double getCalificacion() {
    return calificacion;
}

private void setCalificacion(double calificacion) {
    this.calificacion = calificacion;
}

private void imprimir() {
    System.out.println("Escritor: " + escritor);
    System.out.println("Género: " + genero);
    System.out.println("Fecha: " + fecha);
    System.out.println("Páginas: " + paginas);
    System.out.println("Calificación: " + calificacion);
}

private boolean esLibroListo(){
    return paginas <50;
}

private String calcularValoracion(){
    if (calificacion >= 0 && calificacion <= 3) {
        return "Muy malo";
    } else if (calificacion > 3 && calificacion <= 5) {
        return "Malo";
    } else if (calificacion > 5 && calificacion <= 6) {
        return "Regular";
    } else if (calificacion > 6 && calificacion <= 8) {
        return "Bueno";
    } else if (calificacion > 8 && calificacion <= 10) {
        return "Excelente";
    } else {
        return "Calificación inválida";
}

}

private boolean esLibroSimilar(Libro otroLibro){
    if (otroLibro==null){
        return false;
    }
    return this.genero == otroLibro.getGenero() &&
    this.calcularValoracion().equals(otroLibro.calcularValoracion());
}

public static void main(String[] args) {
    Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", Genero.NOVELA, 45, 1943, 9.5);
    Libro libro2 = new Libro("Don Quijote", "Miguel de Cervantes", Genero.NOVELA, 863, 1605, 9.0);
    Libro libro3 = new Libro("Cuento Corto", "Autor X", Genero.NOVELA, 30, 2023, 3.5);


    System.out.println("=== INFORMACIÓN DE LOS LIBROS ===");
    libro1.imprimir();
    libro1.esLibroListo();
    libro2.imprimir();
    libro2.esLibroListo();
    libro3.imprimir();
    libro3.esLibroListo();


    System.out.println("=== COMPARACIÓN DE LIBROS ===");
    System.out.println("¿Libro 1 y Libro 2 son similares?: " + 
        (libro1.esLibroSimilar(libro2) ? "Sí" : "No"));
    System.out.println("¿Libro 1 y Libro 3 son similares?: " + 
        (libro1.esLibroSimilar(libro3) ? "Sí" : "No"));
    System.out.println("¿Libro 2 y Libro 3 son similares?: " + 
        (libro2.esLibroSimilar(libro3) ? "Sí" : "No"));
}

}
