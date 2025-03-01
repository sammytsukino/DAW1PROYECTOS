public class S04Ejercicio03 {
    public static void main(String[] args) {        
        String dia = null;
        System.out.println("Introduce un número: ");
        int n = Integer.parseInt(System.console().readLine());


        switch (n) {
            case 1:
            dia = "lunes";
            break;

            case 2:
            dia = "martes";
            break;

            case 3:
            dia = "miércoles";
            break;

            default:
                break;
        }

        System.out.println("hoy es " + dia);

    }

}