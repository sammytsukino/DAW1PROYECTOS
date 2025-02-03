public class Dias {
public static void main(String[] args) {
    int dia = 16;
    String diaSemana;
    switch (dia) {
        case 1: diaSemana = "Lunes";
        break;
        case 2: diaSemana = "Martes";
        break;
        case 3: diaSemana = "Miércoles";
        break;
        case 4: diaSemana = "Jueves";
        break;
        case 5: diaSemana = "Viernes";
        break;
        case 6: diaSemana = "Sábado";
        break;
        case 7: diaSemana = "Domingo";
        break;
        default: diaSemana = "Día inválido";
        

    }
    System.out.println("El día " + dia + " corresponde a " + diaSemana);
}
}
