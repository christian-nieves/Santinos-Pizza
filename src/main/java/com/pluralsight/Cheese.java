package com.pluralsight;

public class Cheese extends PremiumTopping {
    public Cheese(String name, boolean extraTopping) {
        super(name, "cheese", extraTopping);
    }

    // Method
    @Override
    public double getPrice(int toppingAmount) {
        double basePrice = 0;
        double extraPrice = 0;

        // price of cheese depending on pizza size
        if (toppingAmount == 8) {
            basePrice = 0.75;
            extraPrice = 0.30;
        } else if (toppingAmount == 12) {
            basePrice = 1.50;
            extraPrice = 0.60;
        } else if (toppingAmount == 16) {
            basePrice = 2.25;
            extraPrice = 0.90;
        }

        if (isExtraTopping()) {
            return basePrice + extraPrice; // extra charge if user wants extra cheese
        } else {
            return basePrice;
        }
    }
}
