/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pox_client.ajain95.netbeans;

/**
 *
 * @author archjain
 */
public class MainApp {
   public static void main(String[] args){
    FoodClient client = new FoodClient();
  
    //get food
    String getfoodItem = "<SelectedFoodItems xmlns='http://cse564.asu.edu/PoxAssignment'>\n" +
"   <FoodItemId>100</FoodItemId>\n" +
"   <FoodItemId>156</FoodItemId>\n" +
"</SelectedFoodItems>";
    System.out.println("*****output******");
   // System.out.println(client.getFoodItem(getfoodItem));
       System.out.println("*****output******");
       
       
      //add food 
       String addFoodItem = "<NewFoodItems xmlns='http://cse564.asu.edu/PoxAssignment'>\n" +
"    <FoodItem country=\"GB\">\n" +
"        <name>dahi bada</name>\n" +
"        <description>Tender cubes of steak, potatoes and swede wrapped in flakey short crust pastry.  Seasoned with lots of pepper.  Served with mashed potatoes, peas and a side of gravy</description>\n" +
"        <category>Dinner</category>\n" +
"        <price>15.95</price>\n" +
"    </FoodItem>\n" +
"</NewFoodItems >";
       
       System.out.println("*****output******");
       System.out.println(client.addFood(addFoodItem));
       System.out.println("*****output******");
       
       
            }
}
