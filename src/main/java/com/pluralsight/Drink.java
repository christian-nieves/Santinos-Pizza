package com.pluralsight;

public class Drink {
    private String size;
    private String flavor;

    // Constructor
    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    // Getter and Setters

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    // Methods

    public double getPrice() {

        if (size.equalsIgnoreCase("small")) {
            return 2.00;
        }

        else if (size.equalsIgnoreCase("medium")) {
            return 2.50;
        }

        else if (size.equalsIgnoreCase("large")) {
            return 3.00;
        }

        else { System.err.println("Invalid drink size, please try again.");
            return 0; // prints red message alerting user input was invalid
        }
    }

    @Override
    public String toString() {
        return "Drink: " + flavor + "\nSize: " + size;
    }
}
