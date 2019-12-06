package org.launchcode.capstoneproject.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Length(min = 5)
    @NotEmpty
    private String password;

    @NotEmpty
    private String username;

    //Constructors
    public User() {}
    public User(String password, String username) {
        this.username = username;
        this.password = password;
    }

    //Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getId() { return id; }

    //Setters
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

}
