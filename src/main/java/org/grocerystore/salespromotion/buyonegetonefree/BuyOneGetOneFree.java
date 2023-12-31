package org.grocerystore.salespromotion.buyonegetonefree;

import org.grocerystore.salespromotion.SalesPromotionStrategy;

public class BuyOneGetOneFree implements SalesPromotionStrategy {
    @Override
    public double applyDiscount(double quantity) {
        return  quantity > 1 ?  (quantity - 1): quantity;
    }

    @Override
    public String getDescription() {
        return "Buy 1 Get 1 Free";
    }
}
