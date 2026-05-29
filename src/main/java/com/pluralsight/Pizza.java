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
        this.toppings = new ArrayList<>(); // makes topping list
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

    // Methods
    public void addTopping (Topping topping) {
        toppings.add(topping); // adds topping to toppings list
    }

    public double getPrice() {


        // pizza price based on size
        double total = 0;
        if (size.equalsIgnoreCase("small")) {
            total = 8.50;
        } else if (size.equalsIgnoreCase("medium")) {
            total = 12.00;
        } else if (size.equalsIgnoreCase("large")) {
            total = 16.50;
        }

        // add topping prices based on size
        int toppingAmount = 0;
        if (size.equalsIgnoreCase("small")) {
            toppingAmount = 8;
        } else if (size.equalsIgnoreCase("medium")) {
            toppingAmount = 12;
        } else if (size.equalsIgnoreCase("large")) {
            toppingAmount = 16;
        }

        // adds each topping price to total price
        for (Topping topping : toppings) {
            total += topping.getPrice(toppingAmount);
        }

        return total;
    }

    @Override
    public String toString() {
        return "Size: " + size + "\nCrust: " + crust + "\nStuffed Crust: " + stuffedCrust + "\nToppings: " + toppings;
    }

}
