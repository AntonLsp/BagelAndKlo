package restaurant.operation;

import restaurant.Bill;
import restaurant.Display;
import restaurant.ProductNotFoundException;
import restaurant.Restaurant;

import java.util.List;

public class AddToBillOp implements Operation{

    public void doOperation(Restaurant restaurant){
        String customerName = restaurant.getInputSystem().requestTextInput("CUSTOMER : ", restaurant.getDisplay());
        String productName = restaurant.getInputSystem().requestTextInput("PRODUCT : ", restaurant.getDisplay());
        addToBill(restaurant,customerName,productName,restaurant.getTva(),restaurant.getDisplay());
    }

    private void addToBill(Restaurant restaurant, String customerName, String productName, float TVA, Display display)
    {
        List<Bill> bills = restaurant.getBills();
        // On récupère la note du client customerName si elle existe déjà
        Bill b = null;
        for(int i = 0; i < bills.size() ; i++)
        {
            if(bills.get(i).getCustomerName().equals(customerName)) b = bills.get(i);
        }
        // Sinon, on en crée une nouvelle
        if(b == null) {
            String question = restaurant.getInputSystem().requestTextInput(customerName + " DOES NOT EXISTS. CREATE NEW BILL ?",display);
            if(!question.contains("Y")) return;
            b = new Bill(customerName,TVA);
            bills.add(b);
        }
        // On essaie d'ajouter le produit productName à la note (s'il n'existe / est en stock)
        try{
            b.add(productName,restaurant.getInventory());
            display.successOperation();
        }
        catch (ProductNotFoundException p){
            display.failedOperation("The product is unavailable.");
        }
    }

    public String getDescription(){
        return "Add a product to a customer's bill.";
    }

    public String toString(){
        return "ADD";
    }

}
