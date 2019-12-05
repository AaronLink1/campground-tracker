package org.launchcode.capstoneproject.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Email
    @NotEmpty
    private String email;

    @Length(min = 5)
    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastName;

    private int active;

    //Constructors
    public User() {}
    public User(String email, String password, String name, String lastName, int active) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.active = active;
    }

    //Getters
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public String getPassword() { return password; }
    public int getId() { return id; }

    //Setters
    public void setEmail(String email) { this.email = email; }
    public void setName(String name) { this.name = name; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPassword(String password) { this.password = password; }
    public void setActive(int active) { this.active = active; }

}
