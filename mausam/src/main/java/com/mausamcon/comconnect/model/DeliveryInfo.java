/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.model;


import java.time.LocalDate;

public class DeliveryInfo {



    private LocalDate deliveryDate;
    private double deliveryFee;




    public DeliveryInfo(LocalDate deliveryDate, double deliveryFee) {
        this.deliveryDate = deliveryDate;
        this.deliveryFee = deliveryFee;

    }



    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }



}
