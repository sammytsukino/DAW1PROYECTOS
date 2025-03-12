package actividadEvaluable;

/* 
 * Importaciones necesarias:
 * - Clases para manejo de archivos y entrada/salida
 * - ArrayList para almacenar los contactos
 * - JOptionPane para la interfaz gráfica
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/* 
 * Clase principal que implementa una agenda de contactos
 * con interfaz gráfica y persistencia en archivo de texto
 */
public class Contactos {

	/*
	 * ArrayList estático para almacenar los contactos Se usa como estructura de
	 * datos principal (requisito 1)
	 */
	private static ArrayList<String> listaContactos = new ArrayList<>();

	/*
	 * Método principal que inicia el programa, muestra el menú y maneja la
	 * selección de opciones del usuario
	 */
	public static void main(String[] args) {
		/* Carga los contactos desde el archivo al iniciar */
		cargarContactos();

		/* Define las opciones del menú principal */
		String[] opciones = { "Añadir Contacto", "Listar Contactos", "Buscar Contacto", "Salir" };

		/*
		 * Bucle principal del programa que muestra el menú hasta que el usuario salga
		 */
		while (true) {
			/* Muestra el menú de opciones usando JOptionPane */
			int opcion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Gestión de Contactos",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

			/* Si el usuario cierra la ventana (X), guarda contactos y sale */
			if (opcion == -1) {
				guardarContactos();
				break;
			}

			/* Ejecuta la acción correspondiente a la opción seleccionada */
			switch (opcion) {
			case 0:
				añadirContacto();
				break;
			case 1:
				listarContactos();
				break;
			case 2:
				buscarContacto();
				break;
			case 3: /* Opción "Salir" */
				guardarContactos();
				JOptionPane.showMessageDialog(null, "Saliendo del programa...");
				return;
			}
		}
	}

	/*
	 * Método que carga los contactos desde el archivo de texto al ArrayList al
	 * iniciar el programa
	 */
	private static void cargarContactos() {
		/* Crea un objeto File para el archivo de contactos */
		File archivo = new File("contactos.txt");

		/* Verifica si el archivo existe y lo crea si no existe */
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al crear el archivo de contactos: " + e.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			return;
		}

		/*
		 * Lee el archivo línea por línea usando BufferedReader y añade cada línea al
		 * ArrayList de contactos
		 */
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				listaContactos.add(linea);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar los contactos: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * Método que guarda todos los contactos del ArrayList en el archivo de texto
	 * antes de salir
	 */
	private static void guardarContactos() {
		/*
		 * Escribe cada contacto en una línea del archivo usando BufferedWriter para
		 * mejor rendimiento
		 */
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("contactos.txt"))) {
			for (String contacto : listaContactos) {
				bw.write(contacto);
				bw.newLine();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al guardar los contactos: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * Método que solicita datos al usuario y añade un nuevo contacto a la lista
	 */
	private static void añadirContacto() {
		/* Solicita el nombre del contacto */
		String nombre = JOptionPane.showInputDialog("Introduce el nombre del contacto:");
		/* Si cancela o deja vacío, sale sin hacer nada */
		if (nombre == null || nombre.trim().isEmpty()) {
			return;
		}

		/* Solicita el teléfono del contacto */
		String telefono = JOptionPane.showInputDialog("Introduce el teléfono para " + nombre + ":");
		/* Si cancela, sale sin hacer nada */
		if (telefono == null) {
			return;
		}

		/* Formatea y añade el contacto a la lista */
		String contacto = "Nombre: " + nombre + ", Teléfono: " + telefono;
		listaContactos.add(contacto);

		/* Confirma al usuario que se añadió correctamente */
		JOptionPane.showMessageDialog(null, "Contacto añadido correctamente");
	}

	/*
	 * Método que muestra todos los contactos almacenados en la lista
	 */
	private static void listarContactos() {
		/* Verifica si hay contactos para mostrar */
		if (listaContactos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay contactos guardados");
			return;
		}

		/* Construye la lista de contactos para mostrar */
		StringBuilder sb = new StringBuilder("Lista de contactos:\n\n");
		for (String contacto : listaContactos) {
			sb.append(contacto).append("\n");
		}

		/* Muestra todos los contactos en un diálogo */
		JOptionPane.showMessageDialog(null, sb.toString());
	}

	/*
	 * Método que busca contactos por nombre y muestra los resultados que coinciden
	 */
	private static void buscarContacto() {
		/* Solicita el término de búsqueda */
		String nombreBuscado = JOptionPane.showInputDialog("Introduce el nombre a buscar:");
		/* Si cancela o deja vacío, sale sin hacer nada */
		if (nombreBuscado == null || nombreBuscado.trim().isEmpty()) {
			return;
		}

		/* Lista para almacenar los contactos encontrados */
		ArrayList<String> contactosEncontrados = new ArrayList<>();

		/*
		 * Busca coincidencias en cada contacto ignorando mayúsculas/minúsculas
		 */
		for (String contacto : listaContactos) {
			if (contacto.toLowerCase().contains(nombreBuscado.toLowerCase())) {
				contactosEncontrados.add(contacto);
			}
		}

		/* Muestra los resultados encontrados o un mensaje si no hay coincidencias */
		if (contactosEncontrados.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se encontraron contactos con el nombre '" + nombreBuscado + "'");
		} else {
			StringBuilder sb = new StringBuilder("Contactos encontrados:\n\n");
			for (String contacto : contactosEncontrados) {
				sb.append(contacto).append("\n");
			}
			JOptionPane.showMessageDialog(null, sb.toString());
		}
	}
}