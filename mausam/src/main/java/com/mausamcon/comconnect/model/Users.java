/*-------------
            AUTHOR == "MAUSAM"
                            ------------*/
package com.mausamcon.comconnect.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {
    @Id
    private String id;
    @TextIndexed
    private String firstName;
    private String lastName;
    private Address address;
    private UserType userType;
    private String email;


    public Users(String firstName, String lastName, Address address, UserType userType, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.userType = userType;
        this.email = email;

    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }


}
