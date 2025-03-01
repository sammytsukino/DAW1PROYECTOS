import java.util.Scanner;

public class WhereTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Where to?");
        int end = Integer.valueOf(scanner.nextLine());

        System.out.println("Where from?");
        int start = Integer.valueOf(scanner.nextLine());

        if (start <= end) { 
            for (int i = start; i <= end; i++) {
            System.out.println(i);
            }
        } else {
            System.out.println("Nope");
        }
        }
    }
