import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.File;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.NodeList;

public class modificar {

    public static void main(String[] args) {
        try {
            String departamento = "IT";
            String empleadoId = "1";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("empleados.xml"));

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            String expression = "/empleados/empleado[departamento='" + departamento + "']/nombre";
            XPathExpression exprNombres = xpath.compile(expression);
            NodeList nombres = (NodeList) exprNombres.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nombres.getLength(); i++) {
                System.out.println(nombres.item(i).getTextContent());
            }

            String expressionEdad = "/empleados/empleado[@id='" + empleadoId + "']/edad";
            XPathExpression exprEdad = xpath.compile(expressionEdad);
            NodeList edadNodes = (NodeList) exprEdad.evaluate(doc, XPathConstants.NODESET);
            if (edadNodes.getLength() > 0) {
                Node edadNode = edadNodes.item(0);
                edadNode.setTextContent("47");
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("empleados.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}