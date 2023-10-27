package org.grocerystore.models;

import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private Map<Product, Integer> scannedProducts;

    public Checkout() {
        this.scannedProducts = new HashMap<>();
    }

    public void scanProduct(Product product) {
        scannedProducts.put(product, scannedProducts.getOrDefault(product, 0) + 1);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Product, Integer> entry : scannedProducts.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }
}
