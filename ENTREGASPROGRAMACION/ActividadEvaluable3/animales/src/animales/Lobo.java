package animales;

public class Lobo extends Canido {
    public Lobo() {
        super("bosque", "carnívora", "aullido", "Canis lupus");
    }

    @Override
    public String getSonido() {
        return "aullido";
    }

    @Override
    public String getNombreCientifico() {
        return "Canis lupus";
    }

    @Override
    public String getEntorno() {
        return "bosque";
    }

    @Override
    public String getComida() {
        return "carnívora";
    }
}