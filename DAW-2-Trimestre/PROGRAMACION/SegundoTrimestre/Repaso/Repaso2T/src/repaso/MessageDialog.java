package repaso;

import javax.swing.JOptionPane;

public class MessageDialog {
	public static void main(String[] args) {
		//pedimos datos por teclado
		String numeroTexto = JOptionPane.showInputDialog("Dame un texto: ");
		int numero = Integer.parseInt(numeroTexto);
		
		JOptionPane.showMessageDialog(null, numero);
		
		
	}

}
