package restaurant;

public class ProductStack {

    private String name;
    private float price;
    private int quantity;

    public ProductStack(String name, float price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName()
    {
        return this.name;
    }

    public float getPrice()
    {
        return this.price;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public void add(int quantity)
    {
        this.quantity += quantity;
    }

    public Product grab()
    {
        if(quantity > 0) {
            quantity--;
            return new Product(name, price);
        }
        return null; // A CHANGER
    }

}
