// Queremos sacar el promedio de unas calificaciones que van metidas en un Array. Tenemos que pedir por un Scanner el número de califaciones para saber la longitud del array (array.length). Después, tendremos que meter con un Scanner las calificaciones como tal. Luego tenemos que setear con un try-catch que no haya ninguna califación menor que 0. Ahora debemos calcular la media de todas las notas. 
public class Promedio {
    public static void main(String[] args) {
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        System.out.println("Introduce el número de calificaciones: ");
        int numCalif = entrada.nextInt();
        float[] calificaciones = new float[numCalif];
        float suma = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Introduce la calificación " + (i + 1) + ": ");
            calificaciones[i] = entrada.nextFloat();
            try {
                if (calificaciones[i] < 0 || calificaciones[i] > 10) {
                    throw new Exception("No se permiten calificaciones negativas.");
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                entrada.close();
            }
        }

        float promedio = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            suma += calificaciones[i];
        }
        promedio = suma / calificaciones.length;
        System.out.println("El promedio de las calificaciones es de " + promedio);
    }
}
