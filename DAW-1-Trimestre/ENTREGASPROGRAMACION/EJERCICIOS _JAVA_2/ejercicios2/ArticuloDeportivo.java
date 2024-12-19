package ejercicios2;

public class ArticuloDeportivo {

    private String nombre;
    private String autor;
    private String palabrasClave;
    private String nombrePublicacion;
    private int fecha;
    private String resumen;

    // Primer constructor
    public ArticuloDeportivo(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    // Segundo constructor
    public ArticuloDeportivo(String nombre, String autor, String palabrasClave, String nombrePublicacion, int fecha) {
        this(nombre, autor);
        this.palabrasClave = palabrasClave;
        this.nombrePublicacion = nombrePublicacion;
        this.fecha = fecha;
    }

    // Tercer constructor
    public ArticuloDeportivo(String nombre, String autor, String palabrasClave, String nombrePublicacion, int fecha, String resumen) {
        this(nombre, autor, palabrasClave, nombrePublicacion, fecha);
        this.resumen = resumen;
    }

    public void imprimirAtributos() {
        System.out.println("Artículo Deportivo");
        System.out.println("Nombre: " + nombre);
        System.out.println("Autor: " + autor);
        System.out.println("Palabras Claves: " + palabrasClave);
        System.out.println("Publicación: " + nombrePublicacion);
        System.out.println("Año: " + fecha);
        System.out.println("Resumen: " + resumen);
    }

    public static void main(String[] args) {
        // Usando el primer constructor
        ArticuloDeportivo articulo1 = new ArticuloDeportivo("Los fundamentos del baloncesto", "Pedro Sánchez");
        articulo1.imprimirAtributos();

        // Usando el segundo constructor
        ArticuloDeportivo articulo2 = new ArticuloDeportivo(
            "Nutrición en el deporte",
            "Laura González",
            "nutrición, salud, deporte",
            "Revista Fitness",
            2022
        );
        articulo2.imprimirAtributos();

        // Usando el tercer constructor
        ArticuloDeportivo articulo3 = new ArticuloDeportivo(
            "Estrategias en el fútbol moderno",
            "Miguel Torres",
            "estrategias, fútbol, tácticas",
            "Revista Fútbol Hoy",
            2023,
            "Este artículo explora las tácticas y estrategias avanzadas usadas en el fútbol moderno."
        );
        articulo3.imprimirAtributos();
    }
}
