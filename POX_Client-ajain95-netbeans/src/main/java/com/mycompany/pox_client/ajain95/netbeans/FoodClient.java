/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pox_client.ajain95.netbeans;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;


/**
 * Jersey REST client generated for REST resource:FoodServiceResource
 * [restservice]<br>
 * USAGE:
 * <pre>
 *        FoodClient client = new FoodClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author archjain
 */
public class FoodClient {
    
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/POX_FoodMenu-ajain95-netbeans/webresources";

    public FoodClient() {
        
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("restservice/foodItem");
 
       
    }

  
      public String addFood(String foodItem)   {
           webResource.type(MediaType.TEXT_PLAIN).post(foodItem);
        WebResource resource = webResource;
        String resp = resource.accept(MediaType.APPLICATION_XML).post(String.class);
       
        
        return resp;
       
    }
      
       public String getFoodItem(String foodItem) throws UniformInterfaceException  {
        //LOG.info("Retrieving the greeting message from to the Greeting REST Server");
        webResource.type(MediaType.TEXT_PLAIN).post(foodItem);
        WebResource resource = webResource;
        String resp = resource.accept(MediaType.APPLICATION_XML).post(String.class);
      
        return resp;
    }

    public void close() {
        client.destroy();
    }
    
}
