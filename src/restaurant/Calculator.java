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
        for(int i=0;i<products.size();i++){
            priceTtc= priceTtc + products.get(i).getPrice();
        }
        priceTtc = (priceTtc * (1+TVA));
        return priceTtc;
    }

    public float getPriceDiscount(List<Product> products, float reduction){
        float priceDiscount=0;
        for(int i=0;i<products.size();i++){
            priceDiscount= priceDiscount + products.get(i).getPrice();
        }
        priceDiscount = (priceDiscount * (1-reduction));
        return priceDiscount;
    }
}
