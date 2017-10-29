/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerXML {

	public class Ciudad {

		public String nombre = "";
		public String latitud = "";
		public String longitud = "";

		public Ciudad(String nombre, String latitud, String longitud) {
			this.nombre = nombre;
			this.latitud = latitud;
			this.longitud = longitud;
		}

	}

	public ArrayList<Ciudad> crearMatrizCiudades() {

		ArrayList<Ciudad> matrizCiudades = new ArrayList<>();

		try {
			File inputFile = new File("C:/Users/FiJus/Documents/TrabajosQuintoSemestre/NetBeansBasesDeDatos/Proyecto/src/java/Controlador/Cities.kml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

                        System.out.println("HOLA");
                        
			NodeList placemarkList = doc.getElementsByTagName("Placemark");
			NodeList pointList = doc.getElementsByTagName("Point");

			for (int i = 0; i < placemarkList.getLength(); i++) {

                            System.out.println("FOR");
                            
				Node pmNode = placemarkList.item(i);
				Element pmElement = (Element) pmNode;
				String nombre = pmElement.getElementsByTagName("name").item(0).getTextContent().trim();

				Node pointNode = pointList.item(i);
				Element pointElement = (Element) pointNode;
				String coordenadas = pointElement.getElementsByTagName("coordinates").item(0).getTextContent().trim();

				String[] coordAux = coordenadas.split(",");

				matrizCiudades.add(new Ciudad(nombre, coordAux[1], coordAux[0]));
			}

                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}

		return matrizCiudades;
	}

	public String convertirString() {

		ArrayList<Ciudad> aux = crearMatrizCiudades();
		String s = "";

		for (int i = 0; i < aux.size(); i++) {
			Ciudad cAux = aux.get(i);
			if (i == aux.size() - 1) {
				s += cAux.nombre + "_" + cAux.latitud + "_" + cAux.longitud;
			} else {
				s += cAux.nombre + "_" + cAux.latitud + "_" + cAux.longitud + "*";
			}
		}

		return s;
	}

	public static void main(String[] args) {

		LeerXML aux = new LeerXML();
		System.out.println(aux.convertirString());

	}

}
