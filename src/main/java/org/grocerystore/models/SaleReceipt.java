package org.grocerystore.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SaleReceipt {
    private Map<Product, Double> itemList;
    private double totalPrice;

    public SaleReceipt(Map<Product, Double> products, double totalPrice) {
        this.itemList = products;
        this.totalPrice = totalPrice;
    }

    public void print() {
        System.out.println("-------- Receipt --------");
        for (Map.Entry<Product, Double> entry : itemList.entrySet()) {
            System.out.println(entry.getKey().getName() + " - " + entry.getValue() + " x " +entry.getKey().getPrice() + " - "  + (entry.getKey().getPrice() * entry.getValue()));
        }
        System.out.println("----- Promotions Applied ---");
        List<Product> productList = new ArrayList<>(itemList.keySet());
        productList.forEach(item -> {
            System.out.println(item.getName() + " - " + item.getPromotion().getDescription());
        });

        System.out.println("--------------------------");
        System.out.println("Total Of Sale: " + totalPrice);
    }
}
