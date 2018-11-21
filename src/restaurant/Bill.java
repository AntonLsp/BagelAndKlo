package restaurant;

public class Bill {

    private Product products;
    private float htPrice;
    private float ttcPrice;
    private float tvaPercentage;

    public Bill(float TVA)
    {
        this.htPrice = 0;
        this.ttcPrice = 0;
        this.tvaPercentage = TVA;
    }

    public void add(String name, Inventory inventory) throws ProductNotFoundException
    {
        try{
            Product p = inventory.grab(name);

        }
        catch (ProductNotFoundException e)
        {
            throw new ProductNotFoundException();
        }

    }

}
