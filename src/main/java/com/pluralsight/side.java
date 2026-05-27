package com.pluralsight;

public class side extends Topping {
    public side(String name) {
        super(name);
    }

    // Method
    @Override
    public double getPrice(int toppingAmount) {
        return 0; // sides are included/free
    }
}
