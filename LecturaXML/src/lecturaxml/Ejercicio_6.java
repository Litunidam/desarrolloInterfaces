package lecturaxml;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio_6 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int menu;

		File file = new File("ejercicio5.xml");

		menu = menu(s);
		try {
			while (menu != 5) {

				switch (menu) {

				case 1:
					showClients(file);
					break;
				case 2:

					showCars(file);

					break;
				case 3:

					showRevisions(file);
					break;
				case 4:

					showAllData(file);
					break;

				}

				showAllData(file);

				menu = menu(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void showRevisions(File file) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		NodeList revList = doc.getElementsByTagName("revision");

		for (int i = 0; i < revList.getLength(); i++) {

			Node rNode = revList.item(i);
			if (rNode.getNodeType() == Node.ELEMENT_NODE) {

				Element rev = (Element) rNode;
				System.out.println("Número de Revisión: " + rev.getAttribute("id"));
				System.out.println("Ha cambiado Filtro: "
						+ rev.getElementsByTagName("cambioFiltro").item(0).getTextContent());
				System.out.println("Ha cambiado Aceite: "
						+ rev.getElementsByTagName("cambioAceite").item(0).getTextContent());
				System.out.println("Ha cambiado Frenos: "
						+ rev.getElementsByTagName("cambioFrenos").item(0).getTextContent());
				System.out.println("Otros: " + rev.getElementsByTagName("otros").item(0).getTextContent());
				System.out.println("");

			}
		}
	}

	private static void showCars(File file) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		NodeList carList = doc.getElementsByTagName("coche");

		for (int i = 0; i < carList.getLength(); i++) {
			
			Node carNode = carList.item(i);
			
			if (carNode.getNodeType()==Node.ELEMENT_NODE) {
				
				Element car = (Element)carNode;
				
				System.out.println("ID del Coche: " +  car.getAttribute("id"));
				System.out.println("Matrícula: " + car.getElementsByTagName("matricula").item(0).getTextContent());
				System.out.println("Marca: " + car.getElementsByTagName("marca").item(0).getTextContent());
				System.out.println("Modelo: " + car.getElementsByTagName("modelo").item(0).getTextContent());
				System.out.println("Color: " + car.getElementsByTagName("color").item(0).getTextContent());
				System.out.println("Precio: " + car.getElementsByTagName("precio").item(0).getTextContent());
				System.out.println("");
				
			}
			
		}
	}

	private static void showClients(File file) throws Exception{
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		NodeList clnList = doc.getElementsByTagName("cliente");
		
		for (int i = 0; i < clnList.getLength(); i++) {
			
			Node clNode = clnList.item(i);

			if (clNode.getNodeType() == Node.ELEMENT_NODE) {

				Element client = (Element) clNode;

				System.out.println("\nID del Cliente: " + client.getAttribute("id"));
				System.out.println("NIF: " + client.getElementsByTagName("nif").item(0).getTextContent());
				System.out.println("Nombre: " + client.getElementsByTagName("nombre").item(0).getTextContent());
				System.out.println("Dirección: " + client.getElementsByTagName("direccion").item(0).getTextContent());
				System.out.println("Ciudad: " + client.getElementsByTagName("ciudad").item(0).getTextContent());
				System.out.println("Número de Teléfono: " + client.getElementsByTagName("numTelefono").item(0).getTextContent());
				System.out.println("");
			}
			
		}

	}

	private static int menu(Scanner s) {
		
		int menu;
		
		System.out.println("----------------------");
		System.out.println("1-Mostrar Clientes");
		System.out.println("2-Mostrar Coches");
		System.out.println("3-Mostrar Revisiones");
		System.out.println("4-Mostrar Todo");
		System.out.println("5-Terminar programa");
		System.out.println("----------------------");
		System.out.println("Seleccione una opción:");
		
		menu = s.nextInt();
		s.nextLine();
		
		return menu;
	}

	private static void showAllData(File file) {
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList clnList = doc.getElementsByTagName("cliente");
			
			for (int i = 0; i < clnList.getLength(); i++) {
				
				Node clNode = clnList.item(i);

				if (clNode.getNodeType() == Node.ELEMENT_NODE) {

					Element client = (Element) clNode;

					System.out.println("\nID del Cliente: " + client.getAttribute("id"));
					System.out.println("NIF: " + client.getElementsByTagName("nif").item(0).getTextContent());
					System.out.println("Nombre: " + client.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println("Dirección: " + client.getElementsByTagName("direccion").item(0).getTextContent());
					System.out.println("Ciudad: " + client.getElementsByTagName("ciudad").item(0).getTextContent());
					System.out.println("Número de Teléfono: " + client.getElementsByTagName("numTelefono").item(0).getTextContent());
					System.out.println("");

					int carLength = client.getElementsByTagName("coche").getLength();
				
					for (int j = 0; j < carLength; j++) {

						System.out.println("ID del Coche: " + ((Element)client.getElementsByTagName("coche").item(j)).getAttribute("id"));
						System.out.println("Matrícula: " + client.getElementsByTagName("matricula").item(j).getTextContent());
						System.out.println("Marca: " + client.getElementsByTagName("marca").item(j).getTextContent());
						System.out.println("Modelo: " + client.getElementsByTagName("modelo").item(j).getTextContent());
						System.out.println("Color: " + client.getElementsByTagName("color").item(j).getTextContent());
						System.out.println("Precio: " + client.getElementsByTagName("precio").item(j).getTextContent());
						System.out.println("");
						
						int rCar = ((Element)client.getElementsByTagName("coche").item(j)).getElementsByTagName("revision").getLength();

						for (int k = 0; k < rCar; k++) {

							System.out.println("Número de Revisión: " + ((Element)((Element)client.getElementsByTagName("coche").item(j)).getElementsByTagName("revision").item(k)).getAttribute("id"));
							System.out.println("Ha cambiado Filtro: " + client.getElementsByTagName("cambioFiltro").item(k).getTextContent());
							System.out.println("Ha cambiado Aceite: " + client.getElementsByTagName("cambioAceite").item(k).getTextContent());
							System.out.println("Ha cambiado Frenos: " + client.getElementsByTagName("cambioFrenos").item(k).getTextContent());
							System.out.println("Otros: " + client.getElementsByTagName("otros").item(k).getTextContent());
							System.out.println("");
						}
					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
}
