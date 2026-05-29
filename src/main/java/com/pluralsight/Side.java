package com.pluralsight;

public class Side extends Topping {
    public Side(String name) {
        super(name);
    }

    // Methods
    @Override
    public double getPrice(int toppingAmount) {
        return 0; // sides are included/free
    }

}
