package org.grocerystore.salespromotion;

public interface SalesPromotionStrategy {
    double applyDiscount(double quantityOrWeight);
    String getDescription();
}
