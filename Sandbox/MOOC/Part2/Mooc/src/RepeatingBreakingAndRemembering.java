
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {
        
        // This exercise is worth five exercise points, and it is 
        // gradually extended part by part.
        
        // If you want, you can send this exercise to the server
        // when it's just partially done. In that case the server will complain about 
        // the parts you haven't done, but you'll get points for the finished parts.
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give numbers");
        int sum = 0;
        int count = 0;
        double average = 0;
        int even= 0;
        int odd=0;


        while (true) {
            int numbers = Integer.valueOf(scanner.nextLine());

            if (numbers == -1) {
                System.out.println("Thx! Bye!");
                break;
            }

            if (numbers % 2 == 0) {
                even++;

            }

            if (numbers %2 != 0) {
                odd++;
            }


            sum += numbers;
            count++;
        
            }
            
            System.out.println("Sum: " + sum);
            System.out.println("Numbers: " + count);
            average = ((sum*1.0) / count);
            System.out.println("Average: " + average);
            System.out.println("Number of evens: " + even);
            System.out.println("Number of odds: " + odd);

        }
        }


