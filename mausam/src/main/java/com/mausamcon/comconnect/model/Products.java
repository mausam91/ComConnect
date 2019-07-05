/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "products")
public class Products {

    @Id
    private String id;

    private String SKU;
    private String name;
    private String description;
    private int quantity;
    private double price;

    public Products(String SKU, String name, String description, int quantity, double price) {
        this.SKU = SKU;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getSKU() {
        return SKU;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double totalPriceOfProducts(){
        return this.quantity*this.price;
    }
}
