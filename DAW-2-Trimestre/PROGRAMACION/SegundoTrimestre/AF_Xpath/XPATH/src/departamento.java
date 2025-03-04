import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.File;

import org.w3c.dom.NodeList;

public class departamento {

    public static void main(String[] args) {
        try {
            String departamento = "IT";

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}