package forma;

public class Cuadrilatero_Interf implements Forma_Interf{
		private double tamanyo, anchura;
		
		public Cuadrilatero_Interf(double tamanyo,double anchura) {
			this.tamanyo=tamanyo;
			this.anchura=anchura;
		}
		
		public double area_Interf() {
			return (tamanyo*anchura);
		}
		
		public double perimetro_Interf() {
			return ((2*tamanyo)+(2*anchura));
		}
		public double volumen_Interf() {
			return 0;
		}
		
		//Declaración de nuevos métodos
}
