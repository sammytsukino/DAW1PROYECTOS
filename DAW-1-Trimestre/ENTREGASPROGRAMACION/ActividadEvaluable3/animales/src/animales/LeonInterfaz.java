package animales;

/**
 * Implementación de un León utilizando la interfaz de Felino.
 * Proporciona detalles específicos sobre el león en su hábitat natural.
 */
public class LeonInterfaz implements InterfazFelino {
    // Constantes para evitar repetición de valores
    private static final String HABITAT = "pradera";
    private static final String COMIDA = "carnívora";
    private static final String SONIDO = "rugido";
    private static final String NOMBRE_CIENTIFICO = "Panthera leo";

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
     * Método adicional específico de los felinos.
     */
    @Override
    public String getCaracteristicaFelino() {
        return "León, rey de la pradera africana";
    }
}