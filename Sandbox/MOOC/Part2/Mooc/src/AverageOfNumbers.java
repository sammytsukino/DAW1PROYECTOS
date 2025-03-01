import java.util.Scanner;

public class AverageOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int count = 0;
        int sum = 0;
        while (true) {
            System.out.println("Give a number");
            int number = Integer.valueOf(scanner.nextLine());

            if (number != 0) {
                sum = sum + number;
                count++;
                continue;       

            } else if (number ==0) {
                break;
                
            }
            
        }
        double average = (sum*1.0)/count;
        System.out.println("Average of the numbers:" + average);
    }

}
