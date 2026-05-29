package com.pluralsight.toppings;

public class Meat extends PremiumTopping {
    public Meat(String name, boolean extraTopping) {
        super(name, "meat", extraTopping);
    }

    // Method
    @Override
    public double getPrice(int toppingAmount) {
        double basePrice = 0;
        double extraPrice = 0;

        // price of meat depending on pizza size
        if (toppingAmount == 8) {
            basePrice = 1.00;
            extraPrice = 0.50;
        } else if (toppingAmount == 12) {
            basePrice = 2.00;
            extraPrice = 1.00;
        } else if (toppingAmount == 16) {
            basePrice = 3.00;
            extraPrice = 1.50;
        }

        if (isExtraTopping()) {
            return basePrice + extraPrice; // extra charge if user wants extra meat
        } else {
            return basePrice;
        }
    }
}
