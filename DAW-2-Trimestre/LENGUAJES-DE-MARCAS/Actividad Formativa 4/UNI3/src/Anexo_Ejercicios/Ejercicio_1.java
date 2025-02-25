package Anexo_Ejercicios;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Ejercicio_1 {

	public static void main(String[] args) {
	
		        try {
		            // Crear instancia de DocumentBuilderFactory
		            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		            DocumentBuilder builder = factory.newDocumentBuilder();

		            // Crear un documento XML vacío
		            Document doc = builder.newDocument();

		            // Crear el elemento raíz <libros>
		            Element root = doc.createElement("libros");
		            doc.appendChild(root);

		            // Crear el primer libro <libro>
		            Element libro1 = doc.createElement("libro");
		            root.appendChild(libro1);

		            // Agregar los detalles del libro 1
		            Element titulo1 = doc.createElement("titulo");
		            titulo1.appendChild(doc.createTextNode("El Quijote"));
		            libro1.appendChild(titulo1);

		            Element autor1 = doc.createElement("autor");
		            autor1.appendChild(doc.createTextNode("Miguel de Cervantes"));
		            libro1.appendChild(autor1);

		            Element anio1 = doc.createElement("anio");
		            anio1.appendChild(doc.createTextNode("1605"));
		            libro1.appendChild(anio1);

		            // Crear el segundo libro <libro>
		            Element libro2 = doc.createElement("libro");
		            root.appendChild(libro2);

		            // Agregar los detalles del libro 2
		            Element titulo2 = doc.createElement("titulo");
		            titulo2.appendChild(doc.createTextNode("La Odisea"));
		            libro2.appendChild(titulo2);

		            Element autor2 = doc.createElement("autor");
		            autor2.appendChild(doc.createTextNode("Homero"));
		            libro2.appendChild(autor2);

		            Element anio2 = doc.createElement("anio");
		            anio2.appendChild(doc.createTextNode("800 a.C."));
		            libro2.appendChild(anio2);

		            // Guardar el archivo XML
		            guardarXML(doc, "catalogo_libros.xml");
		            System.out.println("Archivo XML creado: catalogo_libros.xml");
		            
		         // Modificar el título de un libro
		            NodeList libros = doc.getElementsByTagName("libro");
		            Element libroModificar = (Element) libros.item(1); // Modifica el segundo libro (La Odisea)
		            libroModificar.getElementsByTagName("titulo").item(0).setTextContent("La Ilíada");
		            System.out.println("Título modificado.");

		            // Eliminar el primer libro
		            //Element libroEliminar = (Element) libros.item(0);
		            //root.removeChild(libroEliminar);
		            //System.out.println("Primer libro eliminado.");

		            // Guardar los cambios en el archivo XML
		            guardarXML(doc, "libros_modificado.xml");
		            System.out.println("Archivo XML modificado guardado: libros_modificado.xml");
		            
		            

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }


		    // Método para guardar el XML en un archivo
		    public static void guardarXML(Document doc, String archivo) throws TransformerException {
		        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        Transformer transformer = transformerFactory.newTransformer();
		        DOMSource source = new DOMSource(doc);
		        StreamResult result = new StreamResult(new File(archivo));
		        //https://docs.oracle.com/javase/8/docs/api/javax/xml/transform/OutputKeys.html
		        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		        transformer.transform(source, result);
		    }
		

}
