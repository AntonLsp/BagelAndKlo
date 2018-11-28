package restaurant;

public class ListProductsOp implements Operation {

    public void doOperation(Restaurant restaurant){
        Display display = restaurant.getDisplay();
        if(restaurant.getInventory().isEmpty()){
            display.show("No product available...");
        }
        else{
            display.show( "AVAILABLE PRODUCTS : \n"+ restaurant.getInventory().toString() );
        }
    }

    public void doAutoOperation(Restaurant restaurant, String command){

    }

    public String getDescription(){
        return "List all available products.";
    }

    public String toString(){
        return "LIST";
    }
}
