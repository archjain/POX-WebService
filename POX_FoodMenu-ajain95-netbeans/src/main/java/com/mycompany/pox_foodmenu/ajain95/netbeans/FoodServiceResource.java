/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pox_foodmenu.ajain95.netbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * REST Web Service
 *
 * @author archjain
 */
@Path("restservice")
public class FoodServiceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FoodServiceResource
     */
    public FoodServiceResource() {
        
    }

    /**
     * Retrieves representation of an instance of com.mycompany.pox_foodmenu.ajain95.netbeans.FoodServiceResource
     * @return an instance of java.lang.String
     */
    static int counter = 0;
    static String staticfoodlist =null;
    static String file_path="C:\\Users\\archjain\\Documents\\NetBeansProjects\\POX_FoodMenu-ajain95-netbeans\\resource\\FoodItemData.xml";
    @POST
    @Path("foodItem")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.TEXT_PLAIN)
    public SuperMessage getFood(String foodlist) {
     
  if(counter==0)
  {
      counter++;
      staticfoodlist=foodlist;
      return null;
  }
          foodlist=staticfoodlist;
         if(foodlist.contains("<NewFoodItems")){
            return addFoodItems(foodlist);
         }       
         System.out.println(foodlist);
       
        //TODO return proper representation object
        List<Food> listFood = new ArrayList<Food>();
        
        List<InvalidFoodItems> invalidItems = new ArrayList<InvalidFoodItems>();
      //  Food food = new Food(123,"xyz","xyz","pqr",65.65,"IN");
        int id=-1;
        String name=null;
        String description="";
        String category="";
        Double price=0.0;
        String country="";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder db1 = null;
        NodeList idList = null;
        try {
            db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(foodlist));
            db1 = fact.newDocumentBuilder();
            
            try {
                Document doc = db.parse(is);
                idList = doc.getElementsByTagName("FoodItemId");
                
                Document doc1=db1.parse(new File(file_path));
                XPathFactory factory = XPathFactory.newInstance();
                XPath xpath = factory.newXPath();
                String exp = ""; Node node=null;
                
                if(idList!=null&&idList.getLength()>0){
                    for(int i=0;i<idList.getLength();i++){
                       exp = "/FoodItemData/FoodItem[id/text()="+idList.item(i).getTextContent()+"]";
                       node=(Node)xpath.compile(exp).evaluate(doc1,XPathConstants.NODE);
                       
                       
                       if(node!=null){
                           NodeList list=node.getChildNodes();
                           country=node.getAttributes().getNamedItem("country").getNodeValue();
                           for (int j = 1; j < list.getLength(); j=j+2) {
                            Node currentNode = list.item(j);
                            if(currentNode.getNodeName().equalsIgnoreCase("id")){
                                id=Integer.parseInt(currentNode.getTextContent());
                              
                            }
                            if(currentNode.getNodeName().equalsIgnoreCase("price")){
                                price=Double.parseDouble(currentNode.getTextContent());
                                
                            }
                            if(currentNode.getNodeName().equalsIgnoreCase("name")){
                                name=currentNode.getTextContent();
                                
                            }
                            if(currentNode.getNodeName().equalsIgnoreCase("description")){
                                description=currentNode.getTextContent();
                                
                            } 
                            if(currentNode.getNodeName().equalsIgnoreCase("category")){
                                category=currentNode.getTextContent();
                                
                            } 
                            
                            
                           }
                           listFood.add(new Food(id,name,description,category,price,country));
                       }
                       else{
                           invalidItems.add(new InvalidFoodItems(Integer.parseInt(idList.item(i).getTextContent())));
                       }
                    }
                }
                doc1.getElementsByTagName("");
                
            } catch (SAXException e) {
                System.out.println("sax");
                    return new InvalidRequest("http://cse564.asu.edu/PoxAssignment");
            } catch (IOException e) {
                System.out.println("io");
                return new InvalidRequest("http://cse564.asu.edu/PoxAssignment");
            } catch (XPathExpressionException ex) {
                System.out.println("xpath");
                Logger.getLogger(FoodServiceResource.class.getName()).log(Level.SEVERE, null, ex);
                return new InvalidRequest("http://cse564.asu.edu/PoxAssignment");
            } 
        } catch (ParserConfigurationException e1) {
            System.out.println("parser config");
            return new InvalidRequest("http://cse564.asu.edu/PoxAssignment");
    
        }
        
        FoodResponce response = new FoodResponce();
        if(listFood.size()>0){
           response.setFoodItem(listFood);
           
        }
        if(invalidItems.size()>0){
           response.setInvalidFoodItem(invalidItems);
           
        }
        staticfoodlist=null;
        counter=0;
                
        response.setXmlns("http://cse564.asu.edu/PoxAssignment");
        return response;

    }

    /**
     * PUT method for updating or creating an instance of FoodServiceResource
     * @param content representation for the resource
     */
