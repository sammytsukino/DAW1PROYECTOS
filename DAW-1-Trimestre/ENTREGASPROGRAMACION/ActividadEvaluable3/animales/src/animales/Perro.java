package animales;

public class Perro extends Canido {
    public Perro() {
        super("doméstico", "carnívora", "ladrido", "Canis lupus familiaris");
    }

    @Override
    public String getSonido() {
        return "ladrido";
    }

    @Override
    public String getNombreCientifico() {
        return "Canis lupus familiaris";
    }

    @Override
    public String getEntorno() {
        return "doméstico";
    }

    @Override
    public String getComida() {
        return "carnívora";
    }
}