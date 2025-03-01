public class DivisibleByThree {
    public static void main(String[] args) {
        divisibleByThree(5,27);
    }

    public static void divisibleByThree(int beginning, int end) {
        for (int i = beginning; i <= end; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            } else { System.out.print("");
        }
        }
    }
}
