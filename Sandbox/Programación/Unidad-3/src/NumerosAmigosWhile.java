public class NumerosAmigosWhile {

    public static void main(String[] args) {
        int num1 = 220;
        int num2 = 284;
        int sum = 0;
        int i = 1;

        /*
         * for (int i=1; i<num1; i++) {
         * if (num1 % i == 0) {
         * sum += i;
         * }
         * }
         */

        while (i < num1) {
            if (num1 % i == 0) {
                sum += i;
            }
            i++;
        }

        if (sum == num2) {
            sum = 0;

            /*
             * for (int i=1; i<num2; i++) {
             * if (num2 % i == 0) {
             * sum += i;
             * }
             * }
             */

            i = 1;
            while (i < num2) {
                if (num2 % i == 0) {
                    sum += i;
                }
                i++;
            }
        }

        if (sum == num1) {
            System.out.println("Son números amigos");
        } else {
            System.out.println("No son números amigos");
        }
    }
}
