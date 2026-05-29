package com.pluralsight.side;

import com.pluralsight.toppings.Topping;

public class Sauce extends Topping {
    public Sauce(String name) {
        super(name);
    }

    // Method
    @Override
    public double getPrice(int toppingAmount) {
        return 0; // sauces are included/free
    }
}
