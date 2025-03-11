package repaso;

import javax.swing.JOptionPane;

public class ConfirmDialog {
	public static void main(String[] args) {
		int opcion = JOptionPane.showConfirmDialog(null, "Elige una opción", "Opciones", 1, 0);

		if (opcion == 0) {
			System.out.println("Has elegido la opción YES");

		} else if (opcion == 1) {
			System.out.println("Has elegido NO");

		} else if (opcion == 2) {
			System.out.println("Has elegido CANCEL");

		}

	}
}
