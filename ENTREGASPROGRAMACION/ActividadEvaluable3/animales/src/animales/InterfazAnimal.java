package animales;

/**
 * Interfaz que define los métodos básicos para todos los animales.
 * Cada animal debe implementar estos métodos para proporcionar 
 * información específica sobre su naturaleza.
 */
public interface InterfazAnimal {
    /**
     * Obtiene el sonido característico del animal.
     */
    String getSonido();

    /**
     * Obtiene el nombre científico del animal.
     */
    String getNombreCientifico();

    /**
     * Obtiene el entorno o hábitat natural del animal.
     */
    String getEntorno();

    /**
     * Obtiene el tipo de alimentación del animal.
     */
    String getComida();
}