import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class XMLSAX {
    public static void main(String[] args) {
        try {
            // Crear una instancia de SAXParserFactory y un SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Crear un nuevo documento XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            // Crear el elemento raíz del nuevo documento XML
            Element rootElement = doc.createElement("analisis_eventos");
            doc.appendChild(rootElement);

            // Definir el manejador SAX
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Si el elemento es "evento", procesar sus atributos
                    if (qName.equalsIgnoreCase("evento")) {
                        String id = attributes.getValue("id");
                        String nombre = attributes.getValue("nombre");

                        // Imprimir los atributos en la consola
                        System.out.println("Nombre: " + nombre);
                        System.out.println("ID: " + id);
                        System.out.println("---- Fin del evento ----");

                        // Crear un nuevo elemento en el XML de salida
                        Element evento = doc.createElement("evento");
                        evento.setAttribute("id", id);
                        evento.setAttribute("nombre", nombre);
                        rootElement.appendChild(evento);
                    }
                }
            };

            // Especificar el archivo XML de entrada y parsearlo
            File inputFile = new File("marcadores.xml");
            saxParser.parse(inputFile, handler);

            // Guardar el XML generado en un archivo
            guardarXML(doc, "analisis_marcadores_sax.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para guardar el documento XML en un archivo
    private static void guardarXML(Document doc, String fileName) {
        try {
            // Crear una instancia de TransformerFactory y un Transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // Establecer la propiedad de salida para que el XML esté indentado
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // Crear la fuente y el resultado de la transformación
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));
            // Transformar el documento y guardarlo en el archivo
            transformer.transform(source, result);
            System.out.println("Archivo XML generado: " + fileName);

            //Se maneja la excepcion al escribir el XML
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}