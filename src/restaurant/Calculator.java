package restaurant;

import java.util.List;

public class Calculator {

    public float getPriceHt(List<Product> products) {
        float priceHt=0;
        for(int i=0;i<products.size();i++){
            priceHt= priceHt + products.get(i).getPrice();
        }
        return priceHt;
    }

    public float getPriceTtc(List<Product> products,float TVA){
        float priceTtc=0;
        priceTtc=getPriceHt(products)*(1+TVA);
        return priceTtc;
    }

    public float getPriceDiscount(List<Product> products, float reduction, float TVA){
        float priceDiscount=0;
        priceDiscount=getPriceTtc(products,TVA)*(1-reduction);
        return priceDiscount;
    }
}
