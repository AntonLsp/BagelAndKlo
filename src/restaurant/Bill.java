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

    private List<BillProduct> productList = new ArrayList<BillProduct>();

    private String customerName;
    private float htPrice;
    private float ttcPrice;
    private float tva;

    public Bill(String customerName, float TVA)
    {
        this.customerName = customerName;
        this.htPrice = 0;
        this.ttcPrice = 0;
        this.tva = TVA;
    }
    private List<Product> products;

    // Récupère un produit en particulier s'il existe déjà dans la note
    private BillProduct getSpecificProduct(String name)
    {
        for(int i = 0 ; i<productList.size() ; i++){
            if (productList.get(i).product.getName().equals(name)) return productList.get(i);
        }
        return null;
    }

    // Ajoute un produit à la note en prenant en compte s'il existe déjà dans la note
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
            if(productList.get(i).product.getName().equals(name))
            {
                productList.remove(i);
            }
        }
        throw new ProductNotFoundException();
    }


    public String toString()
    {
        Calculator calculator = new Calculator();
        String text = customerName + " :\n";
        for(BillProduct b : productList)
        {
            text += " - " + b.product.getName() + " x" + b.getCount() + " : " + b.product.getPrice()*b.getCount() + "\n";
        }
        text += "VAT : " + tva*100 + "%\n";
        text += "TAX FREE : " + calculator.getPriceHt(productList) + "\nALL TAX INCLUDED : " + calculator.getPriceTtc(productList,tva);
        return text;
    }

    public float getTaxFreePrice(){
        Calculator calculator = new Calculator();
        return calculator.getPriceHt(productList);
    }

    public float getAllTaxIncludedPrice(){
        Calculator calculator = new Calculator();
        return calculator.getPriceTtc(productList,tva);
    }

    public String getCustomerName(){
        return customerName;
    }

}
