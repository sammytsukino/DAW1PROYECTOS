public class Main {
    public static void main(String[] args) {
        int number = 3;
        int result = factorial(number);
        System.out.println("El factorial de " + number + " es " + result);

    }
    public static int factorial (int n) {
        if (n<=1) {
            return 1;
        }
            return n*factorial(n-1);
            
        }
}

