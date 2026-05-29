package com.pluralsight;

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
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.garlicKnots = new ArrayList<>();
        this.orderDate = LocalDateTime.now();
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
        pizzas.add(pizza);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addGarlicKnots(GarlicKnots garlicKnots1) {
        garlicKnots.add(garlicKnots1);
    }

    public double getTotal() {
        double total = 0;

        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (GarlicKnots garlicKnot : garlicKnots) {
            total += garlicKnot.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        String orderResult =  "Order Date: " + orderDate;

        if (!pizzas.isEmpty()) {
            orderResult += "\nPizzas: " + pizzas;
        }

        if (!drinks.isEmpty()) {
            orderResult += "\nDrinks: " + drinks;
        }

        if (!garlicKnots.isEmpty()) {
            orderResult += "\nGarlic Knots: " + garlicKnots;
        }

        orderResult += "\nTotal: $" + getTotal();
        return orderResult;
    }
}
