package restaurant;

import logger.src.logger.Logger;

import java.util.List;

public class Restaurant {
    private Display display;
    private List<Bill> bills;
    private Inventory inventory;

    private float money;
    private float totalTVA;

    public Restaurant(){
        money = 0;
        totalTVA = 0;
    }

    public void setDisplay(Display display){
        this.display = display;
    }

    public void listProducts(){
        display.show("Produits disponibles : \n" + inventory.toString());
    }

    public void addToBill(String customerName, String productName, float TVA){
        // On vérifie
        Bill b = null;
        for(int i = 0; i < bills.size() ; i++)
        {
            if(bills.get(i).getCustomerName() == customerName) b = bills.get(i);
        }
        if(b == null) b = new Bill(customerName,TVA);
        try{
            b.add(productName,inventory);
            display.successOperation();
        }
        catch (ProductNotFoundException p){
            display.failedOperation("The product is unavailable.");
        }
    }

    public boolean run()
    {
        display.title();

    }

}
