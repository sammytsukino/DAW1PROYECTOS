public class IMC {

    static double peso= 70;
    static double altura= 1.75;

    public static void main(String[] args) {
        double IMC = peso / Math.pow(altura, 2);

        System.out.println("La persona tiene un peso de " + peso + " kg y una altura de " + altura + " m");
        if (IMC < 16) { 
            System.out.println("La persona tiene delgadez severa");
        } else if (IMC < 17) {
            System.out.println("La persona tiene delgadez moderada");
        } else if (IMC < 18){
            System.out.println("La persona tiene delgadez leve");
        } else if (IMC < 25){
            System.out.println("La persona tiene un peso normal");
        } else if (IMC < 30){
            System.out.println("La persona tiene sobrepeso");
        } else if (IMC < 35){
            System.out.println("La persona tiene obesidad tipo 1");
        } else if (IMC < 40){
            System.out.println("La persona tiene obesidad tipo 2");
        } else {
            System.out.println("La persona tiene obesidad tipo 3");
        }
    }
}
