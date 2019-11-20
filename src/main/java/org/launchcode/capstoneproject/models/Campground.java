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

    @NotNull
    private Boolean hasElectric;

    @NotNull
    private Boolean hasWater;

    @NotNull
    private Boolean hasDump;

    @NotNull
    private Boolean hasFacilities;

    //Constructors
    public void Campground() {}
    public void Campground(String name, String location, int price, Boolean hasElectric, Boolean hasWater,
                           Boolean hasDump, Boolean hasFacilities) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.hasElectric = hasElectric;
        this.hasWater = hasWater;
        this.hasDump = hasDump;
        this.hasFacilities = hasFacilities;
    }

    //Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getPrice() { return price; }
    public Boolean getHasElectric() { return hasElectric; }
    public Boolean getHasWater() { return hasWater; }
    public Boolean getHasDump() { return hasDump; }
    public Boolean getHasFacilities() { return hasFacilities; }

    //Setters
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setPrice(int price) { this.price = price; }
    public void setHasElectric(Boolean hasElectric) { this.hasElectric = hasElectric; }
    public void setHasWater(Boolean hasWater) { this.hasWater = hasWater; }
    public void setHasDump(Boolean hasDump) { this.hasDump = hasDump; }
    public void setHasFacilities(Boolean hasFacilities) { this.hasFacilities = hasFacilities; }
}
