package animales;

/**
 * Implementación de un Perro utilizando la interfaz de Cánido.
 * Proporciona detalles específicos sobre el perro doméstico.
 */
public class PerroInterfaz implements InterfazCanido {
    // Constantes para evitar repetición de valores
    private static final String HABITAT = "doméstico";
    private static final String COMIDA = "carnívora";
    private static final String SONIDO = "ladrido";
    private static final String NOMBRE_CIENTIFICO = "Canis lupus familiaris";

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
        return "Perro doméstico, compañero del ser humano";
    }
}