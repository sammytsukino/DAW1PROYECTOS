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
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("empleados.xml"));

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            imprimirNombresEmpleados(doc, xpath);
            imprimirEmpleadosPorDepartamento(doc, xpath, "IT");
            modificarEdadEmpleado(doc, xpath, "1", "45");
            guardarCambios(doc, "empleados.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void imprimirNombresEmpleados(Document doc, XPath xpath) throws XPathExpressionException {
        XPathExpression exprNombres = xpath.compile("empleados/empleado/nombre");
        NodeList nombres = (NodeList) exprNombres.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nombres.getLength(); i++) {
            System.out.println(nombres.item(i).getTextContent());
        }
    }

    private static void imprimirEmpleadosPorDepartamento(Document doc, XPath xpath, String departamento) throws XPathExpressionException {
        System.out.println("\nEmpleado que pertenece a " + departamento);
        XPathExpression exprDepartamento = xpath.compile("empleados/empleado[departamento='" + departamento + "']");
        NodeList departamentos = (NodeList) exprDepartamento.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < departamentos.getLength(); i++) {
            System.out.println(departamentos.item(i).getTextContent());
        }
    }

    private static void modificarEdadEmpleado(Document doc, XPath xpath, String empleadoId, String nuevaEdad) throws XPathExpressionException {
        String expressionEdad = "/empleados/empleado[@id='" + empleadoId + "']/edad";
        XPathExpression exprEdad = xpath.compile(expressionEdad);
        NodeList edadNodes = (NodeList) exprEdad.evaluate(doc, XPathConstants.NODESET);
        if (edadNodes.getLength() > 0) {
            Node edadNode = edadNodes.item(0);
            edadNode.setTextContent(nuevaEdad);
        }
    }

    private static void guardarCambios(Document doc, String archivo) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(archivo));
        transformer.transform(source, result);
    }
}