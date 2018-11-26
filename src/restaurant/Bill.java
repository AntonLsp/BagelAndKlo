package restaurant;

import java.util.List;

public class Bill {

    private float htPrice;
    private float ttcPrice;
    private float tvaPercentage;

    public Bill(float TVA)
    {
        this.htPrice = 0;
        this.ttcPrice = 0;
        this.tvaPercentage = TVA;
    }
    private List<Product> products;

    public void add(String name, Inventory inventory) throws ProductNotFoundException
    {
        try{
            Product p = inventory.grab(name);
            products.add(p);
        }
        catch (ProductNotFoundException e)
        {
            throw new ProductNotFoundException();
        }
    }

    public void remove(String name, Inventory inventory)
    {

    }

}
