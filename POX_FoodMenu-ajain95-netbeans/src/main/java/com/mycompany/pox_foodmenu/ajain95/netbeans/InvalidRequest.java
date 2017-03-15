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
@XmlRootElement (name="InvalidMessage")
public class InvalidRequest extends SuperMessage {
    private String xmlns; 
    public InvalidRequest(){
    }
    
    public InvalidRequest(String xmlns) {
        this.xmlns = xmlns;
    }

  
    public String getXmlns() {
        return xmlns;
    }

      @XmlAttribute
    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }
}
