public class CustomString {

    public static void main(String[] args) {
    String cadenaNueva = " Programación Orientada a Objetos en Java ";
    int tamano = cadenaNueva.length();
    System.out.println("La cadena tiene " + tamano + " caracteres");
    //Elimina espacios en blanco al comienzo y al final de la cadena
    String cadenaSinEspacios = cadenaNueva.trim();
    System.out.println("La cadena sin espacios al inicio y al final es: " + cadenaSinEspacios);
    //Convierte los caracteres a mayúsculas
    String cadenaMayuscula = cadenaNueva.toUpperCase();
    System.out.println("La cadena en mayúscula es" + cadenaMayuscula);
    //Concatenar cadenas
    String cadenaConcatenada = cadenaNueva.concat("en 2025");
    System.out.println("La cadena concatenada es: " + cadenaConcatenada);
    //Extraer porción de la cadena
    String cadenaExtraida = cadenaConcatenada.substring(cadenaNueva.length()-1,cadenaConcatenada.length());
    System.out.println("¿Cuándo estamos haciendo este ejercicio?" + cadenaExtraida);
    //Reemplazar caracteres
    String cadenaReemplazada = cadenaNueva.replace("Java", "Python");
    System.out.println("La cadena reemplazada es: " + cadenaReemplazada);
    //Comparar con equals
    boolean iguales = cadenaReemplazada.equals("2026");
    System.out.println("¿La cadena es igual a 2026? " + iguales);
    
    }
}


