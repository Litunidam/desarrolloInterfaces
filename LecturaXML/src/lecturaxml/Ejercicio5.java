/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaxml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author manue
 */
public class Ejercicio5 {
    
    public static void main(String[] args) {
        File file = new File("pedido.xml");
        
  
        try {
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("pedido");
            System.out.println("Número de pedidos: " + nList.getLength());
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("\nID Pedido: " + eElement.getAttribute("id"));
                    System.out.println("nPedido: "
                            + eElement.getElementsByTagName("nPedido").item(0).getTextContent());
                    System.out.println("Nombre: "
                            + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Direccion: "
                            + eElement.getElementsByTagName("direccion").item(0).getTextContent());
                }
            }
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
       

 
   
       
        
        
    }
    
    
}
