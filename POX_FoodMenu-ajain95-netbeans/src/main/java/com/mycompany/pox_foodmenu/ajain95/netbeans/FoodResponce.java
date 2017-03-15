/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pox_foodmenu.ajain95.netbeans;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author archjain
 */
@XmlRootElement(name = "RetrievedFoodItems")
public class FoodResponce extends SuperMessage {
    private String xmlns;
    private List<Food> FoodItem;
    private List<InvalidFoodItems> InvalidFoodItem;
    public FoodResponce(){
        
    }
    public FoodResponce(String xmlns,List<Food> FoodItem,List<InvalidFoodItems> InvalidFoodItem){
        this.xmlns=xmlns;
        this.FoodItem=FoodItem;
        this.InvalidFoodItem=InvalidFoodItem;
    }
    /**
     * @return the FoodItem
     */
    public List<Food> getFoodItem() {
        return FoodItem;
    }

    /**
     * @param FoodItem the FoodItem to set
     */
    @XmlElement
    public void setFoodItem(List<Food> FoodItem) {
        this.FoodItem = FoodItem;
    }
   

    /**
     * @return the xmlns
     */
    public String getXmlns() {
        return xmlns;
    }

    /**
     * @param xmlns the xmlns to set
     */
    @XmlAttribute
    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    /**
     * @return the InvalidFoodItem
     */
    public List<InvalidFoodItems> getInvalidFoodItem() {
        return InvalidFoodItem;
    }

    /**
     * @param InvalidFoodItem the InvalidFoodItem to set
     */
    @XmlElement
    public void setInvalidFoodItem(List<InvalidFoodItems> InvalidFoodItem) {
        this.InvalidFoodItem = InvalidFoodItem;
    }
}
