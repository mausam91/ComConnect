/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.persistence;

import com.mausamcon.comconnect.model.SuperStore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;

public interface SuperStoreRepository extends MongoRepository<SuperStore,String> {
  Collection<SuperStore>  findALlByNameContains(String name);

  @Query("{'address.state':{$eq: '?0'}}")
  Collection<SuperStore>  findAllByOrdersByState(String state);
}
