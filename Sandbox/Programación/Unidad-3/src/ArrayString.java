public class ArrayString {
    public static void main(String[] args) {
        String[] array = new String[4];
        array[0]= "Harry Potter";
        array[1]= "El alquimista";
        array[2]= "La celestina";
        array[3]= "Narnia";

        //-----------------------------//
        
        String[] arrayReves = new String[array.length];
        int j = 0;
        for (int i=array.length-1;i>=0;i--){
            arrayReves[j]=array[i];
            System.out.println(arrayReves[j]);
            j++;
        }
        for (int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
