package org.launchcode.capstoneproject.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Size(min = 5, message = "Password must be more than 5 characters")
    @NotNull(message = "Please type your password")
    private String password;

    @NotNull(message = "Please type your username")
    private String username;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    //Constructors
    public User() {}
    public User(String password, String username) {
        this.username = username;
        this.password = password;
    }

    //Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public long getId() { return id; }

    //Setters
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

}
