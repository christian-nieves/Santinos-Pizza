package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Order order;
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void display() {
        boolean quit = false;
        while (!quit) {
            System.out.println("========== WELCOME TO SANTINO'S PIZZA ==========");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    orderScreen();
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.err.println("Invalid option. Please try again.");
            }
        }
    }

    public void orderScreen() {
        order = new Order();
        boolean quit = false;

        while (!quit) {
            System.out.println("---------- Order Screen ----------");
            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.println("Enter your choice:");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    selectPizzaScreen();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addGarlicKnots();
                    break;
                case "4":

                    break;
                case "0":
                    System.out.println("Order Cancelled.");
                    quit = true;
                    break;
                default:
                    System.err.println("Invalid option. Please try again.");
            }

        }
    }

    public void selectPizzaScreen() {
        // Select size
        String size = "";
        while (true) {
            System.out.println("---------- Add Pizza ----------");
            System.out.println("Select size: ");
            System.out.println("1) Small 8\"");
            System.out.println("2) Medium 12\"");
            System.out.println("3) Large 16\"");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                size = "small";
                break;
            } else if (choice.equals("2")) {
                size = "medium";
                break;
            } else if (choice.equals("3")) {
                size = "large";
                break;
            } else {
                System.err.println("Invalid option. Please try again.");
            }
        }

        // Select crust
        String crust = "";
        while (true) {
            System.out.println("Select crust:");
            System.out.println("1) Thin");
            System.out.println("2) Regular");
            System.out.println("3) Thick");
            System.out.println("4) Cauliflower");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                crust = "thin";
                break;
            } else if (choice.equals("2")) {
                crust = "regular";
                break;
            } else if (choice.equals("3")) {
                crust = "thick";
                break;
            } else if (choice.equals("4")) {
                crust = "cauliflower";
                break;
            } else {
                System.err.println("Invalid option. Please try again.");
            }
        }

        // Create pizza
        Pizza pizza = new Pizza(size, crust, false);

        // Select meats
        System.out.println("---------- Select Meats ----------");
        System.out.println("1) Pepperoni");
        System.out.println("2) Sausage");
        System.out.println("3) Ham");
        System.out.println("4) Bacon");
        System.out.println("5) Chicken");
        System.out.println("6) Meatball");
        System.out.println("0) Done");

        boolean addingMeats = true;
        while (addingMeats) {
            System.out.print("Enter your choice (0 when done): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": pizza.addTopping(new Meat("pepperoni", false)); break;
                case "2": pizza.addTopping(new Meat("sausage", false)); break;
                case "3": pizza.addTopping(new Meat("ham", false)); break;
                case "4": pizza.addTopping(new Meat("bacon", false)); break;
                case "5": pizza.addTopping(new Meat("chicken", false)); break;
                case "6": pizza.addTopping(new Meat("meatball", false)); break;
                case "0": addingMeats = false; break;
                default: System.err.println("Invalid option. Please try again.");
            }
        }

        // Select cheese
        System.out.println("---------- Select Cheese ----------");
        System.out.println("1) Mozzarella");
        System.out.println("2) Parmesan");
        System.out.println("3) Ricotta");
        System.out.println("4) Goat Cheese");
        System.out.println("5) Buffalo");
        System.out.println("0) Done");

        boolean addingCheese = true;
        while (addingCheese) {
            System.out.print("Enter your choice (0 when done): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": pizza.addTopping(new Cheese("mozzarella", false)); break;
                case "2": pizza.addTopping(new Cheese("parmesan", false)); break;
                case "3": pizza.addTopping(new Cheese("ricotta", false)); break;
                case "4": pizza.addTopping(new Cheese("goat cheese", false)); break;
                case "5": pizza.addTopping(new Cheese("buffalo", false)); break;
                case "0": addingCheese = false; break;
                default: System.err.println("Invalid option. Please try again.");
            }
        }

        // Select regular toppings
        System.out.println("---------- Select Toppings ----------");
        System.out.println("1) Onions");
        System.out.println("2) Mushrooms");
        System.out.println("3) Bell Peppers");
        System.out.println("4) Olives");
        System.out.println("5) Tomatoes");
        System.out.println("6) Spinach");
        System.out.println("7) Basil");
        System.out.println("8) Pineapple");
        System.out.println("9) Anchovies");
        System.out.println("0) Done");

        boolean addingToppings = true;
        while (addingToppings) {
            System.out.print("Enter your choice (0 when done): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": pizza.addTopping(new RegularTopping("onions")); break;
                case "2": pizza.addTopping(new RegularTopping("mushrooms")); break;
                case "3": pizza.addTopping(new RegularTopping("bell peppers")); break;
                case "4": pizza.addTopping(new RegularTopping("olives")); break;
                case "5": pizza.addTopping(new RegularTopping("tomatoes")); break;
                case "6": pizza.addTopping(new RegularTopping("spinach")); break;
                case "7": pizza.addTopping(new RegularTopping("basil")); break;
                case "8": pizza.addTopping(new RegularTopping("pineapple")); break;
                case "9": pizza.addTopping(new RegularTopping("anchovies")); break;
                case "0": addingToppings = false; break;
                default: System.err.println("Invalid option. Please try again.");
            }
        }

        // Select sauces
        System.out.println("---------- Select Sauce ----------");
        System.out.println("1) Marinara");
        System.out.println("2) Alfredo");
        System.out.println("3) Pesto");
        System.out.println("4) BBQ");
        System.out.println("5) Buffalo");
        System.out.println("6) Olive Oil");
        System.out.println("0) Done");

        boolean addingSauces = true;
        while (addingSauces) {
            System.out.print("Enter your choice (0 when done): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": pizza.addTopping(new Sauce("marinara")); break;
                case "2": pizza.addTopping(new Sauce("alfredo")); break;
                case "3": pizza.addTopping(new Sauce("pesto")); break;
                case "4": pizza.addTopping(new Sauce("bbq")); break;
                case "5": pizza.addTopping(new Sauce("buffalo")); break;
                case "6": pizza.addTopping(new Sauce("olive oil")); break;
                case "0": addingSauces = false; break;
                default: System.err.println("Invalid option. Please try again.");
            }
        }

        // Select sides
        System.out.println("---------- Select Sides ----------");
        System.out.println("1) Red Pepper");
        System.out.println("2) Parmesan");
        System.out.println("0) Done");

        boolean addingSides = true;
        while (addingSides) {
            System.out.print("Enter your choice (0 when done): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": pizza.addTopping(new Side("red pepper")); break;
                case "2": pizza.addTopping(new Side("parmesan")); break;
                case "0": addingSides = false; break;
                default: System.err.println("Invalid option. Please try again.");
            }
        }

        // Stuffed crust
        while (true) {
            System.out.println("Would you like stuffed crust?");
            System.out.println("1) Yes");
            System.out.println("2) No");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                pizza.setStuffedCrust(true);
                break;
            } else if (choice.equals("2")) {
                break;
            } else {
                System.err.println("Invalid option. Please try again.");
            }
        }

        order.addPizza(pizza);
        System.out.println("Pizza added successfully!");
    }

    public void addDrink() {
        // Select size
        String size = "";
        while (true) {
            System.out.println("---------- Add Drink ----------");
            System.out.println("Select size:");
            System.out.println("1) Small");
            System.out.println("2) Medium");
            System.out.println("3) Large");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                size = "small";
                break;
            } else if (choice.equals("2")) {
                size = "medium";
                break;
            } else if (choice.equals("3")) {
                size = "large";
                break;
            } else {
                System.err.println("Invalid option. Please try again.");
            }
        }

        // Select flavor
        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        order.addDrink(new Drink(size, flavor));
        System.out.println("Drink added successfully!");
    }

    public void addGarlicKnots() {
        order.addGarlicKnots(new GarlicKnots());
        System.out.println("Garlic Knots added successfully!");
    }

    public void checkOutScreen() {
        // confirm order
        if (order.getPizzas().isEmpty() && order.getDrinks().isEmpty() && order.getGarlicKnots().isEmpty()) {
            System.err.println("You must order at least one item to check out");
            return;
        }

        System.out.println("---------- Checkout ----------");
        System.out.println("Pizzas: ");
        for (Pizza pizza : order.getPizzas()) {
            System.out.println(pizza.toString());
        }
        if (!order.getDrinks().isEmpty()) {
            System.out.println("Drinks: ");
            for (Drink drink : order.getDrinks()) {
                System.out.println(drink.toString());
            }
        }
        if (!order.getGarlicKnots().isEmpty()) {
            System.out.println("Garlic Knots: ");
            for (GarlicKnots knot : order.getGarlicKnots()) {
                System.out.println(knot.toString());
            }
        }

        System.out.println("Total: $" + order.getTotal());

        System.out.println("1) Confirm");
        System.out.println("0) Cancel");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            ReceiptWriter receiptWriter = new ReceiptWriter();
            receiptWriter.saveOrder(order);
            System.out.println("Thank you for your order!");
        } else if (choice.equals("0")) {
            System.out.println("Order cancelled.");
        } else {
            System.err.println("Invalid option. Please try again.");
        }
    }

}



