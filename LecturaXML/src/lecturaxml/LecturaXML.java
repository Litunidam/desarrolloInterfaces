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
            NodeList coches = doc.getElementsByTagName("coche");
            System.out.println("Número de coches: " + coches.getLength());

            for (int temp = 0; temp < coches.getLength(); temp++) {
                Node coche = coches.item(temp);

                if (coche.getNodeType() == Node.ELEMENT_NODE) {
                    Element eCoche = (Element) coche;

                    System.out.println("\nCoche id: " + eCoche.getAttribute("id"));
                    NodeList marcasCoche = eCoche.getElementsByTagName("marca");
                    
                    System.out.println("Marca: "
                            + eCoche.getElementsByTagName("marca").item(0).getTextContent());
                    System.out.println("Modelo: "
                            + eCoche.getElementsByTagName("modelo").item(0).getTextContent());
                    System.out.println("Cilindrada: "
                            + eCoche.getElementsByTagName("cilindrada").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
