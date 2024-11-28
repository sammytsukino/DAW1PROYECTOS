package animales;

public abstract class Animal {
    // Atributos
    private String habitat;
    private String comida;
    private String sonido;
    private String nombreCientifico;

    // Constructor
    public Animal(String habitat, String comida, String sonido, String nombreCientifico) {
        this.habitat = habitat;
        this.comida = comida;
        this.sonido = sonido;
        this.nombreCientifico = nombreCientifico;
    }

    // Métodos abstractos
    public abstract String getSonido();
    public abstract String getNombreCientifico();
    public abstract String getEntorno();
    public abstract String getComida();
}