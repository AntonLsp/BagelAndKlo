package restaurant.operation;

import restaurant.Restaurant;

public class NewProductOp implements Operation {

    public void doOperation(Restaurant restaurant){
        restaurant.getDisplay().show("Entrez le nom du produit:");
        String productName;
        restaurant.getInputSystem().getInput();
    }

    public String getDescription(){
        return "Ajoute un produit à l'inventaire.";
    }
}
