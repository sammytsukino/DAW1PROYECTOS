package animales;

/**
 * Implementación de un Lobo utilizando la interfaz de Cánido.
 * Proporciona detalles específicos sobre el lobo en su hábitat natural.
 */
public class LoboInterfaz implements InterfazCanido {
    // Constantes para evitar repetición de valores
    private static final String HABITAT = "bosque";
    private static final String COMIDA = "carnívora";
    private static final String SONIDO = "aullido";
    private static final String NOMBRE_CIENTIFICO = "Canis lupus";

    @Override
    public String getSonido() {
        return SONIDO;
    }

    @Override
    public String getNombreCientifico() {
        return NOMBRE_CIENTIFICO;
    }

    @Override
    public String getEntorno() {
        return HABITAT;
    }

    @Override
    public String getComida() {
        return COMIDA;
    }

    /**
     * Método adicional específico de los cánidos.
     */
    @Override
    public String getCaracteristicaCanido() {
        return "Lobo salvaje, depredador del bosque";
    }
}