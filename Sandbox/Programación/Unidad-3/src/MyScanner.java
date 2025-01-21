import java.util.Scanner;

public class MyScanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu dato de tipo byte:");
        byte myByte = sc.nextByte();
        System.out.println("Escribe tu dato de tipo entero:");
        int myInt = sc.nextInt();
        System.out.println("Escribe tu dato de tipo float:");
        float myFloat = sc.nextFloat();
        System.out.println("Escribe tu dato de tipo double:");
        double myDouble = sc.nextDouble();
        System.out.println("Escribe tu dato de tipo boolean:");
        boolean myBoolean = sc.nextBoolean();
        System.out.println("Escribe tu dato de tipo char:");
        char myChar = sc.next().charAt(0);
        sc.nextLine();
        System.out.println("Escribe tu dato de tipo String:");
        String myString = sc.nextLine();
        sc.close();

        System.out.println("Dato de tipo byte: " + myByte);
        System.out.println("Dato de tipo entero: " + myInt);
        System.out.println("Dato de tipo float: " + myFloat);
        System.out.println("Dato de tipo double: " + myDouble);
        System.out.println("Dato de tipo boolean: " + myBoolean);
        System.out.println("Dato de tipo char: " + myChar);
        System.out.println("Dato de tipo String: " + myString);
    }

}
