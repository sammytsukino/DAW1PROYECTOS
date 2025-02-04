import java.util.*;;

public class NumeroVocales {
    public static void main(String[] args) {
        int contador = 0;
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        Scanner sc = new Scanner(System.in);
        String cadena = sc.next();
        for (int i = 0; i < cadena.length(); i++) {  
            for (int j = 0; j < vocales.length; j++) {
                if (cadena.charAt(i) == vocales[j]) {
                    contador++;
                }
            }
       }
       sc.close();
       System.out.println("La cantidad de vocales en esta palabra es: " + contador);
    }
}