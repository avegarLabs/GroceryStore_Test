package org.grocerystore;

import org.grocerystore.enums.Promotion;
import org.grocerystore.models.CheckoutCounter;
import org.grocerystore.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.grocerystore.enums.Promotion.BUY_ONE_GET_ONE_FREE;
import static org.grocerystore.enums.Promotion.NONE;
import static org.grocerystore.enums.TypeOfSale.PER_PIECE;
import static org.grocerystore.enums.TypeOfSale.PER_WEIGHT;

public class Main {
    public static void main(String[] args) {

        System.out.println("##### GROCERY STORE TEST #####");
        CheckoutCounter checkout = new CheckoutCounter();
        Product p1 = new Product("P-001", "Chips", 50, PER_PIECE, NONE);
        Product p2 = new Product("P-001", "Chips", 50, PER_PIECE, NONE);
        Product pB = new Product("P-017", "Rice (by Kg)", 50, PER_WEIGHT, NONE);
        Product pJ = new Product("P-029", "Bean (by Kg)", 40, PER_WEIGHT, NONE);
       /* Product p3 = new Product("P-004", "Rice (by Bag)", 40, PER_PIECE, BUY_ONE_GET_ONE_FREE);
        Product p4 = new Product("P-004", "Rice (by Bag)", 40, PER_PIECE, BUY_ONE_GET_ONE_FREE);
        Product p5 = new Product("P-004", "Rice (by Bag)", 40, PER_PIECE, BUY_ONE_GET_ONE_FREE);*/

        List<Product> tableList = new ArrayList<>();
        List<String> codeList = new ArrayList<>();
        //tableList.add(p1);
        //tableList.add(p2);
        tableList.add(pB);
        tableList.add(pJ);
        //tableList.add(p5);
        for (Product product : tableList) {
            checkout.scanProductByWeight(product, 2);
        }
       /* codeList = tableList.parallelStream().map(Product::getCode).collect(Collectors.toSet()).stream().toList();
        codeList.forEach(code -> {
            var product = tableList.parallelStream().filter(item -> item.getCode().equals(code)).findFirst().get();
            int count = tableList.parallelStream().filter(item -> item.getCode().equals(code)).toList().size();
            System.out.println("scanning: " + product.getName() + " - " + count + " Items" );

        });*/
    }
}