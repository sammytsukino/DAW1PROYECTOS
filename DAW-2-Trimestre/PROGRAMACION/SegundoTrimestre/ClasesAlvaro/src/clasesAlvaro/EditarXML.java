package clasesAlvaro;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EditarXML {

	public static void main(String[] args) {
		
		//CARGAMOS ARCHIVO A EDITAR
		File xmlFile = new File("educandos.xml");
		
		// OBJETO DOCUMENT
				try {
					
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
		// CREAMOS EL DOCUMENT
			Document doc = builder.parse(xmlFile);
			
		// EDITAR: NODELIST
			
			Element ruta = doc.getDocumentElement();
			NodeList lista = ruta.getChildNodes();
			
			for (int i = 0; i< lista.getLength(); i++) {
				Node nodo = lista.item(i);
				
				if (nodo.getNodeType() == Node.ELEMENT_NODE ) {
					Element elemento = (Element) nodo;
					
					if (elemento.getAttribute("edad").equals("18")) {
						elemento.setAttribute("edad", "22");
						elemento.getElementsByTagName("nombre").item(0).setTextContent("Pepito");
					}
				}
			}
			
		//GUARDAR CON TRANSFORMER
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("educandos_editado.xml"));
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
			
			
			
		
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}