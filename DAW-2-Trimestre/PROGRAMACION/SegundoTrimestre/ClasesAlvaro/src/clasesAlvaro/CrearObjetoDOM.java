package clasesAlvaro;

import java.io.File;

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
import org.w3c.dom.Text;


public class CrearObjetoDOM {
	
	public static void main(String[] args) {
		
		
		try {
			
			// CREO UN OBJETO DOC VACÍO
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			
			//OBJETO ELEMENT
			
			Element root = doc.createElement("educandos");
			doc.appendChild(root);
			
			Element educando1 = doc.createElement("educando");
			root.appendChild(educando1);
			
			Element nombre1 = doc.createElement("nombre");
			educando1.appendChild(nombre1);
			
			Text textoNombre = doc.createTextNode("Juanito");
			nombre1.appendChild(textoNombre);
			
			
			educando1.setAttribute("edad", "18");
			
			// GUARDAR XML
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			// SOURCE Y RESULTADO
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("educandos.xml"));
			
			// TRANSFORMAR
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
			
		
			
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
