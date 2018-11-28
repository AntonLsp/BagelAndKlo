package restaurant;

public class CloseBillOp implements Operation {

    public void doOperation(Restaurant restaurant){
        String customerName = restaurant.getInputSystem().requestTextInput("CUSTOMER : ", restaurant.getDisplay());
        Bill bill = restaurant.getBill(customerName);
        if(bill == null){
            restaurant.getDisplay().failedOperation("Unknown customer.");
        }
        else{
            restaurant.getDisplay().show("FINAL BILL : ");
            restaurant.getDisplay().show( bill.toString() );
            restaurant.getDisplay().show("CLOSING BILL...");
        }
        restaurant.removeBill(customerName);
        restaurant.getDisplay().successOperation();
    }

    public void doAutoOperation(Restaurant restaurant, String command){
        String[] split = command.split(" ");
        if(split.length < 1) throw new IllegalArgumentException();
        String customerName = split[0];
        Bill bill = restaurant.getBill(customerName);
        if(bill == null){
            restaurant.getDisplay().failedOperation("Unknown customer.");
        }
        else{
            restaurant.getDisplay().show("FINAL BILL : ");
            restaurant.getDisplay().show(bill.toString());
            restaurant.getDisplay().show("CLOSING BILL...");
        }
        restaurant.removeBill(customerName);
        restaurant.getDisplay().successOperation();
    }

    public String getDescription(){
        return "Close and show a customer's bill.";
    }

    public String toString(){
        return "CLOSE";
    }
}
