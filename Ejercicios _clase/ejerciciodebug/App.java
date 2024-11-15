import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        int[] numberList = {2, 8, 9, 6, 5};

        // Ejercicio 1. ¿Cuanto valdrá numberChoosen?
        // ¿Qué valor de i tendrá a[i]=9?
        for(int i = 0; i < numberList.length; ++i) {
           if (numberList[i] % 2 == 0) {
              int numberChoosen = numberList[i];
              System.out.println(numberChoosen);
           }
        }
        // Ejercicio 2. ¿Quien tiene dni 45678901E?
        // ¿Cómo cambiarias el código para tener el dni?
         List<Alumno> alumns = Utils.readAlumns("src/alumnos.txt");
         for(Alumno alumn: alumns){
            int age = alumn.getAge();
            if (age > 20) {
                String name = alumn.getName();
                String surname = alumn.getSurname();
                System.out.println("Es mayor de 20 " + name +" " + surname);
            }
         }
  
    }
}
