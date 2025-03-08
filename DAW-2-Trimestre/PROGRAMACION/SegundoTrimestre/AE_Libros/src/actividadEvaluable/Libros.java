package actividadEvaluable;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;

public class Libros {
	
public static void main(String[] args) {
	


	try {
		
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("Libros.xml"));
        
        // Crear una instancia de XPathFactory y XPath para realizar consultas XPath
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        
        // Menú 
        
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		while (continuar) {
			System.out.println("Elige una opción");
			System.out.println("1. Imprimir todos los títulos");
			System.out.println("2. Imprimir titulos de la autora Jane Austen");
			System.out.println("3. Imprimir precios de todos los libros");
			System.out.println("4. Imprimir titulo del autor que elijas");
			System.out.println("5. Imprimir precio de los libros más caros de 20€");
			System.out.println("6. Salir");

			int opcion = Integer.parseInt(scanner.nextLine());

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
		scanner.close();

} catch (Exception e) {
	e.printStackTrace();
	

}

}
       

private static void imprimirTitulos(Document doc, XPath xpath) throws XPathExpressionException {
    // Compilar la expresión XPath para seleccionar los nombres de los empleados
    XPathExpression exprTitulo = xpath.compile("biblioteca/libro/titulo");
    // Evaluar la expresión XPath y obtener los nodos de nombre
    NodeList titulos = (NodeList) exprTitulo.evaluate(doc, XPathConstants.NODESET);
    // Iterar sobre los nodos de nombre y imprimir su contenido
    for (int i = 0; i < titulos.getLength(); i++) {
        System.out.println(titulos.item(i).getTextContent());
    }
}
	

private static void imprimirTituloAutor(Document doc, XPath xpath, String autor) throws XPathExpressionException {
    System.out.println("\nLibros que pertenecen a " + autor);
    // Compilar la expresión XPath para seleccionar los libros del autor dado
    XPathExpression exprAutor = xpath.compile("biblioteca/libro[autor='" + autor + "']/titulo");
    // Evaluar la expresión XPath y obtener los nodos de títulos de libros del autor
    NodeList titulos = (NodeList) exprAutor.evaluate(doc, XPathConstants.NODESET);
    // Iterar sobre los nodos de títulos y imprimir su contenido
    for (int i = 0; i < titulos.getLength(); i++) {
        System.out.println(titulos.item(i).getTextContent());
    }
}


private static void imprimirPrecio(Document doc, XPath xpath) throws XPathExpressionException {
    System.out.println("\nPrecio de los libros");
    // Compilar la expresión XPath para seleccionar los nombres de los empleados
    XPathExpression exprPrecio = xpath.compile("biblioteca/libro/precio");
    // Evaluar la expresión XPath y obtener los nodos de nombre
    NodeList precios = (NodeList) exprPrecio.evaluate(doc, XPathConstants.NODESET);
    // Iterar sobre los nodos de nombre y imprimir su contenido
    for (int i = 0; i < precios.getLength(); i++) {
        System.out.println("El precio del libro " + i + " es: " + precios.item(i).getTextContent());
    }
}


private static void imprimirTituloAutorConsola(Document doc, XPath xpath) throws XPathExpressionException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduce un autor: ");
    String autor = scanner.nextLine();

    System.out.println("\nLibros que pertenecen a " + autor);
    // Compilar la expresión XPath para seleccionar los libros del autor dado
    XPathExpression exprAutor = xpath.compile("biblioteca/libro[autor='" + autor + "']/titulo");
    // Evaluar la expresión XPath y obtener los nodos de títulos de libros del autor
    NodeList titulos = (NodeList) exprAutor.evaluate(doc, XPathConstants.NODESET);
    // Iterar sobre los nodos de títulos y imprimir su contenido
    for (int i = 0; i < titulos.getLength(); i++) {
        System.out.println(titulos.item(i).getTextContent());
    }
}	

private static void imprimirPrecioSuperior(Document doc, XPath xpath) throws XPathExpressionException {
	System.out.println("\nLibros con precio mayor a 20");
	// Compilar la expresión XPath para seleccionar los precios de los libros
	XPathExpression exprPrecio = xpath.compile("biblioteca/libro[precio > 20]/titulo");
	// Evaluar la expresión XPath y obtener los nodos de títulos de libros con
	// precio mayor a 20
	NodeList titulos = (NodeList) exprPrecio.evaluate(doc, XPathConstants.NODESET);
	// Iterar sobre los nodos de títulos y imprimir su contenido
	for (int i = 0; i < titulos.getLength(); i++) {
		System.out.println(titulos.item(i).getTextContent());
	}
}
   
}



	
	


	




		