package restaurant.operation;

import restaurant.Restaurant;

public class NewProductOp implements Operation {

    public void doOperation(Restaurant restaurant){
        String productName = restaurant.getInputSystem().requestTextInput("PRODUCT NAME : ",restaurant.getDisplay());
        float price = 0;
        if(restaurant.getInventory().exists(productName)){
            restaurant.getDisplay().productFound();
        }
        else{
            price = restaurant.getInputSystem().requestFloatInput("PRICE : ",restaurant.getDisplay());
        }
        int quantity = restaurant.getInputSystem().requestIntegerInput("QUANTITY : ",restaurant.getDisplay());
        restaurant.getInventory().add(productName,price,quantity);
    }

    public String getDescription(){
        return "Add a product to the restaurant's inventory.";
    }

    public String toString()
    {
        return "NEW";
    }
}
