package repaso;

import javax.swing.JOptionPane;

public class OptionDialog {

	public static void main(String[] args) {

		int opcion = JOptionPane.showOptionDialog(null, "Elige una opción", "Opciones disponibles", 0, 1, null,
				new Object[] { "Rosa", "Azul", "Verde", "Amarillo" }, "Rosa");

		if (opcion == 0) {
			System.out.println("Has elegido la opción 1");
		} else if (opcion == 1) {
			System.out.println("Has elegido opción 2");
		} else if (opcion == 2) {
			System.out.println("Has elegido opción 3");
		} else if (opcion == 3) {
			System.out.println("Has elegido opción 4");
		}

	}

}
