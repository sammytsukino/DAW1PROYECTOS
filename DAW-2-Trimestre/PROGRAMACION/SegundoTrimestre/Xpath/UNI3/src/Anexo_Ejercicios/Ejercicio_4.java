package Anexo_Ejercicios;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.File;

public class Ejercicio_4 {

	public static void main(String[] args) {
		 try {
	            // Crear instancia de DocumentBuilderFactory y XPathFactory
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document doc = builder.parse(new File("libros.xml"));
	            //XPathFactory lo usamos para crear una instancia de Xpath
	            // xpath es el objeto que recorre realmente el XML
	            XPathFactory xpathFactory = XPathFactory.newInstance();
	            XPath xpath = xpathFactory.newXPath();

	            // 1. Buscar todos los títulos de libros
	            System.out.println("Títulos de libros:");
	            // La siguiente línea compila la expresión XPath que estamos interesados en ejecutar. 
	            // La consulta "/libros/libro/titulo" significa lo siguiente:
	            // libros: Selecciona el nodo raíz <libros>.
	            // /libro: Selecciona todos los nodos <libro> que son hijos directos del nodo
	            // <libros>.
	            // /titulo: Selecciona todos los nodos <titulo> que son hijos de cada nodo
	            // <libro>.
	            XPathExpression exprTitulos = xpath.compile("/libros/libro/titulo");
	            //Básicamente, la línea anterior, selecciona todos los títulos de los libros en el XML
	            NodeList titulos = (NodeList) exprTitulos.evaluate(doc, XPathConstants.NODESET);
	            // El método evaluate() ejecuta la consulta y devuelve el resultado. El parámetro 
	            // XPathConstants.NODESET indica que queremos un conjunto de nodos como resultado. 
	            // El resultado se almacena en un objeto NodeList
	            for (int i = 0; i < titulos.getLength(); i++) {
	                System.out.println(titulos.item(i).getTextContent());
	            /*Recorrer los resultados de la consulta:
	             
	              NodeList: Un NodeList es básicamente una lista de nodos. Cada nodo en
	              esta lista corresponde a uno de los nodos <titulo> que seleccionamos en la
	              consulta.
	              getTextContent(): Este método recupera el contenido textual de cada
	              nodo <titulo>, es decir, el título del libro.
	              En este bucle, estamos recorriendo todos los títulos de los libros y los
	              imprimimos en la consola.*/
	            }

	            // 2. Buscar todos los autores
	            System.out.println("\nAutores de libros:");
	            XPathExpression exprAutores = xpath.compile("/libros/libro/autor");
	            NodeList autores = (NodeList) exprAutores.evaluate(doc, XPathConstants.NODESET);
	            for (int i = 0; i < autores.getLength(); i++) {
	                System.out.println(autores.item(i).getTextContent());
	            }

	            // 3. Buscar libros publicados después del año 1900
	            //https://www.ibm.com/docs/es/bpm/8.5.7?topic=builder-example-using-conditions-in-xpath-expressions
	            System.out.println("\nLibros publicados después de 1900:");
	            XPathExpression exprLibrosRecientes = xpath.compile("/libros/libro[anio > 1900]/titulo");
	            NodeList librosRecientes = (NodeList) exprLibrosRecientes.evaluate(doc, XPathConstants.NODESET);
	            for (int i = 0; i < librosRecientes.getLength(); i++) {
	                System.out.println(librosRecientes.item(i).getTextContent());
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}