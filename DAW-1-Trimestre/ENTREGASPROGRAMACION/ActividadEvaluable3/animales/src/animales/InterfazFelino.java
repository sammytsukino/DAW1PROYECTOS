package animales;

/**
 * Interfaz que representa a los animales de la familia de los felinos.
 * Extiende la interfaz base de Animal para añadir comportamientos específicos.
 */
public interface InterfazFelino extends InterfazAnimal {
    /**
     * Método específico para felinos que podría añadir 
     * comportamientos o características únicas.
     */
    default String getCaracteristicaFelino() {
        return "Mamífero de la familia de los felinos";
    }
}