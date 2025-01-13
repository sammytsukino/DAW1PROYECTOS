public class Grading {       
public static void main(String[] args) {
    int nota = 8;
    String calificacion;

    switch (nota) {
        case 1: calificacion = "Muy deficiente";
        break;
        case 2: calificacion = "Deficiente";
        break;
        case 3: calificacion = "Insuficiente";
        break;
        case 4: calificacion = "Insuficiente";
        break;
        case 5: calificacion = "Suficiente";
        break;
        case 6: calificacion = "Bien";
        break;
        case 7: calificacion = "Notable";
        break;
        case 8: calificacion = "Notable";
        break;
        case 9: calificacion = "Sobresaliente";
        break;
        case 10: calificacion = "Sobresaliente";
        break;
        default: calificacion = "Nota inválida";
        

    }
    System.out.println("La nota " + nota + " corresponde a " + calificacion);

}

}