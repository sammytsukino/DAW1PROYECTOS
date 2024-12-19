package animales;

public class Gato extends Felino {
    public Gato() {
        super("doméstico", "ratones", "maullido", "Felis silvestris catus");
    }

    @Override
    public String getSonido() {
        return "maullido";
    }

    @Override
    public String getNombreCientifico() {
        return "Felis silvestris catus";
    }

    @Override
    public String getEntorno() {
        return "doméstico";
    }

    @Override
    public String getComida() {
        return "ratones";
    }
}