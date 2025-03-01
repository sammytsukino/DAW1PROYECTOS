public class S05Ejercicio01 {
public static void main(String[] args) {
    for (int i = 0; i <= 100; i+=5) {
    System.out.println(i);
    }

    int j = 0;
    while (j<100) {
        j+=5;
        System.out.println(j);
    }

    int k = 0;
    do {
        k+=5;
        System.out.println(k);
        
    } while (k < 100);
}
}