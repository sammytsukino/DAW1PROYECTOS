public class Gugudan {

    public static void main(String[] args) {
        

        for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {

            for (int tabla = 1; tabla <= 10; tabla++) {

                System.out.print(tabla * multiplicador + "\t");
            }

            System.out.println();
        }
    }
}