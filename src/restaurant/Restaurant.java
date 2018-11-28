package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private Display display;
    private List<Bill> bills = new ArrayList<Bill>();
    private Inventory inventory = new Inventory();
    private Input input;

    private float tva;

    private float revenue;
    private float totalTVA;

    public Restaurant(){
        tva = 0.2f;
        revenue = 0;
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

    public Inventory getInventory(){
        return this.inventory;
    }

    public List<Bill> getBills(){
        return bills;
    }

    public Bill getBill(String name){
        for(int i = 0; i < bills.size() ; i++){
            if(bills.get(i).getCustomerName().equals(name)) return bills.get(i);
        }
        return null;
    }

    public void removeBill(String name){
        for(int i = 0; i < bills.size() ; i++){
            if(bills.get(i).getCustomerName().equals(name)){
                revenue += bills.get(i).getTaxFreePrice();
                bills.remove(i);
            }
        }
    }

    public float taxFreeRevenue(){
        return revenue;
    }

    public float getTva()
    {
        return tva;
    }

}
