import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XMLDOM {

    public static void main(String[] args) {
        try {
            // Cargar el archivo XML de entrada
            File xmlFile = new File("marcadores.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            
            // Normalizar el documento para evitar inconsistencias
            doc.getDocumentElement().normalize();
            
            // Obtener el elemento raíz
            Element rootElement = doc.getDocumentElement();
            System.out.println("Elemento raíz: " + rootElement.getNodeName());
            
            // Obtener todos los nodos "evento"
            NodeList nodeList = doc.getElementsByTagName("evento");
            
            // Crear un nuevo documento XML para almacenar la salida
            Document newDoc = dBuilder.newDocument();
            Element rootOutput = newDoc.createElement("analisis");
            newDoc.appendChild(rootOutput);
            
            // Recorrer todos los nodos "evento"
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    
                    // Obtener los atributos "id" y "nombre"
                    String id = element.getAttribute("id");
                    String nombre = element.getAttribute("nombre");
                    String estado = element.getAttribute("estado");
                    
                    // Mostrar la información por consola
                    System.out.println("Evento ID: " + id + ", Nombre: " + nombre);
                    
                    // Crear un nuevo nodo en el documento de salida
                    Element eventoOutput = newDoc.createElement("evento");
                    eventoOutput.setAttribute("id", id);
                    eventoOutput.setAttribute("nombre", nombre);
                    eventoOutput.setAttribute("estado", estado);
                    rootOutput.appendChild(eventoOutput);
                }
            }
            
            // Guardar el nuevo archivo XML con la salida del análisis
            guardarXML(newDoc, "analisis_dom.xml");
            System.out.println("Archivo XML de análisis generado correctamente: analisis_dom.xml");
            
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException | TransformerException e) {
            // Manejo de excepciones en caso de error durante el procesamiento
            System.out.println("Error procesando el XML con DOM: " + e.getMessage());
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
