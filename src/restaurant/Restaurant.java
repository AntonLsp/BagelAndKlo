package restaurant;

import logger.src.logger.Logger;

import java.util.List;

public class Restaurant {
    private Display display;
    private List<Bill> bills;
    private Inventory inventory;
    private Input input;

    private float money;
    private float totalTVA;

    public Restaurant(){
        money = 0;
        totalTVA = 0;
    }

    public void setInputSystem(Input input){
        this.input = input;
    }

    public Input getInputSystem(){
        return input;
    }

    public void setDisplay(Display display){
        this.display = display;
    }

    public Display getDisplay(){
        return display;
    }

    public void listProducts(){
        display.show("Produits disponibles : \n" + inventory.toString());
    }

    public void addToBill(String customerName, String productName, float TVA){
        // On récupère la note du client customerName si elle existe déjà
        Bill b = null;
        for(int i = 0; i < bills.size() ; i++)
        {
            if(bills.get(i).getCustomerName() == customerName) b = bills.get(i);
        }
        // Sinon, on en crée une nouvelle
        if(b == null) {
            b = new Bill(customerName,TVA);
            bills.add(b);
        }
        // On essaie d'ajouter le produit productName à la note (s'il n'existe / est en stock)
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
        return true;
    }

}
