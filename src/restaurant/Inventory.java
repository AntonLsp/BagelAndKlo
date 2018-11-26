package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<ProductStack> productStacks;

    public Inventory()
    {
        this.productStacks = new ArrayList<ProductStack>();
    }

    private void removeProductStack(ProductStack productStack)
    {
        productStacks.remove(productStack);
    }

    public Product grab(String name) throws ProductNotFoundException
    {
        if(name == null) throw new ProductNotFoundException();
        for(int i = 0; i < productStacks.size() ; i++)
        {
            ProductStack ps = productStacks.get(i);
            if( ps.getName().equalsIgnoreCase(name) ){
                try{
                    Product p = ps.grab();
                    if(ps.getQuantity() <= 0 ){
                        removeProductStack(ps);
                    }
                    return p;
                }
                catch(EmptyProductStackException e){
                    throw new ProductNotFoundException();
                }
            }
        }
        throw new ProductNotFoundException();
    }

    public void remove(String name) throws ProductNotFoundException
    {
        if(name == null) throw new ProductNotFoundException();
        for(int i = 0; i < productStacks.size() ; i++)
        {
            ProductStack ps = productStacks.get(i);
            if( ps.getName().equalsIgnoreCase(name) ){
                productStacks.remove(ps);
            }
        }
        throw new ProductNotFoundException();
    }

    private void addNewProduct(String name,float price, int quantity)
    {
        ProductStack productStack = new ProductStack(name,price,quantity);
        productStacks.add(productStack);
    }

    public void add(String name, float price, int quantity)
    {
        for(int i = 0; i<productStacks.size(); i++)
        {
            String n = productStacks.get(i).getName();
            if( productStacks.get(i).getName().equals(name) ){
                productStacks.get(i).add(quantity);
                return;
            }
        }
        addNewProduct(name,price,quantity);
    }

    public boolean exists(String name)
    {
        for(int i = 0; i<productStacks.size(); i++)
        {
            String n = productStacks.get(i).getName();
            if( productStacks.get(i).getName().equals(name) ) return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return (productStacks.size() == 0);

    }

    public String toString()
    {
        String s = "";
        for(int i = 0 ; i < productStacks.size() ; i++)
        {
            s += " - " + productStacks.get(i).toString() + "\n";  
        }
        return s;
    }

}
