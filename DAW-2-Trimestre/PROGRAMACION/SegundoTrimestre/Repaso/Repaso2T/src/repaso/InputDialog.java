package repaso;

import javax.swing.JOptionPane;

public class InputDialog {

	public static void main(String[] args) {
		//leer un texto con JOptionpane
		String variable = "";
		variable = JOptionPane.showInputDialog(null, "Introduce un texto", "Lector", 1);
		System.out.println(variable);
		
		//leer un numero con JOptionPane
		String numeroTexto = JOptionPane.showInputDialog("Introduce un número");
		int numero = Integer.parseInt(numeroTexto);
		System.out.println(numero);
		
		int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
		System.out.println(numero2);

	}

}
