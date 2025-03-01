import java.util.Scanner;

public class NumberOfNumbers {
    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Give a number");
            int number = Integer.valueOf(scanner.nextLine());

            if (number != 0) {
                count++;
                continue;
            } else if (number == 0) {
                break;
            }
        }

        System.out.println("Number of numbers:" + count);
        
    }

}
