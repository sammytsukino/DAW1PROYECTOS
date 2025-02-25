package Anexo_Ejercicios;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Ejercicio_2 {

	public static void main(String[] args) {
		try {
            // Crear instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Crear un documento XML vacío
            Document doc = builder.newDocument();

            // Crear el elemento raíz <vampiros>
            Element root = doc.createElement("vampiros");
            doc.appendChild(root);

            // Crear el primer vampiro <vampiro> con atributos
            Element vampiro1 = doc.createElement("vampiro");
            vampiro1.setAttribute("nombre", "Drácula");
            vampiro1.setAttribute("lugar", "Transilvania");
            vampiro1.setAttribute("anio", "1897");
            root.appendChild(vampiro1);

            // Crear el segundo vampiro <vampiro> con atributos
            Element vampiro2 = doc.createElement("vampiro");
            vampiro2.setAttribute("nombre", "Nosferatu");
            vampiro2.setAttribute("lugar", "Alemania");
            vampiro2.setAttribute("anio", "1922");
            root.appendChild(vampiro2);
            
            Element vampiro3 = doc.createElement("vampiro");
            vampiro3.setAttribute("nombre", "Grindel");
            vampiro3.setAttribute("lugar", "Alemania");
            vampiro3.setAttribute("anio", "1932");
            root.appendChild(vampiro3);
            
            Element vampiro4 = doc.createElement("vampiro");
            vampiro4.setAttribute("nombre", "Mendel");
            vampiro4.setAttribute("lugar", "Finlandia");
            vampiro4.setAttribute("anio", "1902");
            root.appendChild(vampiro4);
            
            Element vampiro5 = doc.createElement("vampiro");
            vampiro5.setAttribute("nombre", "Humire");
            vampiro5.setAttribute("lugar", "Albania");
            vampiro5.setAttribute("anio", "1729");
            root.appendChild(vampiro5);

            // Guardar el archivo XML
            guardarXML(doc, "catalogo_vampiros.xml");
            System.out.println("Archivo XML creado: catalogo_vampiros.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		try {
            File xmlFile = new File("catalogo_vampiros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener elemento raíz
            Element rootElement = doc.getDocumentElement();

            // Obtener lista de elementos hijo
            NodeList nodeList = rootElement.getChildNodes();

            // Recorrer lista de elementos hijo
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                // Investigar esta línea de abajo
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Realizar operaciones CRUD
                    System.out.println("Nombre: " + element.getAttribute("nombre"));
                    System.out.println("Lugar: " + element.getAttribute("lugar"));
                    System.out.println("Año: " + element.getAttribute("anio"));

                    // Actualizar atributos
                    element.setAttribute("lugar", "Bulgaria");
                    element.setAttribute("anio", "1899");
                    //element.removeAttribute("lugar");
                    // Eliminar elemento
                    if (element.getAttribute("nombre").equals("Humire")) {
                        rootElement.removeChild(element);
                    }
                }
            }
            // Guardar el archivo XML
            guardarXML(doc, "catalogo_vampiros_modificado.xml");
                 System.out.println("Archivo XML actualizado correctamente.");

        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException | TransformerException e) {
            e.printStackTrace();
        }
            
    }

    // Método para guardar el XML en un archivo
    public static void guardarXML(Document doc, String archivo) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(archivo));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
    }

}
