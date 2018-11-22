package xml;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 * @author tiago
 *
 */
public class Config {
   public static void main(String[] args){
      try {	
         File inputFile = new File("config.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();         
         System.out.println("\n----- Search the XML document with xpath queries -----");  
         // Query 1 
         System.out.println("Query 1: ");
         XPathFactory xpathFactory = XPathFactory.newInstance();
         XPath xpath = xpathFactory.newXPath();
         XPathExpression expr = xpath.compile("/XML/Service/@*");
         NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
         for (int i = 0; i < nl.getLength(); i++) {
             System.out.print(nl.item(i).getNodeName()  + ": ");
             System.out.println(nl.item(i).getFirstChild().getNodeValue());
         }
         // Query 2
         System.out.println("\nQuery 2: ");         
         expr = xpath.compile("/XML/Paths/docPath");
         String str = (String) expr.evaluate(doc, XPathConstants.STRING);
         
         System.out.println("docPath: " + str);
         
         // Adding new element Service with attributes to the XML document (root node)
         System.out.println("\n----- Adding new element <Service> with attributes to the XML document -----");

         Element newElement1 = doc.createElement("Service");
         newElement1.setAttribute("Protocol", "smtp");
         newElement1.setAttribute("Account", "manuel@iscte-iul.pt");
         newElement1.setAttribute("Password", "xyzw");
         
         // Adding new element OtherNewTag to the XML document (root node)
         System.out.println("----- Adding new element <OtherNewTag> to the XML document -----");
 
         Element newElement2 = doc.createElement("OtherNewTag");
         newElement2.setTextContent("More new data"); 
         
         // Add new nodes to XML document (root element)
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());         
         Node n = doc.getDocumentElement();
         n.appendChild(newElement1);
         n.appendChild(newElement2);         
       
         // Save XML document
         System.out.println("\nSave XML document.");
         Transformer transformer = TransformerFactory.newInstance().newTransformer();
         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
         DOMSource source = new DOMSource(doc);
         transformer.transform(source, result);
      } catch (Exception e) { e.printStackTrace(); }
   }
}