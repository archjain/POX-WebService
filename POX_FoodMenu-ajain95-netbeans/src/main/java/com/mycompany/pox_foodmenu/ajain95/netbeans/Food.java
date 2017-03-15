/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pox_foodmenu.ajain95.netbeans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author archjain
 */
public class Food {
    
    private int id;
    private String name;
    private String description;
    private String category;
    private Double price;
    private String country;
    public Food(){
        
    }
    public Food(int id,String name,String description,String category,double price,String country){
        this.id=id;
        this.name=name;
        this.description=description;
        this.category=category;
        this.price=price;
        this.country=country;
        
    }
    public int getId() {
        return id;
    }
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    @XmlAttribute
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * @param description the description to set
     */
    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    @XmlElement
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    @XmlElement
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    

}
