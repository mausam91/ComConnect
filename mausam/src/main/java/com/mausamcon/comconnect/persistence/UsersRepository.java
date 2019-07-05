/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.persistence;
import com.mausamcon.comconnect.model.UserType;
import com.mausamcon.comconnect.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UsersRepository extends MongoRepository <Users,String> {
Collection<Users> findALlByFirstNameContains(String firstName);
Collection<Users> findALlByLastNameContains(String lastName);
Collection<Users> findAllByUserType(UserType userType);
Collection<Users> findAllByUserTypeAndFirstNameStartsWith(UserType userType,String firstName);
@Query("{'address.state' : {$eq : '?0'}}")
Collection<Users>  findAllByUsersByState(String state);
}
