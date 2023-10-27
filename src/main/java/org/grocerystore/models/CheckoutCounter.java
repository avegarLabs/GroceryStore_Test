package org.grocerystore.models;

import java.util.*;
import java.util.stream.Collectors;

import static org.grocerystore.enums.TypeOfSale.PER_PIECE;
import static org.grocerystore.enums.TypeOfSale.PER_WEIGHT;

public class CheckoutCounter {
    private Map<Product, Double> scannedProducts;
    private List<Product> productList = new ArrayList<>();

    public CheckoutCounter() {
        this.scannedProducts = new HashMap<>();
    }

     public void scanProduct(Product product) {
        if (product.getType() != PER_PIECE) {
            throw new IllegalArgumentException("This method is only for products sold by piece!");
        }
        filterProductsByCode(product);
        System.out.println("Update $totalPrice: " + calculateTotalPrice());
    }

    private void filterProductsByCode(Product product) {
        productList.add(product);
        scannedProducts = new HashMap<>();
        List<String> codes = productList.stream().map(Product::getCode).collect(Collectors.toSet()).stream().toList();
        codes.forEach(code -> {
            var item = productList.parallelStream().filter(p -> p.getCode().equals(code)).findFirst().get();
            int count = productList.parallelStream().filter(p -> p.getCode().equals(code)).toList().size();
            scannedProducts.put(item, (double) count);
        });
    }

    public void scanProductByWeight(Product product, double weight) {
        if (product.getType() != PER_WEIGHT) {
            throw new IllegalArgumentException("This method is only for products sold by weight!");
        }
        scannedProducts.put(product, weight);
        System.out.println("Update $totalPrice: " + calculateTotalPrice());
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Product, Double> entry : scannedProducts.entrySet()) {
            Product product = entry.getKey();
            double quantityOrWeight = entry.getValue();

            switch (product.getType()) {
                case PER_PIECE:
                    totalPrice += calculatePriceByPromotion(product, (int) quantityOrWeight);
                    break;
                case PER_WEIGHT:
                    totalPrice += product.getPrice() * quantityOrWeight;
                    break;
            }
        }
        return totalPrice;
    }


    private double calculatePriceByPromotion(Product product, int quantity) {
        double price = product.getPrice() * quantity;
        switch (product.getPromotion()) {
            case BUY_ONE_GET_ONE_FREE:
                price = product.getPrice() * (quantity - (quantity / 2));
                break;
            case BUY_TWO_GET_ONE_FREE:
                price = product.getPrice() * (quantity - (quantity / 3));
                break;
        }
        return price;
    }
}

