import java.util.Scanner;

public class SumOfASequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First number?");
        int start = Integer.valueOf(scanner.nextLine());
        System.out.println("Last number?");
        int end = Integer.valueOf(scanner.nextLine());

        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += i;
            System.out.println(i);
        }

        System.out.println("The sum is: " + sum);
    }
}
