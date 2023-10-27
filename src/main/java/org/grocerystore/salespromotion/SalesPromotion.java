package org.grocerystore.salespromotion;

public interface SalesPromotion {
    double applyDiscount(double quantityOrWeight);
    String getDescription();
}
