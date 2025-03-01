public class PedirPorTeclado {

    public static void main(String[] args) {
        int[] teclado = new int[10];

        System.out.println("Por favor, introduzca 10 números enteros.");
        System.out.println("Pulse la tecla INTRO después de introducir cada número.");

        for (int i = 0; i < teclado.length; i ++) {
            teclado[i] = Integer.parseInt(System.console().readLine());
        }

        for (int i = teclado.length-1; i >= 0; i--){
            System.out.println(teclado[i]);
        }

    }

}
