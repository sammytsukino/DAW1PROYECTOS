package repasoTryCatch;

public class RepasoTryCatch {
	public static void main(String[] args) {
		
	
	try {
		int n = Integer.parseInt("V");
		System.out.println("Hola");
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Esto se ejecuta cuando hay error");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		
	} finally {
		
		System.out.println("Esto se ejecuta siempre");
	}

}
}
