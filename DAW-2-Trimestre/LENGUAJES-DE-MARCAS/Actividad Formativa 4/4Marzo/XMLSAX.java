import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class XMLSAX {

    public static void main(String[] args) {
        try {
            // Crear una fábrica SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Crear un manejador (handler) para procesar el XML
            DefaultHandler handler = new DefaultHandler() {

                boolean esEvento = false;
                boolean esID = false;

                // Método que se ejecuta cuando se encuentra una etiqueta de apertura
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("evento")) {
                        esEvento = true;
                    } else if (qName.equalsIgnoreCase("id")) {
                        esID = true;
                    }
                }

                // Método que se ejecuta cuando se encuentra el contenido entre etiquetas
                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (esEvento) {
                        System.out.println("Título: " + new String(ch, start, length));
                        esEvento = false;
                    }
                    if (esID) {
                        System.out.println("Autor: " + new String(ch, start, length));
                        esID = false;

                    }
                }

                // Método que se ejecuta cuando se encuentra una etiqueta de cierre
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("evento")) {
                    System.out.println("---- Fin de los marcadores ----");
                    }
                }
            };

            // Analizar el archivo XML usando el manejador
            File inputFile = new File("marcadores.xml");
            saxParser.parse(inputFile, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
