package org.grocerystore;

import org.grocerystore.models.*;
import org.grocerystore.salespromotion.buyonegetonefree.BuyOneGetOneFree;
import org.grocerystore.salespromotion.nopromotion.NoPromotion;

import java.util.ArrayList;
import java.util.List;

import static org.grocerystore.enums.TypeOfSale.PER_PIECE;

public class Main {
    public static void main(String[] args) {

        System.out.println("##### GROCERY STORE TEST #####");
        CheckoutCounter checkout = new CheckoutCounter();
        Product p1 = new Product("P-001", "Chips", 50, PER_PIECE, new NoPromotion());
        Product p2 = new Product("P-001", "Chips", 50, PER_PIECE, new NoPromotion());
       // Product pB = new Product("P-017", "Rice (by Kg)", 50, PER_WEIGHT, NONE);
       // Product pJ = new Product("P-029", "Bean (by Kg)", 40, PER_WEIGHT, NONE);
        Product p3 = new Product("P-004", "Rice (by Bag)", 40, PER_PIECE, new BuyOneGetOneFree());
        Product p4 = new Product("P-004", "Rice (by Bag)", 40, PER_PIECE, new BuyOneGetOneFree());
        Product p5 = new Product("P-004", "Rice (by Bag)", 40, PER_PIECE, new BuyOneGetOneFree());

        List<Product> tableList = new ArrayList<>();
        List<String> codeList = new ArrayList<>();
        tableList.add(p1);
        tableList.add(p2);
        tableList.add(p3);
        tableList.add(p4);
        //tableList.add(pB);
        //tableList.add(pJ);
        tableList.add(p5);
        for (Product product : tableList) {
            //checkout.scanProductByWeight(product, 2);
            checkout.scanProduct(product);
        }
        SaleReceipt receipt = checkout.generateReceipt();
        receipt.print();

       /* codeList = tableList.parallelStream().map(Product::getCode).collect(Collectors.toSet()).stream().toList();
        codeList.forEach(code -> {
            var product = tableList.parallelStream().filter(item -> item.getCode().equals(code)).findFirst().get();
            int count = tableList.parallelStream().filter(item -> item.getCode().equals(code)).toList().size();
            System.out.println("scanning: " + product.getName() + " - " + count + " Items" );

        });*/
    }
}