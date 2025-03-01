public class S05Ejercicio04 {
    public static void main(String[] args) {
        int start = 160;
        int end = 320;

        for (int i = end; i >= start; i-=20) {
            System.out.println(i);
        }

        int j = end;
        while (j >= start) {
            System.out.println(j);
            j-=20;
        }

        int k = end;

        do {
            System.out.println(k);
            k-=20;
            
        } while (k>= start);

    }

    }
