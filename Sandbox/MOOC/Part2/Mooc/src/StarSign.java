public class StarSign {

    public static void printStars(int number) {
        for (int i =0; i < number; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void printSquare(int size) {
      int counter = 0;
      while (counter < size) {
        printStars(size);
        counter++;
      }

    }

    public static void printRectangle(int width, int height) {
        int counter = 0;
        while (counter < height) {
            printStars(width);
            counter++;
        }
    }

    public static void printTriangle (int size) {
        int counter = 1;
        while (counter <= size) {
            printStars(counter);
            counter++;

        }
    }
    
    public static void main(String[] args) {
        printStars(5);
        System.out.println("");
        printSquare(4);
        System.out.println("");
        printRectangle(10, 5);
        System.out.println("");
        printTriangle(5);


    }


}
