package org.launchcode.capstoneproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Campground {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=50)
    private String name;

    @NotNull
    @Size(min=3, max=50)
    private String location;

    @NotNull
    private int price;

    //Constructors
    public void Campground() {}
    public void Campground(String name, String location, int price) {
        this.name = name;
        this.location = location;
        this.price = price;
    }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getPrice() { return price; }

    //Setters
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setPrice(int price) { this.price = price; }
}
