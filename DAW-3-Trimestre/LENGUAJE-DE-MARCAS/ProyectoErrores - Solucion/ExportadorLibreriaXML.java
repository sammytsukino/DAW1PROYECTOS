package "libreria";

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class ExportadorLibreriaXML {

    public static void exportar() {
        String url = "jdbc:mariadb://localhost:3306/libreria";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("libreria");
            doc.appendChild(root);

            Element contenedorGeneros = doc.createElement("generos");
            root.appendChild(contenedorGeneros);
            exportarTabla(doc, conn, contenedorGeneros, "genero", new String[]{"id_genero", "nombre_genero"});

            Element contenedorAutores = doc.createElement("autores");
            root.appendChild(contenedorAutores);
            exportarTabla(doc, conn, contenedorAutores, "autor", new String[]{"id_autor", "nombre_autor", "nacionalidad"});

            Element contenedorLibros = doc.createElement("libros");
            root.appendChild(contenedorLibros);
            exportarTabla(doc, conn, contenedorLibros, "libro", new String[]{"id_libro", "titulo", "anio_publicacion", "id_autor", "id_genero"});

            Element contenedorPrestamos = doc.createElement("prestamos");
            root.appendChild(contenedorPrestamos);
            exportarTabla(doc, conn, contenedorPrestamos, "prestamo", new String[]{"id_libro", "fecha_prestamo", "devuelto"});

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS, "true false");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("resources/exportado_libreria.xml"));
            transformer.transform(source, result);

            System.out.println("Exportación completada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exportarTabla(Document doc, Connection conn, Element contenedor, String tabla, String[] campos) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabla);

        while (rs.next()) {
            Element item = doc.createElement(tabla);
            for (String campo : campos) {
                Element nodo = doc.createElement(campo);
                String valor = rs.getString(campo);
                if ("devuelto".equals(campo)) {
                    valor = "1".equals(valor) ? "true" : "false";
                }
                nodo.appendChild(doc.createTextNode(valor));
                item.appendChild(nodo);
            }
            contenedor.appendChild(item);
        }
    }

    public static void main(String[] args) {
        exportar();
    }
}
