/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.persistence;

import com.mausamcon.comconnect.model.OrderStatus;
import com.mausamcon.comconnect.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface OrdersRepository extends MongoRepository<Orders,String> {

    Collection<Orders> findAllByOrderStatus(OrderStatus orderStatus);


    @Query("{'orderedBy.firstName' : {$eq :'?0'}}")
    Collection<Orders> findAllByOrderByUser (String orderBy);


    @Query("{'products.price' :{$lt : ?0}}")
    Collection<Orders> findAllByOrderByPriceLessThan (double price);


    @Query("{'products.quantity' :{$lt : ?0}}")
    Collection<Orders> findAllByOrderByQuantityLessThan (int quantity);

}


