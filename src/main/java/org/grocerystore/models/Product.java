package org.grocerystore.models;

import org.grocerystore.enums.Promotion;
import org.grocerystore.enums.TypeOfSale;

public class Product {
        private String code;
        private String name;
        private double price;
        private TypeOfSale type;
        private Promotion promotion;

    public Product(String code, String name, double price, TypeOfSale type, Promotion promotion) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.promotion = promotion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TypeOfSale getType() {
        return type;
    }

    public void setType(TypeOfSale type) {
        this.type = type;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
