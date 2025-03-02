package entradasT;

import javax.swing.JOptionPane;

public class Calculadora {
	public static void main (String [] args) {
		while (true) {
		String [] options= {"Sumar","Restar","Multiplicar","Dividir","Salir"};
		int opcion=JOptionPane.showOptionDialog(null, "Seleccione una operación", "Calculadora", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		
		if (opcion==4) {
			break;
		}
		
		String entrada1 =JOptionPane.showInputDialog("Ingrese el primer número:");
		String entrada2 =JOptionPane.showInputDialog("Ingrese el segundo número:");
		
		try {
			double num1 = Double.parseDouble(entrada1);
			double num2 = Double.parseDouble(entrada2);
			double result=0;
			switch (opcion) {
			case 0:
				result=num1+num2;
				break;
			case 1:
				result=num1-num2;
				break;
			case 2:
				result=num1*num2;
				break;
			case 3:
				if (num2!=0) {
					result=num1/num2;
			}else {
				JOptionPane.showMessageDialog(null, "Error: No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
				continue;
			}
				break;
		}
			JOptionPane.showMessageDialog(null, "El resultado es: "+result);
	}catch (NumberFormatException e) {
		JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	}
	}
}
