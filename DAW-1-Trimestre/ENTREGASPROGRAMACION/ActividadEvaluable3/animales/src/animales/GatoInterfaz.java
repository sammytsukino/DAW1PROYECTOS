package animales;

/**
 * Implementación de un Gato utilizando la interfaz de Felino.
 * Proporciona detalles específicos sobre el gato doméstico.
 */
public class GatoInterfaz implements InterfazFelino {
    // Constantes para evitar repetición de valores
    private static final String HABITAT = "doméstico";
    private static final String COMIDA = "ratones";
    private static final String SONIDO = "maullido";
    private static final String NOMBRE_CIENTIFICO = "Felis silvestris catus";

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
        return "Gato doméstico, compañero de hogar";
    }
}