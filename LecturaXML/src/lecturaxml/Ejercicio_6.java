package lecturaxml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio_6 {

	public static void main(String[] args) {

		File file = new File("ejercicio5.xml");
		
		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList clnList = doc.getElementsByTagName("cliente");

			
			for(int i = 0;i<clnList.getLength();i++) {
				
				Node clNode = clnList.item(i);

				
				if(clNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element text = (Element) clNode; 
					
					System.out.println("\nID del Cliente: "+text.getAttribute("id"));
					System.out.println("NIF: "+text.getElementsByTagName("nif").item(0).getTextContent());
					System.out.println("Nombre: "+text.getElementsByTagName("nombre").item(0).getTextContent());		
					System.out.println("Dirección: "+text.getElementsByTagName("direccion").item(0).getTextContent());
					System.out.println("Ciudad: "+text.getElementsByTagName("ciudad").item(0).getTextContent());
					System.out.println("Número de Teléfono: "+text.getElementsByTagName("numTelefono").item(0).getTextContent());
					
					int carLength = text.getElementsByTagName("coche").getLength();
					int revLength = text.getElementsByTagName("revision").getLength();	
					
					for (int j = 0;j<carLength;j++) {
						
						System.out.println("ID del Coche: "+text.getAttribute("id"));
						System.out.println("Matrícula: "+text.getElementsByTagName("matricula").item(j).getTextContent());
						System.out.println("Marca: "+text.getElementsByTagName("marca").item(j).getTextContent());
						System.out.println("Modelo: "+text.getElementsByTagName("modelo").item(j).getTextContent());
						System.out.println("Color: "+text.getElementsByTagName("color").item(j).getTextContent());
						System.out.println("Precio: "+text.getElementsByTagName("precio").item(j).getTextContent());
		
						for (int k = 0;k<revLength;k++) {
							
							System.out.println("Número de Revisión: "+text.getAttribute("id"));
							System.out.println("Ha cambiado Filtro: "+text.getElementsByTagName("cambioFiltro").item(k).getTextContent());
							System.out.println("Ha cambiado Aceite: "+text.getElementsByTagName("cambioAceite").item(k).getTextContent());
							System.out.println("Ha cambiado Frenos: "+text.getElementsByTagName("cambioFrenos").item(k).getTextContent());
							System.out.println("Otros: "+text.getElementsByTagName("otros").item(k).getTextContent());
							
						}
					}
				}
			}
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
