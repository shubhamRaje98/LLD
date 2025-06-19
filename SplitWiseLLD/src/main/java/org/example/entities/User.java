package org.example.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    double id;
    String name;
    String email;

    public User(double id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
