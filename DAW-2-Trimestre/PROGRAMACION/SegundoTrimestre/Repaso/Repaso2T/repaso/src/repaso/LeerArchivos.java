package repaso;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivos {

	public static void main(String[] args) {
		FileReader fr = null;
		int valor = 0; // aquí guardaremos el valor para mostrar por pantalla

		try {
			fr = new FileReader(
					"C:\\Users\\DAW-1\\Desktop\\DAW1PROYECTOS\\DAW-2-Trimestre\\PROGRAMACION\\SegundoTrimestre\\Repaso\\Repaso2T\\repaso\\archivo.txt");
			// leemos el archivo
			valor = fr.read();
			// mientras el valor sea diferente de -1 que siga leyendo
			while (valor != -1) {
				System.out.println((char) valor); // hacemos la conversión a char para leer
				valor = fr.read(); // actualizamos el valor

			}
			fr.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				fr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
