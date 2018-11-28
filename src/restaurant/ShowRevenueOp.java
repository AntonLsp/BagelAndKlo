package restaurant;

public class ShowRevenueOp implements Operation {

    public void doOperation(Restaurant restaurant){
        restaurant.getDisplay().show("Total revenue for this session : " + restaurant.taxFreeRevenue() );
    }

    public void doAutoOperation(Restaurant restaurant, String command){
        restaurant.getDisplay().show("Total revenue for this session : " + restaurant.taxFreeRevenue() );
    }

    public String getDescription(){
        return "Show the total tax free revenue.";
    }

    public String toString(){
        return "REVENUE";
    }
}
