package org.grocerystore.salespromotion.buytwogetonefree;

import org.grocerystore.salespromotion.SalesPromotion;

public class BuyTwoGetOneFree implements SalesPromotion {
    @Override
    public double applyDiscount(double quantity) {
        return quantity >= 2 ? (quantity - 1) : quantity;
    }

    @Override
    public String getDescription() {
        return "Buy 2 Get 1 Free";
    }
}
