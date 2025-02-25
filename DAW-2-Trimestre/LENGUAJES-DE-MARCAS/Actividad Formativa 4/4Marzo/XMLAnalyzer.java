import org.w3c.dom.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class XMLAnalyzer {
    public static void main(String[] args) {
        // Analizar el XML utilizando DOM
        analyzeWithDOM();
        
        // Analizar el XML utilizando SAX
        analyzeWithSAX();
    }

    public static void analyzeWithDOM() {
        try {
            // Cargar el archivo XML de entrada
            File inputFile = new File("marcadores.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            // Se normaliza el documento para asegurar una estructura consistente.
            doc.getDocumentElement().normalize();
            
            // Mostrar el elemento raíz del XML
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            
            // Obtener todos los nodos llamados "evento"
            NodeList nodeList = doc.getElementsByTagName("evento");
            
            // Crear un nuevo archivo XML para almacenar el análisis
            FileWriter writer = new FileWriter("analisis_dom.xml");
            writer.write("<analisis>\n");
            
            // Recorrer todos los nodos "evento"
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // Obtener los atributos "id" y "nombre" de cada evento
                    String id = element.getAttribute("id");
                    String nombre = element.getAttribute("nombre");
                    
                    // Mostrar la información en consola
                    System.out.println("Evento ID: " + id + ", Nombre: " + nombre);
                    
                    // Escribir la información en el archivo XML de salida
                    writer.write("  <evento id=\"" + id + "\" nombre=\"" + nombre + "\"/>\n");
                }
            }
            writer.write("</analisis>"); // Cerrar la etiqueta raíz en el archivo de salida
            writer.close(); // Cerrar el escritor de archivos
            
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // Manejo de excepciones en caso de error en el análisis
            System.out.println("Error procesando el XML con DOM: " + e.getMessage());
        }
    }

    public static void analyzeWithSAX() {
        try {
            // Crear una fábrica de SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Definir un manejador para el análisis SAX
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Si el elemento es "evento", extraer sus atributos
                    if (qName.equalsIgnoreCase("evento")) {
                        String id = attributes.getValue("id"); // Obtener el atributo "id"
                        String nombre = attributes.getValue("nombre"); // Obtener el atributo "nombre"
                        
                        // Mostrar la información en consola
                        System.out.println("Evento ID: " + id + ", Nombre: " + nombre);
                    }
                }
            };

            // Procesar el archivo XML con el parser SAX
            saxParser.parse(new File("marcadores.xml"), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // Manejo de excepciones en caso de error en el análisis
            System.out.println("Error procesando el XML con SAX: " + e.getMessage());
        }
    }
}
