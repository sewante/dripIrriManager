/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import dripirrimanager.ErrorLogger;

/**
 *
 * @author robert
 */

/**
 * This file is responsible for getting the XML data in the config files for the pipe and crop data
 */
public class DripIrriXMLConfig {
    
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document doc;
    private ErrorLogger logger;
    //private NodeList list;
    private File file;
    
    private ArrayList<String> childNodes;

    /**
     *  The constructor
     * @param xmlFile : The xml file to be processed
     */
    public  DripIrriXMLConfig (String xmlFile) {
        
        logger = ErrorLogger.getLogger();
        try {
            childNodes = new ArrayList<>(); //initialize the child nodes array list
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            
            file  = new File(xmlFile);  //load the xml file
            doc = builder.parse(file);  //parse the XML file
            
            
        } catch (ParserConfigurationException ex) {
            logger.logError("models.DripIrriXMLConfig.DripIrriXMLConfig "+ex.getMessage());
        } catch (SAXException ex) {
            logger.logError("models.DripIrriXMLConfig.DripIrriXMLConfig "+ex.getMessage());
        } catch (IOException ex) {
            
            logger.logError("models.DripIrriXMLConfig.DripIrriXMLConfig "+ex.getMessage());
        }
    }
    
    /** Function to search for the child nodes of the specified parendNode
     * @param parentNode : the parent node whose child nodes we want to extract
     * @return ArrayList<String> : an ArrayList of the child nodes
     */
    public ArrayList<String> getChildNodes(String parentNode) {
        
        NodeList list = null;
        
        try {
            list = doc.getElementsByTagName(parentNode);
        
            //loop throught the list to pick the child elements
            for (int i = 0; i < list.getLength(); i++) {
                Node currentNode = list.item(i);

                //check if the picked node is an element node
                if(currentNode.getNodeType() == Node.ELEMENT_NODE) {
                    //downcast the node
                    Element element = (Element)currentNode;
                    NodeList nodes = element.getChildNodes();
                    for(int j = 0; j < nodes.getLength(); j++) {
                        Node node = nodes.item(j);
                        //check the type of node 
                        if(node.getNodeType() == Node.ELEMENT_NODE) {
                            Element childNode = (Element)node;
                            //add the child node values to the arraylist
                            childNodes.add(childNode.getTextContent());
                        }
                    }
                }

            }  
        }
        catch(Exception e) {
            logger.logError("models.DripIrriXMLConfig.getChildNodes "+e.getMessage());
        }
        
        
        return childNodes;
    }
}
