/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.persistence;

import com.mausamcon.comconnect.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface ProductsRepository extends MongoRepository<Products,String> {
    Collection<Products >  findALlByNameContains(String name);
}
