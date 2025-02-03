public class PerfectNumbers {
    // Para calcular los divisores de un numero, siempre hay que quedarse en la
    // mitad. Divisores de 16= 1, 2, 4, 8. Divisores de 32= 1, 2, 4, 8, 16.//
    public static void main(String[] args) {

        int sum = 0;
        int num = 28;
        int i = 1;

        do {
            if (num % i == 0) {
                sum += i;
                System.out.println(sum);
            }
            i++;
        } while (i <= num / 2);
        
        if (sum == num) {
            System.out.println("El número " + num + " es perfecto");
        } else {
            System.out.println("El número " + num + " no es perfecto");
        }

    }

}
