package com.pluralsight;

public abstract class Topping {
    private String name;

    // Constructor
    public Topping(String name) {
        this.name = name;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Method
    public abstract double getPrice(int toppingAmount);

    @Override
    public String toString() {
        return name;
    }
}
