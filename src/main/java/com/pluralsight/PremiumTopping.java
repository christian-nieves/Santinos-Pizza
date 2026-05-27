package com.pluralsight;

public class PremiumTopping extends Topping {
    private String cheeseOrMeat;
    private boolean extraTopping;

    // Constructor
    public PremiumTopping(String name, String cheeseOrMeat, boolean extraTopping) {
        super(name);
        this.cheeseOrMeat = cheeseOrMeat;
        this.extraTopping = extraTopping;
    }

    // Getters and Setters
    public String getCheeseOrMeat() {
        return cheeseOrMeat;
    }

    public void setCheeseOrMeat(String cheeseOrMeat) {
        this.cheeseOrMeat = cheeseOrMeat;
    }

    public boolean isExtraTopping() {
        return extraTopping;
    }

    public void setExtraTopping(boolean extraTopping) {
        this.extraTopping = extraTopping;
    }

    // Method
    @Override
    public double getPrice(int toppingAmount) {
        return 0;
    }
}
