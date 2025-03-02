package entradasT;
import javax.swing.JOptionPane;
public class MostrarIG {
	/* JOptionPane es una clase de java, del paquete javax.swing, 
	 * que nos permite generar cuadros de diálogo para interactuar con el usuario.
	 */
	public static void main(String[]args){
	        //https://docs.oracle.com/javase/8/docs/api/javax/swing/JOptionPane.html
	        String nombre="";
	        nombre=JOptionPane.showInputDialog("Escribe tu nombre");
	        int edad=0;
	        try{
	            edad=Integer.parseInt(JOptionPane.showInputDialog("Escribe tu edad"));
	            /*
	             *Byte.parseByte(String);
	             *Short.parseShort(String);
	             *Integer.parseInt(String);
	             *Long.parseLong(String);
	             *Float.parseFloat(String);
	             *Double.parseDouble(String);
	             *Boolean.parseBoolean(String);
	             */
	        }catch(NumberFormatException ex){
	        	//showMessageDialog(Component parentComponent, Object message)
		        //Este método crea una ventana que muestra un mensaje entregado en 
		        //el parámetro message. El parámetro parentComponent es para indicar la ventana padre. 
		        //usaremos null en este parámetro porque no tiene ventana padre.
	            JOptionPane.showMessageDialog(null, "No es una edad válida");
	        }
	         
	        String resultado="Nombre: "+nombre+"\nEdad: "+edad;
	        JOptionPane.showMessageDialog(null, resultado);
	    }
}