//    static int  counter =0;
 //   @POST
  //  @Path("AddFood")
  //  @Produces(MediaType.APPLICATION_XML)
  //  @Consumes(MediaType.TEXT_PLAIN)
    public SuperMessage addFoodItems(String foodlist) {
               
      //  if(counter==0)
      //  {   
       //     counter++;
       //     return null;
       // }
        Node existNode=null;
        int flag=-1;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder db1 = null;
        NodeList itemList = null;
        try {
            db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(foodlist));
            db1 = fact.newDocumentBuilder();
            try {
                 Document doc = db.parse(is);
                 itemList = doc.getElementsByTagName("FoodItem");
                 Document doc1 = db1.parse(new File(file_path));
                 
                 XPathFactory factory1 = XPathFactory.newInstance();
                 XPath xp1 = factory1.newXPath();
                 XPathFactory factory2 = XPathFactory.newInstance();
                 XPath xp2 = factory2.newXPath();
                 String exp1 = "";
                 String exp2="";
                 for(int i=0;i<itemList.getLength();i++){
                    NodeList list2=itemList.item(i).getChildNodes();
                    String itemName = "";
                    for(int j=0;j<list2.getLength();j++){
                        if(list2.item(j).getNodeName()=="name"){
                           itemName = list2.item(j).getTextContent();
                           break;
                            
                        } 
                    }
                    exp1 = "/FoodItemData/FoodItem[name/text()='"+itemName+"']";
                    Node node = (Node)xp1.compile(exp1).evaluate(doc1,XPathConstants.NODE);
                    if(node==null){
                        exp2="/FoodItemData/FoodItem/id";
                        NodeList existingIds = (NodeList)xp2.compile(exp2).evaluate(doc1,XPathConstants.NODESET);
                        int maxId=-1;
                        for(int j=0;j<existingIds.getLength();j++){
                            int currentId = Integer.parseInt(existingIds.item(j).getTextContent());
                            if(maxId<currentId){
                                maxId = currentId;
                                
                            }
                            
                        }
                        System.out.println("maxid " +maxId );
                        flag=maxId+1;
                        System.out.println("$$$$"+maxId);
                        Element root = doc1.getDocumentElement();
                        Element foodItem = doc1.createElement("FoodItem");
                        root.appendChild(foodItem);
                        Element id = doc1.createElement("id");
                        id.setTextContent(new Integer(maxId+1).toString());
                        foodItem.appendChild(id);
                        NodeList elementList = itemList.item(i).getChildNodes();
                        foodItem.setAttribute("country", itemList.item(i).getAttributes().getNamedItem("country").getNodeValue());
                        for(int j=0;j<elementList.getLength();j++){
                            if(elementList.item(j).getNodeName()=="name"){
                                Element name=doc1.createElement("name");
                                name.setTextContent(elementList.item(j).getTextContent());
                                foodItem.appendChild(name);
                            }
                            if(elementList.item(j).getNodeName()=="description"){
                                Element description=doc1.createElement("description");
                                description.setTextContent(elementList.item(j).getTextContent());
                                foodItem.appendChild(description);
                            }
                            if(elementList.item(j).getNodeName()=="category"){
                                Element category=doc1.createElement("category");
                                category.setTextContent(elementList.item(j).getTextContent());
                                foodItem.appendChild(category);
                            }
                             if(elementList.item(j).getNodeName()=="price"){
                                Element price=doc1.createElement("price");
                                price.setTextContent(elementList.item(j).getTextContent());
                                foodItem.appendChild(price);
                            }
                        }
                        
                        Transformer transformer;
                        try {
                            transformer = TransformerFactory.newInstance().newTransformer();
                        
                        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                        StreamResult result = new StreamResult(new FileOutputStream(file_path));
                        DOMSource source = new DOMSource(doc1);
                            try {
                                transformer.transform(source, result);
                            } catch (TransformerException ex) {
                                Logger.getLogger(FoodServiceResource.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        System.out.println("File saved!"); 
                        } catch (TransformerConfigurationException ex) {
                            Logger.getLogger(FoodServiceResource.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else existNode =node;
                 }
                 
            } catch (SAXException e) {
             return new InvalidRequest("http://cse564.asu.edu/PoxAssignment");
            } catch (IOException e) {
                return new InvalidRequest("http://cse564.asu.edu/PoxAssignment");
            } catch (XPathExpressionException ex) {
                Logger.getLogger(FoodServiceResource.class.getName()).log(Level.SEVERE, null, ex);
                return new InvalidRequest("http://cse564.asu.edu/PoxAssignment");
            }
        } catch (ParserConfigurationException e1) {
            return new InvalidRequest("http://cse564.asu.edu/PoxAssignment");
        }
       
        
        
      //  counter=0;
       // System.err.println("flag"+flag);
        if(flag>-1){
          return new FoodAddedMessage(flag,"http://cse564.asu.edu/PoxAssignment");
        }
        else
        {    
            int id=-1;
          //  System.out.println("sup");
            NodeList list = existNode.getChildNodes();
                for(int i=0;i<list.getLength();i++){
                 if(list.item(i).getNodeName()=="id")
                     id=Integer.parseInt(list.item(i).getTextContent().toString());
                }
                
              staticfoodlist=null;
               counter=0;   
            return new FoodItemExists(id,"http://cse564.asu.edu/PoxAssignment");  
        }
     
    }
  
}
