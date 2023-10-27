package org.grocerystore;

import org.grocerystore.models.*;
import org.grocerystore.salespromotion.buyonegetonefree.BuyOneGetOneFree;
import org.grocerystore.salespromotion.nopromotion.NoPromotion;

import java.util.ArrayList;
import java.util.List;

import static org.grocerystore.enums.TypeOfSale.PER_PIECE;
import static org.grocerystore.enums.TypeOfSale.PER_WEIGHT;

public class Main {
    public static void main(String[] args) {

        System.out.println("##### GROCERY STORE TEST #####");
        CheckoutCounter checkout = new CheckoutCounter();

        Product p1 = new Product("P-001", "Chips", 50, PER_PIECE, new NoPromotion());
        Product p2 = new Product("P-001", "Chips", 50, PER_PIECE, new NoPromotion());
        Product p3 = new Product("P-004", "Rice (by Bag)", 40, PER_PIECE, new BuyOneGetOneFree());
        Product p4 = new Product("P-004", "Rice (by Bag)", 40, PER_PIECE, new BuyOneGetOneFree());
        Product p5 = new Product("P-004", "Rice (by Bag)", 40, PER_PIECE, new BuyOneGetOneFree());

        List<Product> counter = new ArrayList<>();
        counter.add(p1);
        counter.add(p2);
        counter.add(p3);
        counter.add(p4);
        counter.add(p5);
        for (Product product : counter) {
            checkout.scanProduct(product);
        }
        SaleReceipt receipt = checkout.generateReceipt();
        receipt.print();
    }
}