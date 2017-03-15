/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pox_foodmenu.ajain95.netbeans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author archjain
 */
@XmlRootElement(name = "InvalidMessage")
public class IncorrectInput {
    private String xmlns;

    public IncorrectInput(){
        
    }
    public IncorrectInput(String xmlns){
        this.xmlns=xmlns;
    }
    public String getXmlns() {
        return xmlns;
    }
    @XmlAttribute (name="xmlns")
    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }
}
