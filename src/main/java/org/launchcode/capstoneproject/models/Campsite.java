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
    @Size(min=3, max=20)
    private String name;

    //Constructors
    public void Campsite() {}
    public void Campsite(String name) {
        this.name = name;
    }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }

    //Setters
    public void setName(String name) { this.name = name; }
}
