/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adressbook;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Olga
 */
public class AdressBook {

    /**
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder = f.newDocumentBuilder();
        Document doc = builder.parse(new File("src/adressbook/AdressBook.xml"));
        read(doc, 0); 
        System.out.print();
	
    }
    public static void read(Node node, int level) { 
    NodeList list = node.getChildNodes(); 
    for (int i = 0; i < list.getLength(); i++) { 
      Node childNode = list.item(i); // текущий нод 
      process(childNode, level + 1); // обработка 
      read(childNode, level + 1); // рекурсия 
    } 
  } 
     public static void process(Node node, int level) { 
    if(node.getNodeValue()!=null)System.out.print(node.getNodeValue());
  } 
} 
