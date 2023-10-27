package org.grocerystore.salespromotion.nopromotion;

import org.grocerystore.salespromotion.SalesPromotion;

public class NoPromotion implements SalesPromotion {
    @Override
    public double applyDiscount(double quantityOrWeight) {
        return quantityOrWeight;  // No discount applied
    }

    @Override
    public String getDescription() {
        return "No Promotion";
    }
}
