import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.File;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class empleados {

    public static void main(String[] args) {
        try {
            // Crear una instancia de DocumentBuilderFactory y DocumentBuilder para parsear el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("empleados.xml"));

            // Crear una instancia de XPathFactory y XPath para realizar consultas XPath
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            // Llamar a los métodos para realizar diferentes operaciones en el XML
            imprimirNombresEmpleados(doc, xpath); // Imprimir nombres de todos los empleados
            imprimirEmpleadosPorDepartamento(doc, xpath, "IT"); // Imprimir empleados del departamento "IT"
            modificarEdadEmpleado(doc, xpath, "1", "45"); // Modificar la edad del empleado con ID "1" a "45"
            guardarCambios(doc, "empleados.xml"); // Guardar los cambios en el archivo XML

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para imprimir los nombres de todos los empleados
    private static void imprimirNombresEmpleados(Document doc, XPath xpath) throws XPathExpressionException {
        // Compilar la expresión XPath para seleccionar los nombres de los empleados
        XPathExpression exprNombres = xpath.compile("empleados/empleado/nombre");
        // Evaluar la expresión XPath y obtener los nodos de nombre
        NodeList nombres = (NodeList) exprNombres.evaluate(doc, XPathConstants.NODESET);
        // Iterar sobre los nodos de nombre y imprimir su contenido
        for (int i = 0; i < nombres.getLength(); i++) {
            System.out.println(nombres.item(i).getTextContent());
        }
    }

    // Método para imprimir los empleados que pertenecen a un departamento específico
    private static void imprimirEmpleadosPorDepartamento(Document doc, XPath xpath, String departamento) throws XPathExpressionException {
        System.out.println("\nEmpleado que pertenece a " + departamento);
        // Compilar la expresión XPath para seleccionar los empleados del departamento dado
        XPathExpression exprDepartamento = xpath.compile("empleados/empleado[departamento='" + departamento + "']");
        // Evaluar la expresión XPath y obtener los nodos de empleados del departamento
        NodeList departamentos = (NodeList) exprDepartamento.evaluate(doc, XPathConstants.NODESET);
        // Iterar sobre los nodos de empleados y imprimir su contenido
        for (int i = 0; i < departamentos.getLength(); i++) {
            System.out.println(departamentos.item(i).getTextContent());
        }
    }

    // Método para modificar la edad de un empleado específico
    private static void modificarEdadEmpleado(Document doc, XPath xpath, String empleadoId, String nuevaEdad) throws XPathExpressionException {
        // Compilar la expresión XPath para seleccionar el nodo de edad del empleado con el ID dado
        String expressionEdad = "/empleados/empleado[@id='" + empleadoId + "']/edad";
        XPathExpression exprEdad = xpath.compile(expressionEdad);
        // Evaluar la expresión XPath y obtener el nodo de edad
        NodeList edadNodes = (NodeList) exprEdad.evaluate(doc, XPathConstants.NODESET);
        // Si se encuentra el nodo de edad, actualizar su contenido con la nueva edad
        if (edadNodes.getLength() > 0) {
            Node edadNode = edadNodes.item(0);
            edadNode.setTextContent(nuevaEdad);
        }
    }

    // Método para guardar los cambios realizados en el documento XML
    private static void guardarCambios(Document doc, String archivo) throws TransformerException {
        // Crear una instancia de TransformerFactory y Transformer para guardar el documento XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        // Crear una fuente DOM y un resultado de flujo para el archivo de salida
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(archivo));
        // Transformar el documento DOM y guardar los cambios en el archivo
        transformer.transform(source, result);
    }
}