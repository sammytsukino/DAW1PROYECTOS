import java.util.Scanner;

public class CarryOn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Exit? (y exits)");
            String input = scanner.nextLine();
            if (input.equals("y"))
            {
                break;
            }
            scanner.close();
            System.out.println("Ok! Lets carry on");

        }
        System.out.println("Ready!");

    }

}
