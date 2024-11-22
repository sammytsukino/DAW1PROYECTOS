package factorial;

public class Factorial {
	public static void main(String[] args) {
        int number = 5; 
        int result = calculateFactorial(number); 
        System.out.println("El factorial de " + number + " es " + result);
    }

    public static int calculateFactorial(int n) {
        int result = 1;
        
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        
        return result;
    }

}
