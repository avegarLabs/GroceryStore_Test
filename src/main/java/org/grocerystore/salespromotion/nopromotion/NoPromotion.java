package org.grocerystore.salespromotion.nopromotion;

import org.grocerystore.salespromotion.SalesPromotionStrategy;

public class NoPromotion implements SalesPromotionStrategy {
    @Override
    public double applyDiscount(double quantityOrWeight) {
        return quantityOrWeight;  // No discount applied
    }

    @Override
    public String getDescription() {
        return "No Promotion";
    }
}
