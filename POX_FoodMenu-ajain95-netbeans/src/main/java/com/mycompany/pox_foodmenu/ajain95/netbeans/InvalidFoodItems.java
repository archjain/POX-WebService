/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pox_foodmenu.ajain95.netbeans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author archjain
 */
@XmlRootElement(name = "InvalidFoodItem")
public class InvalidFoodItems {
    private int FoodItemId;
    public InvalidFoodItems(){
        
    }
    public InvalidFoodItems(int FoodItemId){
        this.FoodItemId=FoodItemId;
    }
    /**
     * @return the FoodItem
     */
    public int getFoodItemId() {
        return FoodItemId;
    }

    /**
     * @param FoodItem the FoodItem to set
     */
    @XmlElement
    public void setFoodItemId(int FoodItemId) {
        this.FoodItemId = FoodItemId;
    }
}
