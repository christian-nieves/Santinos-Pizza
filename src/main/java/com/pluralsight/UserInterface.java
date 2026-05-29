package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Order order;
    private Scanner scanner;

    private static final String GREEN = "\u001B[92m";
    public static final String BLUE = "\u001B[94m";
    public static final String RED = "\u001B[91m";
    public static final String ORANGE = "\u001B[38;5;208m";
    public static final String YELLOW = "\u001B[93m";
    private static final String RESET = "\u001B[0m";


    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void display() {
        boolean quit = false;
        while (!quit) {
            System.out.println(GREEN + "╔══════════════════════════════════╗");
            System.out.println(GREEN + "║     WELCOME TO SANTINO'S PIZZA   ║");
            System.out.println(GREEN + "╚══════════════════════════════════╝" + RESET);

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
            System.out.println(BLUE + "========== Order Screen ==========" + RESET);
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
                    checkOutScreen();
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
            System.out.println(RED + "========== Add Pizza ==========" + RESET);
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
            System.out.println(ORANGE +"---------- Select Crust ----------" + RESET);
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
        System.out.println(ORANGE + "---------- Select Meats ----------" + RESET);
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
                case "1":
                    pizza.addTopping(new Meat("pepperoni", false));
                    System.out.print("Would you like extra pepperoni? (yes/no): ");

                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        pizza.addTopping(new Meat("pepperoni", true));
                    }
                    break;
                case "2":
                    pizza.addTopping(new Meat("sausage", false));
                    System.out.print("Would you like extra sausage? (yes/no): ");

                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        pizza.addTopping(new Meat("sausage", true));
                    }
                    break;
                case "3":
                    pizza.addTopping(new Meat("ham", false));
                    System.out.print("Would you like extra ham? (yes/no): ");

                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        pizza.addTopping(new Meat("ham", true));
                    }
                    break;
                case "4":
                    pizza.addTopping(new Meat("bacon", false));
                    System.out.print("Would you like extra bacon? (yes/no): ");

                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        pizza.addTopping(new Meat("bacon", true));
                    }
                    break;
                case "5":
                    pizza.addTopping(new Meat("chicken", false));
                    System.out.print("Would you like extra chicken? (yes/no): ");

                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        pizza.addTopping(new Meat("chicken", true));
                    }
                    break;
                case "6":
                    pizza.addTopping(new Meat("meatball", false));
                    System.out.print("Would you like extra meatball? (yes/no): ");

                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        pizza.addTopping(new Meat("meatball", true));
                    }
                    break;
                case "0": addingMeats = false; break;
                default: System.err.println("Invalid option. Please try again.");
            }
        }

        // Select cheese
        System.out.println(ORANGE + "---------- Select Cheese ----------" + RESET);
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
                case "1":
                    pizza.addTopping(new Cheese("mozzarella", false));
                    System.out.print("Would you like extra mozzarella? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        pizza.addTopping(new Cheese("mozzarella", true));
                    }
                    break;
                case "2":
                    pizza.addTopping(new Cheese("parmesan", false));
                    System.out.print("Would you like extra parmesan? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        pizza.addTopping(new Cheese("parmesan", true));
                    }
                    break;
                case "3":
                    pizza.addTopping(new Cheese("ricotta", false));
                    System.out.print("Would you like extra ricotta? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        pizza.addTopping(new Cheese("ricotta", true));
                    }
                    break;
                case "4":
                    pizza.addTopping(new Cheese("goat cheese", false));
                    System.out.print("Would you like extra goat cheese? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        pizza.addTopping(new Cheese("goat cheese", true));
                    }
                    break;
                case "5":
                    pizza.addTopping(new Cheese("buffalo", false));
                    System.out.print("Would you like extra buffalo? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        pizza.addTopping(new Cheese("buffalo", true));
                    }
                    break;
                case "0": addingCheese = false; break;
                default: System.err.println("Invalid option. Please try again.");
            }
        }

        // Select regular toppings
        System.out.println(ORANGE + "---------- Select Toppings ----------" + RESET);
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
        System.out.println(ORANGE + "---------- Select Sauce ----------" + RESET);
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
        System.out.println(ORANGE + "---------- Select Sides ----------" + RESET);
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
            System.out.println(YELLOW + "========== Add Drink ==========" + RESET);
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

        System.out.println(GREEN + "========== Checkout ==========" + RESET);

        // Pizzas
        if (!order.getPizzas().isEmpty()) {
            List<Pizza> reversedPizzas = new ArrayList<>(order.getPizzas());
            Collections.reverse(reversedPizzas);
            for (Pizza pizza : reversedPizzas) {
                System.out.println("Size:          " + pizza.getSize());
                System.out.println("Crust:         " + pizza.getCrust());
                System.out.println("Stuffed Crust: " + (pizza.getStuffedCrust() ? "Yes" : "No"));
                System.out.print("Toppings:      ");
                for (int i = 0; i < pizza.getToppings().size(); i++) {
                    System.out.print(pizza.getToppings().get(i).getName());
                    if (i < pizza.getToppings().size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }

        // Drinks
        if (!order.getDrinks().isEmpty()) {
            if (order.getDrinks().size() == 1) {
                System.out.println("Drink: " + order.getDrinks().get(0).getFlavor());
            } else {
                System.out.print("Drinks: ");
                for (int i = 0; i < order.getDrinks().size(); i++) {
                    System.out.print(order.getDrinks().get(i).getFlavor());
                    if (i < order.getDrinks().size() - 1) {
                        System.out.print(", ");
                    }
                }

                System.out.println();
            }
        }

        // Garlic Knots
        if (!order.getGarlicKnots().isEmpty()) {
            System.out.println("Garlic Knots x" + order.getGarlicKnots().size());
        }

        System.out.printf("Total: $%.2f%n", order.getTotal());

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



