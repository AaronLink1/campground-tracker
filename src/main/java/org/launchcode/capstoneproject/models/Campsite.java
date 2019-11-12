package org.launchcode.capstoneproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Campsite {
    @Id
    @GeneratedValue()
    private int id;

    @NotNull
    @Size(min=3, max=50)
    private String name;

    @NotNull
    @Size(min=3, max=50)
    private String location;

    //Constructors
    public void Campsite() {}
    public void Campsite(String name, String location) {
        this.name = name;
        this.location = location;
    }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }

    //Setters
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
}
