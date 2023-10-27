package org.grocerystore.salespromotion.buytwogetonefree;

import org.grocerystore.salespromotion.SalesPromotionStrategy;

public class BuyTwoGetOneFree implements SalesPromotionStrategy {
    @Override
    public double applyDiscount(double quantity) {
        return quantity >= 2 ? (quantity - 1) : quantity;
    }

    @Override
    public String getDescription() {
        return "Buy 2 Get 1 Free";
    }
}
