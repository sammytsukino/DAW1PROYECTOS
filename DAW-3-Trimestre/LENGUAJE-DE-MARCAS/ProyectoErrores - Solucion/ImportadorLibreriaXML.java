package libreria;

import java.io.File;
import java.sql.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class ImportadorLibreriaXML {

	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3306/libreria";
		String user = "root";
		String password = "";

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			File file = new File("resources/libreria.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			insertarGeneros(doc, conn);
			insertarAutores(doc, conn);
			insertarLibros(doc, conn);
			insertarPrestamos(doc, conn);

			System.out.println("Datos insertados correctamente desde libreria.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void insertarGeneros(Document doc, Connection conn) throws SQLException {
		NodeList lista = doc.getElementsByTagName("genero");
		String sql = "INSERT INTO genero (id_genero, nombre_genero) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int i = 0; i < lista.getLength(); i++) {
			Element e = (Element) lista.item(i);
			ps.setInt(1, Integer.parseInt(e.getElementsByTagName("id_genero").item(0).getTextContent()));
			ps.setString(2, e.getElementsByTagName("nombre_genero").item(0).getTextContent());
			ps.executeUpdate();
		}
	}

	private static void insertarAutores(Document doc, Connection conn) throws SQLException {
		NodeList lista = doc.getElementsByTagName("autor");
		String sql = "INSERT INTO autor (id_autor, nombre_autor, nacionalidad) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int i = 0; i < lista.getLength(); i++) {
			Element e = (Element) lista.item(i);
			ps.setInt(1, Integer.parseInt(e.getElementsByTagName("id_autor").item(0).getTextContent()));
			ps.setString(2, e.getElementsByTagName("nombre_autor").item(0).getTextContent());
			ps.setString(3, e.getElementsByTagName("nacionalidad").item(0).getTextContent());
			ps.executeUpdate();
		}
	}

	private static void insertarLibros(Document doc, Connection conn) throws SQLException {
		NodeList lista = doc.getElementsByTagName("libro");
		String sql = "INSERT INTO libro (id_libro, titulo, anio_publicacion, id_autor, id_genero) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int i = 0; i < lista.getLength(); i++) {
			Element e = (Element) lista.item(i);
			ps.setInt(1, Integer.parseInt(e.getElementsByTagName("id_libro").item(0).getTextContent()));
			ps.setString(2, e.getElementsByTagName("titulo").item(0).getTextContent());
			ps.setInt(3, Integer.parseInt(e.getElementsByTagName("anio_publicacion").item(0).getTextContent()));
			ps.setInt(4, Integer.parseInt(e.getElementsByTagName("id_autor").item(0).getTextContent()));
			ps.setInt(5, Integer.parseInt(e.getElementsByTagName("id_genero").item(0).getTextContent()));
			ps.executeUpdate();
		}
	}

	private static void insertarPrestamos(Document doc, Connection conn) throws SQLException {
		NodeList lista = doc.getElementsByTagName("prestamo");
		String sql = "INSERT INTO prestamo (id_libro, fecha_prestamo, devuelto) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int i = 0; i < lista.getLength(); i++) {
			Element e = (Element) lista.item(i);
			ps.setInt(1, Integer.parseInt(e.getElementsByTagName("id_libro").item(0).getTextContent()));
			ps.setDate(2, Date.valueOf(e.getElementsByTagName("fecha_prestamo").item(0).getTextContent()));
			ps.setBoolean(3, Boolean.parseBoolean(e.getElementsByTagName("devuelto").item(0).getTextContent()));
			ps.executeUpdate();
		}
	}
}
