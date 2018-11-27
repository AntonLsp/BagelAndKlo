package restaurant.operation;

import restaurant.Bill;
import restaurant.Restaurant;

public class CloseBillOp implements Operation {

    public void doOperation(Restaurant restaurant){
        String customerName = restaurant.getInputSystem().requestTextInput("CUSTOMER : ", restaurant.getDisplay());
        Bill bill = restaurant.getBill(customerName);
        if(bill == null){
            restaurant.getDisplay().failedOperation("Unknown customer.");
        }
        else{
            restaurant.getDisplay().show(" BILL : ");
            restaurant.getDisplay().show(bill.toString());
        }
        restaurant.removeBill(customerName);
    }

    public String getDescription(){
        return "Close and show a customer's bill.";
    }

    public String toString(){
        return "CLOSE";
    }
}
