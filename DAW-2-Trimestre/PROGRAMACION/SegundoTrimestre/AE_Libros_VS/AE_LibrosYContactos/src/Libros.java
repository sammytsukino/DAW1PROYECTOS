import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;

public class Libros {

    /*
     * Método principal que inicia el programa, carga el archivo XML
     * y muestra el menú de opciones al usuario
     */
    public static void main(String[] args) {

        try {
            /*
             * Configuración para cargar y parsear el archivo XML
             * usando DOM (Document Object Model)
             */
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("D:\\Documentos\\DAW1PROYECTOS\\DAW-2-Trimestre\\PROGRAMACION\\SegundoTrimestre\\AE_Libros_VS\\AE_LibrosYContactos\\Libros.xml"));

            /*
             * Creación de objetos para realizar consultas XPath
             * sobre el documento XML
             */
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            /* Menú de opciones usando Scanner para entrada del usuario */
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                /* Muestra las opciones disponibles */
                System.out.println("\n");
                System.out.println("-------------------");
                System.out.println("Elige una opción");
                System.out.println("1. Imprimir todos los títulos");
                System.out.println("2. Imprimir titulos de la autora Jane Austen");
                System.out.println("3. Imprimir precios de todos los libros");
                System.out.println("4. Imprimir titulo del autor que elijas");
                System.out.println("5. Imprimir precio de los libros más caros de 20€1");
                System.out.println("6. Salir");
                System.out.println("-------------------");
                System.out.println("\n");

                /* Lee la opción seleccionada por el usuario */
                int opcion = Integer.parseInt(scanner.nextLine());

                /* Ejecuta la acción correspondiente a la opción seleccionada */
                switch (opcion) {
                    case 1:
                        imprimirTitulos(doc, xpath);
                        break;
                    case 2:
                        imprimirTituloAutor(doc, xpath, "Jane Austen");
                        break;
                    case 3:
                        imprimirPrecio(doc, xpath);
                        break;
                    case 4:
                        imprimirTituloAutorConsola(doc, xpath);
                        break;
                    case 5:
                        imprimirPrecioSuperior(doc, xpath);
                        break;
                    case 6:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                        break;
                }
            }
            /* Cierra el scanner al finalizar */
            scanner.close();

        } catch (Exception e) {
            /* Manejo de excepciones mostrando la traza del error */
            e.printStackTrace();
        }
    }

    /*
     * Método que imprime todos los títulos de libros
     * utilizando una expresión XPath
     */
    private static void imprimirTitulos(Document doc, XPath xpath) throws XPathExpressionException {
        /* Consulta XPath para seleccionar todos los títulos */
        XPathExpression exprTitulo = xpath.compile("biblioteca/libro/titulo");
        /* Evalúa la expresión y obtiene los nodos resultado */
        NodeList titulos = (NodeList) exprTitulo.evaluate(doc, XPathConstants.NODESET);
        /* Recorre la lista de nodos e imprime el contenido de cada título */
        for (int i = 0; i < titulos.getLength(); i++) {
            System.out.println(titulos.item(i).getTextContent());
        }
    }

    /*
     * Método que imprime los títulos de libros de un autor específico
     * utilizando una expresión XPath con filtro
     */
    private static void imprimirTituloAutor(Document doc, XPath xpath, String autor) throws XPathExpressionException {
        System.out.println("\nLibros que pertenecen a " + autor);
        /* Consulta XPath filtrada por autor específico */
        XPathExpression exprAutor = xpath.compile("biblioteca/libro[autor='" + autor + "']/titulo");
        /* Evalúa la expresión y obtiene los nodos resultado */
        NodeList titulos = (NodeList) exprAutor.evaluate(doc, XPathConstants.NODESET);
        /* Recorre la lista de nodos e imprime el contenido de cada título */
        for (int i = 0; i < titulos.getLength(); i++) {
            System.out.println(titulos.item(i).getTextContent());
        }
    }

    /*
     * Método que imprime los precios de todos los libros
     * utilizando una expresión XPath
     */
    private static void imprimirPrecio(Document doc, XPath xpath) throws XPathExpressionException {
        System.out.println("\nPrecio de los libros");
        // Consulta XPath para seleccionar todos los libros
        XPathExpression exprLibros = xpath.compile("biblioteca/libro");
        // Evalúa la expresión y obtiene los nodos resultado
        NodeList libros = (NodeList) exprLibros.evaluate(doc, XPathConstants.NODESET);
        // Recorre la lista de nodos e imprime el título y el precio de cada libro
        for (int i = 0; i < libros.getLength(); i++) {
            Node libro = libros.item(i);
            String titulo = xpath.compile("titulo").evaluate(libro);
            String precio = xpath.compile("precio").evaluate(libro);
            System.out.println("El precio del libro " + titulo + " es: " + precio);
        }
    }

    /*
     * Método que solicita un autor al usuario y muestra sus libros
     * utilizando una expresión XPath con filtro
     */
    private static void imprimirTituloAutorConsola(Document doc, XPath xpath) throws XPathExpressionException {
        try (/* Solicita el autor al usuario */
        Scanner scanner = new Scanner(System.in)) {
            System.out.println("Introduce un autor: ");
            String autor = scanner.nextLine();

            System.out.println("\nLibros que pertenecen a " + autor);
            /* Consulta XPath filtrada por el autor introducido */
            XPathExpression exprAutor = xpath.compile("biblioteca/libro[autor='" + autor + "']/titulo");
            /* Evalúa la expresión y obtiene los nodos resultado */
            NodeList titulos = (NodeList) exprAutor.evaluate(doc, XPathConstants.NODESET);
            /* Recorre la lista de nodos e imprime el contenido de cada título */
            for (int i = 0; i < titulos.getLength(); i++) {
                System.out.println(titulos.item(i).getTextContent());
            }
        } catch (DOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * Método que imprime los títulos de libros con precio superior a 20
     * utilizando una expresión XPath con filtro numérico
     */
    private static void imprimirPrecioSuperior(Document doc, XPath xpath) throws XPathExpressionException {
        System.out.println("\nLibros con precio mayor a 20");
        /* Consulta XPath con filtro para precios mayores a 20 */
        XPathExpression exprPrecio = xpath.compile("biblioteca/libro[precio > 20]/titulo");
        /* Evalúa la expresión y obtiene los nodos resultado */
        NodeList titulos = (NodeList) exprPrecio.evaluate(doc, XPathConstants.NODESET);
        /* Recorre la lista de nodos e imprime el contenido de cada título */
        for (int i = 0; i < titulos.getLength(); i++) {
            System.out.println(titulos.item(i).getTextContent());
        }
    }
}