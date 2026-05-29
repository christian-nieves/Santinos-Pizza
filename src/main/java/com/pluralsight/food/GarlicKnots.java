package com.pluralsight.food;

public class GarlicKnots {
    private double price;

    // Constructor
    public GarlicKnots() {
        this.price = 1.50; // garlic knots are always $1.50
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
