package animales;

/**
 * Clase principal para probar las implementaciones de las interfaces de animales.
 * Demuestra el uso de las interfaces y las implementaciones específicas.
 */
public class MainInterfaz {
    /**
     * Método principal para ejecutar las pruebas de las clases de animales.
     */
    public static void main(String[] args) {
        // Crear instancias de cada animal
        InterfazCanido perro = new PerroInterfaz();
        InterfazCanido lobo = new LoboInterfaz();
        InterfazFelino leon = new LeonInterfaz();
        InterfazFelino gato = new GatoInterfaz();

        // Método para imprimir detalles de un animal
        imprimirDetallesAnimal("Perro", perro);
        imprimirDetallesAnimal("Lobo", lobo);
        imprimirDetallesAnimal("León", leon);
        imprimirDetallesAnimal("Gato", gato);
    }

    /**
     * Método auxiliar para imprimir los detalles de un animal.
     */
    private static void imprimirDetallesAnimal(String nombreAnimal, InterfazAnimal animal) {
        System.out.println("\n" + nombreAnimal + ":");
        System.out.println("Sonido: " + animal.getSonido());
        System.out.println("Nombre Científico: " + animal.getNombreCientifico());
        System.out.println("Entorno: " + animal.getEntorno());
        System.out.println("Comida: " + animal.getComida());
        
        // Imprimir características específicas si es un Cánido o Felino
        if (animal instanceof InterfazCanido) {
            System.out.println("Característica Cánido: " + 
                ((InterfazCanido) animal).getCaracteristicaCanido());
        }
        if (animal instanceof InterfazFelino) {
            System.out.println("Característica Felino: " + 
                ((InterfazFelino) animal).getCaracteristicaFelino());
        }
    }
}