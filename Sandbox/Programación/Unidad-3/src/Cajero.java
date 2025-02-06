// Vamos a hacer un cajero automático usando do-while, un scanner para recoger lo que se pide y un switch para las menues. Las menues son las siguientes: Consultar saldo, retirar saldo y depositar dinero. Al principio la cuenta tiene un saldo de 1000 euros. Si se retira más dinero del que hay en la cuenta, se mostrará un mensaje de error. Si se deposita dinero, se sumará al saldo de la cuenta. Si se consulta el saldo, se mostrará el saldo actual. El programa terminará cuando se introduzca la opción de salir.

public class Cajero {
    public static void main(String[] args) {
        java.util.Scanner entrada = new java.util.Scanner(System.in);
        double saldo = 1000;
        int menu;
        do { 
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar saldo");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Introduce una opción: ");
            menu = entrada.nextInt();
            switch (menu) {
            case 1:
                System.out.println("El saldo actual es de " + saldo + " euros");
                break;
            case 2:
                System.out.print("Introduce la cantidad a retirar: ");
                int retirar = entrada.nextInt();
                if (retirar > saldo) {
                    System.out.println("No tienes suficiente saldo.");
                } else {
                    saldo -= retirar;
                    System.out.println("Has retirado " + retirar + " euros." + " Tu saldo actual es de " + saldo + " euros.");
                }
                break;
            case 3:
                System.out.println("Introduce la cantidad a depositar:");
                int depositar = entrada.nextInt();
                saldo += depositar;
                System.out.println("Has depositado " + depositar + " euros." + " Tu saldo actual es de " + saldo + " euros.");
            case 4: 
                System.out.println("Gracias por usar el cajero.");
                break;
            }
        } while (menu != 4);
        entrada.close();
    }
}
