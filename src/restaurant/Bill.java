package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    class BillProduct{
        Product product;
        private int count;

        public BillProduct(Product p, int count){
            this.product = p;
            this.count = count;
        }

        public void add()
        {
            count++;
        }

        public int getCount()
        {
            return count;
        }
    }

    private List<BillProduct> productList;

    private String customerName;
    private float htPrice;
    private float ttcPrice;
    private float tvaPercentage;

    public Bill(String customerName, float TVA)
    {
        this.customerName = customerName;
        this.htPrice = 0;
        this.ttcPrice = 0;
        this.tvaPercentage = TVA;
    }
    private List<Product> products;

    private BillProduct getSpecificProduct(String name)
    {
        for(BillProduct b : productList){
            if (b.product.getName() == name) return b;
        }
        return null;
    }

    public void add(String name, Inventory inventory) throws ProductNotFoundException
    {
        try{
            Product p = inventory.grab(name);
            BillProduct b = getSpecificProduct(name);
            if(b == null){
                productList.add(new BillProduct(p,1) );
            }
            else{
                b.add();
            }
        }
        catch (ProductNotFoundException e)
        {
            throw new ProductNotFoundException();
        }
    }

    public void remove(String name, Inventory inventory) throws ProductNotFoundException
    {
        for(int i=0; i<productList.size(); i++)
        {
            if(productList.get(i).product.getName() == name)
            {
                productList.remove(i);
            }
        }
        throw new ProductNotFoundException();
    }


    public String toString()
    {
        String text = customerName + " :\n";
        for(BillProduct b : productList)
        {
            text += b.product.getName() + " : " + b.getCount() + "  " + b.product.getPrice() + "\n";
        }
        return text;
    }

    public String getCustomerName(){
        return customerName;
    }

}
