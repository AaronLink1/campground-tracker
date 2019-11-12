package org.launchcode.capstoneproject.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String userName;

    @NotNull
    @Size(min=3, max=15)
    private String password;

    //Constructors
    public User() {}
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //Getters
    public String getUserName() { return userName; }
    public String getPassword() { return password; }
    public int getId() { return id; }

    //Setters
    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(String password) { this.password = password; }

}
