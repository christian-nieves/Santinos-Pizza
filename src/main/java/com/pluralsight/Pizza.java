package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String size;
    private String crust;
    private Boolean stuffedCrust;
    private List<Topping> toppings;

    // Constructor
    public Pizza(String size, String crust, Boolean stuffedCrust) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
        this.toppings = new ArrayList<>();
    }

    // Getters and Setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public Boolean getStuffedCrust() {
        return stuffedCrust;
    }

    public void setStuffedCrust(Boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }


}
