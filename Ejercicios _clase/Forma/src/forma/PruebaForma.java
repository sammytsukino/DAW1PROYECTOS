package forma;

public class PruebaForma {
		public static void main(String[] args) {
			Forma rectangulo=new Cuadrilatero(4,5,"Rectangulo",true,false);
			System.out.println("El Area del Rectangulo es "+rectangulo.area());
			System.out.println("El Perimetro del Rectangulo es "+rectangulo.perimetro());
		}
}
