package animales;

/**
 * Interfaz que representa a los animales de la familia de los cánidos.
 * Extiende la interfaz base de Animal para añadir comportamientos específicos.
 */
public interface InterfazCanido extends InterfazAnimal {
    /**
     * Método específico para cánidos que podría añadir 
     * comportamientos o características únicas.
     */
    default String getCaracteristicaCanido() {
        return "Mamífero de la familia de los cánidos";
    }
}