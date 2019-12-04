package org.launchcode.capstoneproject.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;
    @Column(name = "active")
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
