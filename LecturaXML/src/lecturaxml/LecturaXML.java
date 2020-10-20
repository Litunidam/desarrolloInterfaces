package lecturaxml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class LecturaXML {


    public static void main(String[] args) {
        File file = new File("concesionario.xml");

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("coche");
            System.out.println("Número de coches: " + nList.getLength());

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("\nCoche id: " + eElement.getAttribute("id"));
                    System.out.println("Marca: "
                            + eElement.getElementsByTagName("marca").item(0).getTextContent());
                    System.out.println("Modelo: "
                            + eElement.getElementsByTagName("modelo").item(0).getTextContent());
                    System.out.println("Cilindrada: "
                            + eElement.getElementsByTagName("cilindrada").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
