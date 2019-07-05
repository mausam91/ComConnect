/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@Document(collection = "orders")
public class Orders {

    @Id
    private String id;

    private LocalDate orderDate;
    private Collection<Products> products = new ArrayList<>();



    @DBRef
    private PaymentOptions paymentOptions;
    @DBRef
    private SuperStore superStore;
    private OrderStatus orderStatus;
    private DeliveryInfo deliveryInfo;
    private Users orderedBy;
    @DBRef
    private Users  pickBy;

    public Orders(LocalDate orderDate, Collection<Products> products,
                  PaymentOptions paymentOptions, SuperStore superStore,
                  OrderStatus orderStatus, DeliveryInfo deliveryInfo,Users orderedBy,Users pickBy) {
        this.orderDate = orderDate;
        if (products != null) {
            this.products = products;
        }
        this.paymentOptions = paymentOptions;
        this.superStore = superStore;
        this.orderStatus = orderStatus;
        this.deliveryInfo = deliveryInfo;
        this.orderedBy=orderedBy;
        this.pickBy=pickBy;
    }

    public String getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }



    public Collection<Products> getProducts() {
        return Collections.unmodifiableCollection(this.products);
    }

    public PaymentOptions getPaymentOptions() {
        return paymentOptions;
    }

    public SuperStore getSuperStore() {
        return superStore;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public DeliveryInfo getDeliveryInfo() {
        if (orderStatus == OrderStatus.DELIVERED) {
            return deliveryInfo;
        } else {
            return null;
        }
    }

    public Users getOrderedBy() {
        return orderedBy;
    }

    public Users getPickBy() {
        return pickBy;
    }




}
