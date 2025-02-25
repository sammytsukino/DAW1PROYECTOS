package Anexo_Ejercicios;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Ejercicio_3 {

	public static void main(String[] args) {
		try {
            // Crear una fábrica SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Crear un manejador (handler) para procesar el XML
            DefaultHandler handler = new DefaultHandler() {

                boolean esTitulo = false;
                boolean esAutor = false;
                boolean esAnio = false;

                // Método que se ejecuta cuando se encuentra una etiqueta de apertura
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("titulo")) {
                        esTitulo = true;
                    } else if (qName.equalsIgnoreCase("autor")) {
                        esAutor = true;
                    } else if (qName.equalsIgnoreCase("anio")) {
                        esAnio = true;
                    }
                }

                // Método que se ejecuta cuando se encuentra el contenido entre etiquetas
                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (esTitulo) {
                        System.out.println("Título: " + new String(ch, start, length));
                        esTitulo = false;
                    }
                    if (esAutor) {
                        System.out.println("Autor: " + new String(ch, start, length));
                        esAutor = false;
                    }
                    if (esAnio) {
                        System.out.println("Año: " + new String(ch, start, length));
                        esAnio = false;
                    }
                }

                // Método que se ejecuta cuando se encuentra una etiqueta de cierre
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("libro")) {
                        System.out.println("---- Fin del libro ----");
                    }
                }
            };

            // Analizar el archivo XML usando el manejador
            File inputFile = new File("libros.xml");
            saxParser.parse(inputFile, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

