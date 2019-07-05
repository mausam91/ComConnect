/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

public class Cart {

    private Collection<Products> products;
    private double totalPrice;
    private LocalDate checkOutDate;

    public Cart(Collection<Products> products, double totalPrice, LocalDate checkOutDate) {
        if (products != null) {
            this.products = products;
        }
        this.totalPrice = totalPrice;
        this.checkOutDate = checkOutDate;
    }

    public Collection<Products> getProducts() {
        return Collections.unmodifiableCollection(products);
    }

    public double getTotalPrice() {
        return totalPrice;
    }


}
