/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pox_foodmenu.ajain95.netbeans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author archjain
 */
@XmlRootElement (name = "FoodItemExists")
public class FoodItemExists extends SuperMessage{
    private int FoodItemId;
    private String xmlns;

    public FoodItemExists(){}
    public FoodItemExists(int FoodItemId, String xmlns) {
        this.FoodItemId = FoodItemId;
        this.xmlns = xmlns;
    }

    public String getXmlns() {
        return xmlns;
    }

    @XmlAttribute
    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }
    public int getFoodItemId() {
        return FoodItemId;
    }
        
    @XmlElement
    public void setFoodItemId(int FoodItemId) {
        this.FoodItemId = FoodItemId;
    }
}
