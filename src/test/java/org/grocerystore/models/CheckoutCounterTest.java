package org.grocerystore.models;

import org.grocerystore.salespromotion.buyonegetonefree.BuyOneGetOneFree;
import org.grocerystore.salespromotion.nopromotion.NoPromotion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.grocerystore.enums.TypeOfSale.PER_PIECE;
import static org.grocerystore.enums.TypeOfSale.PER_WEIGHT;
import static org.junit.jupiter.api.Assertions.*;



class CheckoutCounterTest {

    private CheckoutCounter checkoutCounter;
    @BeforeEach
    void setUp() {
        checkoutCounter = new CheckoutCounter();
    }

    @Test
    public void testCalculateTotalPrice_PerPieceWithPromotion() {
        Product p1 = new Product("P-001", "Chips", 50, PER_PIECE, new NoPromotion());
        Product p2 = new Product("P-001", "Chips", 50, PER_PIECE, new NoPromotion());
        Product p3 = new Product("P-004", "Rice (by Bag)", 40, PER_PIECE, new BuyOneGetOneFree());
        Product p4 = new Product("P-004", "Rice (by Bag)", 40, PER_PIECE, new BuyOneGetOneFree());

        List<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);

        productList.forEach(item -> {
            checkoutCounter.scanProduct(item);
        });

        double expected = (2 * 50) + 40;
        double actual = checkoutCounter.calculateTotalPrice();

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCalculateTotalPrice_PerWeight() {
        Product pW1 = new Product("P-006", "Beans (By kg)", 20, PER_WEIGHT, new NoPromotion());
        Product pW2 = new Product("P-006", "Rice (By kg)", 10, PER_WEIGHT, new NoPromotion());
        List<Product> productList = new ArrayList<>();
        productList.add(pW1);
        productList.add(pW2);

        //As a particular case we do the test with a quantity equal to 2
        productList.forEach(item -> {
            checkoutCounter.scanProductByWeight(item, 2);
        });

        double expected = 60 ;
        double actual = checkoutCounter.calculateTotalPrice();

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCalculateTotalPrice_MixedTypes() {
        Product pPiece = new Product("P-001", "Chips", 50, PER_PIECE, new NoPromotion());
        Product pWeighted = new Product("P-006", "Beans", 20, PER_WEIGHT, new NoPromotion());

        List<Product> productList = new ArrayList<>();
        productList.add(pPiece);
        productList.add(pWeighted);

        productList.forEach(item -> {
            if(item.getType().equals(PER_PIECE)){
                checkoutCounter.scanProduct(item);
            }else{
                checkoutCounter.scanProductByWeight(item, 2.5);
            }
        });

        double expected = 100;
        double actual = checkoutCounter.calculateTotalPrice();

        assertEquals(expected, actual, 0.001);
    }


}