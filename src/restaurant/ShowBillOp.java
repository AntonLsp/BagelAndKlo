package restaurant;

public class ShowBillOp implements Operation {
    public void doOperation(Restaurant restaurant) {
        String customerName = restaurant.getInputSystem().requestTextInput("CUSTOMER : ", restaurant.getDisplay());
        Bill bill = restaurant.getBill(customerName);
        if (bill == null) {
            restaurant.getDisplay().failedOperation("Unknown customer.");
        } else {
            restaurant.getDisplay().show("CURRENT BILL : ");
            restaurant.getDisplay().show(bill.toString());
        }
    }

    public void doAutoOperation(Restaurant restaurant, String command) {

    }

    public String getDescription(){
        return "Show a customer's bill.";
    }

    public String toString()
    {
        return "SHOW";
    }
}
