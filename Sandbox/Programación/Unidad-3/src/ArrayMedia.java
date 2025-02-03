public class ArrayMedia {

    public static void main(String[] args) {
        
    int [] array = new int[350];
    float suma = 0;
    
    for(int i = 0; i < array.length; i++) { 
        array[i] = i+1;            
        suma += array[i];            
    }

    System.out.println("La suma de los valores del array es: " + suma);
    System.out.println("La media de los valores del array es: " + suma / array.length);

}

}

