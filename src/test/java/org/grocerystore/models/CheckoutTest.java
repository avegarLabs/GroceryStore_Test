package org.grocerystore.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.grocerystore.models.TypeOfSale.PER_PIECE;
import static org.grocerystore.models.TypeOfSale.PER_WEIGHT;
import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {

    private Checkout checkout;
    private Product chips;
    private Product rice;

    @BeforeEach
    void setUp() {
        checkout = new Checkout();
        chips = new Product("P-001", "Chips", 35, PER_PIECE);
        rice = new Product("P-001", "Rice", 45, PER_WEIGHT);
    }

    @Test
    void scanProduct() {
        checkout.scanProduct(chips);
        assertEquals(35, checkout.calculateTotalPrice(), 0.001);
    }

    @Test
    void calculateTotalPrice() {
        checkout.scanProduct(chips);
        checkout.scanProduct(rice);
        checkout.scanProduct(chips);

        double totalPrice = checkout.calculateTotalPrice();
        assertEquals(35 * 2 + 45, totalPrice, 0.001);
    }
}