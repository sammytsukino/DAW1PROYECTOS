public class PalabraInvertida {

    public static void main(String[] args) {
        String palabra = "guatemala";
        String palabraInvertida = "";
        for (int i = palabra.length() - 1; i >= 0; i--) {  
            palabraInvertida += palabra.charAt(i);
        }
        System.out.println(palabraInvertida);
    }
}
