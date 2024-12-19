package animales;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de cada animal
        Perro perro = new Perro();
        Lobo lobo = new Lobo();
        Leon leon = new Leon();
        Gato gato = new Gato();

        // Probar métodos de Perro
        System.out.println("Perro:");
        System.out.println("Sonido: " + perro.getSonido());
        System.out.println("Nombre Científico: " + perro.getNombreCientifico());
        System.out.println("Entorno: " + perro.getEntorno());
        System.out.println("Comida: " + perro.getComida());

        // Probar métodos de Lobo
        System.out.println("\nLobo:");
        System.out.println("Sonido: " + lobo.getSonido());
        System.out.println("Nombre Científico: " + lobo.getNombreCientifico());
        System.out.println("Entorno: " + lobo.getEntorno());
        System.out.println("Comida: " + lobo.getComida());

        // Probar métodos de León
        System.out.println("\nLeón:");
        System.out.println("Sonido: " + leon.getSonido());
        System.out.println("Nombre Científico: " + leon.getNombreCientifico());
        System.out.println("Entorno: " + leon.getEntorno());
        System.out.println("Comida: " + leon.getComida());

        // Probar métodos de Gato
        System.out.println("\nGato:");
        System.out.println("Sonido: " + gato.getSonido());
        System.out.println("Nombre Científico: " + gato.getNombreCientifico());
        System.out.println("Entorno: " + gato.getEntorno());
        System.out.println("Comida: " + gato.getComida());
    }
}