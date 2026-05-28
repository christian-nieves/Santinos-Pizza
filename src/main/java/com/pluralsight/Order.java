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
    public Order(List<Pizza> pizzas, List<Drink> drinks, List<GarlicKnots> garlicKnots, LocalDateTime orderDate) {
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

}
