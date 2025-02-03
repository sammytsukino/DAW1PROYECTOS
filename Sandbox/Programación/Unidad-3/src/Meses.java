public class Meses {

    static int mes = 16;
    static String estacion;

public static void main(String[] args) {
        switch(mes) {
            case 1:
            case 2:
            case 12:
            estacion = "Invierno";
            break;
            case 6:
            case 7:
            case 8:
            estacion = "Verano";
            break;
            case 3:
            case 4:
            case 5:
            estacion = "Primavera";
            break;
            case 9:
            case 10:
            case 11:
            estacion = "Otoño";
            break;
            default: 
            estacion= "Estación inválida";
        }
        System.out.println("El mes " + mes + " corresponde a la estación " + estacion);
    }

}
