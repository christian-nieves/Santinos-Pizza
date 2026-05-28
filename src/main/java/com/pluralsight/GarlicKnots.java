package com.pluralsight;

public class GarlicKnots {
    private double price;

    // Constructor
    public GarlicKnots(double price) {
        this.price = 1.50;
    }

    // Getter
    public double getPrice() {
        return price;
    }

    // Method
    @Override
    public String toString() {
        return "GarlicKnots";
    }
}
