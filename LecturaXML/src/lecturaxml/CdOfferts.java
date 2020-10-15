package lecturaxml;

import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CdOfferts {

    public static void main(String[] args) {

        File f = new File("cd.xml");
        Scanner s = new Scanner(System.in);
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(f);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("cd");
            String filter;
            

            System.out.println("--------------------------------------------");
            System.out.println("-------------------Menu---------------------");
            System.out.println("Mostrar Título");
            System.out.println("Mostrar Artista");
            System.out.println("Mostrar País");
            System.out.println("Mostrar CompañíaDiscográfica");
            System.out.println("Mostrar Precio");
            System.out.println("Mostrar AñoDePublicacion");
            System.out.println("Mostrar todo");
            System.out.println("-------------------Menu---------------------");
            System.out.println("--------------------------------------------");
            System.out.println("Introduce la etiqueta a filtrar:");
            
            filter = s.nextLine();
            
            
            if(filter.equals("todo")){
                
                System.out.println("Número de ofertas: " + nList.getLength());
                
                for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("\nCD id: " + eElement.getAttribute("id"));
                    System.out.println("Título: "
                            + eElement.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Artista: "
                            + eElement.getElementsByTagName("artista").item(0).getTextContent());
                    System.out.println("País: "
                            + eElement.getElementsByTagName("pais").item(0).getTextContent());
                    System.out.println("Compañia discográfica: "
                            + eElement.getElementsByTagName("companiaDiscografica").item(0).getTextContent());
                    System.out.println("Precio: "
                            + eElement.getElementsByTagName("precio").item(0).getTextContent());
                    System.out.println("Año de publicación: "
                            + eElement.getElementsByTagName("anoDePublicacion").item(0).getTextContent());
                }
            }
                
            }else{
                System.out.println("Número de ofertas: " + nList.getLength());
                showList(filter,nList);
            }
            

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void showList(String filter,NodeList nList) {
    
        try{
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("\nCD id: " + eElement.getAttribute("id"));
                    System.out.println(filter.toUpperCase()+": "
                            + eElement.getElementsByTagName(filter).item(0).getTextContent());
                    
                }
            }
            
        }catch(Exception e){
            System.out.println("No has introducido un nombre correcto");
        }
        


        
    }
}
