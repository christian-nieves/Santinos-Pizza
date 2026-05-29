package com.pluralsight.food;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Pizza> pizzas;
    private List<Drink> drinks;
    private List<GarlicKnots> garlicKnots;
    private LocalDateTime orderDate;

    // Constructor
    public Order() {
        this.pizzas = new ArrayList<>(); // makes pizzas list
        this.drinks = new ArrayList<>(); // makes drinks list
        this.garlicKnots = new ArrayList<>(); // makes garlic knots list
        this.orderDate = LocalDateTime.now(); // stores current time for when order is complete
    }

    // Getters
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<GarlicKnots> getGarlicKnots() {
        return garlicKnots;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    // Methods
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza); // adds pizza to order
    }

    public void addDrink(Drink drink) {
        drinks.add(drink); // adds drink to order
    }

    public void addGarlicKnots(GarlicKnots garlicKnots1) {
        garlicKnots.add(garlicKnots1); // adds garlic knots to order
    }

    public double getTotal() {
        double total = 0;

        for (Pizza pizza : pizzas) {
            total += pizza.getPrice(); // adds each pizza price to total
        }
        for (Drink drink : drinks) {
            total += drink.getPrice(); // adds each  drink price to total
        }
        for (GarlicKnots garlicKnot : garlicKnots) {
            total += garlicKnot.getPrice(); // adds each garlic knots price to total
        }
        return total;
    }

    @Override
    public String toString() {
        String orderResult =  "Order Date: " + orderDate;

        if (!pizzas.isEmpty()) { // only shows pizzas if there are any
            orderResult += "\nPizzas: " + pizzas;
        }

        if (!drinks.isEmpty()) { // only shows drinks if there are any
            orderResult += "\nDrinks: " + drinks;
        }

        if (!garlicKnots.isEmpty()) { // only shows garlic knots if there are any
            orderResult += "\nGarlic Knots: " + garlicKnots;
        }

        orderResult += "\nTotal: $" + getTotal();
        return orderResult;
    }
}
