-->POX_FoodMenu-ajain95-netbeans is the service and POX_Client-ajain95-netbeans is client

-->Run the function MainApp.java in client to test the response.

-->Resource url = http://localhost:8080/POX_FoodMenu-ajain95-netbeans/webresources/restservice/foodItem

--> Sevice is exposed in FoodResourceService.Java

-->The xml file is copied in \POX_FoodMenu-ajain95-netbeans\resource, please change the path of file_path variable in FoodResourceService.Java according to the physical location //line 71

--> To test getFood please uncomment line --> System.out.println(client.getFoodItem(getfoodItem)) in MainApp.java  //line 22

--> To test getFood please uncomment line --> System.out.println(client.addFood(addFoodItem)); in MainApp.java     //line 37

--> Build and deploy both the folders before testing

--> Run POX_FoodMenu-ajain95-netbeans before testing client.