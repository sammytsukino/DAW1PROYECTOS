public class Bicis {
    enum bicis {
        Yamaha, Suzuki, Peugeot, Orbea, Monty, Canyon;
    }

    static String marca;

    public static void main(String[] args) {
        bicis b;
        b = bicis.Orbea;
        switch (b) {
            case Yamaha:
            marca = "Yamaha";
            break;
            case Suzuki:
            marca = "Suzuki";
            break;
            case Peugeot:
            marca = "Peugeot";
            break;
            case Orbea:
            marca = "Orbea";
            break;
            case Monty:
            marca = "Monty";
            break;
            case Canyon:
            marca = "Canyon";
            break;
            default:
            marca = "Marca no encontrada";
        }
        System.out.println("La bicicleta es de la marca " + marca);
    }

}
