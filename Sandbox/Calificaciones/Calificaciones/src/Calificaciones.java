public class Calificaciones {
    static int calificacion = 5;
    static String resultado;

    public static void main(String[] args) {
        switch (calificacion) {
            case 1:
            case 2:
            case 3:
            case 4:
                resultado = "Insuficiente";
                break;
            case 5:
                resultado = "Aprobado";
                break;
            case 6:
                resultado = "Bien";
                break;
            case 7:
            case 8:
                resultado = "Notable";
                break;
            case 9:
            case 10:
                resultado = "Sobresaliente";
                break;
            default:
                resultado = "No evaluable";
        }
        
                System.out.println("Tu nota es: " + calificacion + ". Tu resultado es: " + resultado);

        }

    }
