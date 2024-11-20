package forma;

public class PruebaForma_Interf {
	public static void main(String[] args) {
		Forma_Interf rectangulo_Interf=new Cuadrilatero_Interf(10,30);
		System.out.println("El Area del rectangulo es "+rectangulo_Interf.area_Interf());
		System.out.println("El Perimetro del rectangulo es "+rectangulo_Interf.perimetro_Interf());	
		System.out.println("El Volumen del rectangulo es "+rectangulo_Interf.volumen_Interf());
	}
	
}
