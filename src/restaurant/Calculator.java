package restaurant;

import java.util.List;

public class Calculator {

    public float getPriceHt(List<Bill.BillProduct> products) {
        float priceHt=0;
        for(int i=0;i<products.size();i++){
            priceHt = priceHt + products.get(i).product.getPrice()*products.get(i).getCount();
        }
        return priceHt;
    }

    public float getPriceTtc(List<Bill.BillProduct> products, float TVA){
        float priceTtc=0;
        priceTtc=getPriceHt(products)*(1+TVA);
        return priceTtc;
    }

    public float getPriceDiscount(List<Bill.BillProduct> products, float reduction, float TVA){
        float priceDiscount=0;
        priceDiscount=getPriceTtc(products,TVA)*(1-reduction);
        return priceDiscount;
    }
}
