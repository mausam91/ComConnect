/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Collections;

@Document(collection = "superstores")
public class SuperStore {
    @Id
    private String id;
    private String name;
    private Address address;
    private Collection<Products> products;

    public SuperStore(String name, Address address, Collection<Products> products) {
        this.name = name;
        this.address = address;
        if(products!= null) {
            this.products = products;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Collection<Products> getProducts() {
        return Collections.unmodifiableCollection(this.products);
    }
}
