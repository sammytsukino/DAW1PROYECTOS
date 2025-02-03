public class ArrayRecorridoMiguel {

    public static void main (String[] args) {
		int[] array=new int[50];
		int[] arrayReves=new int[array.length];
		int j=0;
		for (int i=array.length-1;i>=0;i--) {
			array[i]=i+1;
			arrayReves[j]=array[i];
			System.out.println(arrayReves[j]);
			j++;
		}
		for (int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
	}
}
