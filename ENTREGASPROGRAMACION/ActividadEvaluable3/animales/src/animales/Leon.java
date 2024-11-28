package animales;

public class Leon extends Felino {
    public Leon() {
        super("pradera", "carnívora", "rugido", "Panthera leo");
    }

    @Override
    public String getSonido() {
        return "rugido";
    }

    @Override
    public String getNombreCientifico() {
        return "Panthera leo";
    }

    @Override
    public String getEntorno() {
        return "pradera";
    }

    @Override
    public String getComida() {
        return "carnívora";
    }
}