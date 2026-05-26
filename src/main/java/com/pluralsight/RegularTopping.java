package com.pluralsight;

public class RegularTopping extends Topping {
    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(int toppingAmount) {
        return 0; // Regular Toppings are included so the price is free
    }
}
