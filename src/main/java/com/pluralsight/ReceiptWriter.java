package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    // Method
    public void saveOrder(Order order) {
        try {
            File folder = new File("receipts"); // create receipts folder if it doesn't exist

            if (!folder.exists()) {
                folder.mkdir();
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String fileName = "receipts/" + order.getOrderDate().format(formatter) + ".txt";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            bufferedWriter.write("╔════════════════════════════════════╗");
            bufferedWriter.newLine();
            bufferedWriter.write("║       SANTINO'S PIZZA RECEIPT      ║");
            bufferedWriter.newLine();
            bufferedWriter.write("╚════════════════════════════════════╝");
            bufferedWriter.newLine();
            bufferedWriter.write("  Order Date: " + order.getOrderDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")));
            bufferedWriter.newLine();
            bufferedWriter.write("======================================");
            bufferedWriter.newLine();

            // Pizzas
            int pizzaCount = 1;
            for (Pizza pizza : order.getPizzas()) {
                bufferedWriter.write("  PIZZA #" + pizzaCount);
                bufferedWriter.newLine();

                bufferedWriter.write("  Size:         " + pizza.getSize());
                bufferedWriter.newLine();

                bufferedWriter.write("  Crust:        " + pizza.getCrust());
                bufferedWriter.newLine();

                bufferedWriter.write("  Stuffed Crust: " + (pizza.getStuffedCrust() ? "Yes" : "No"));
                bufferedWriter.newLine();

                bufferedWriter.write("  Toppings:");
                bufferedWriter.newLine();
                for (Topping topping : pizza.getToppings()) {
                    bufferedWriter.write("    - " + topping.getName());
                    bufferedWriter.newLine();
                }

                bufferedWriter.write(String.format("  Price:        $%.2f", pizza.getPrice()));
                bufferedWriter.newLine();

                bufferedWriter.write("-------------------------------------");
                bufferedWriter.newLine();
                pizzaCount++;
            }

            // Drinks
            if (!order.getDrinks().isEmpty()) {
                bufferedWriter.write("  DRINKS");
                bufferedWriter.newLine();
                for (Drink drink : order.getDrinks()) {
                    bufferedWriter.write("  " + drink.getFlavor() + " (" + drink.getSize() + ") - $" + String.format("%.2f", drink.getPrice()));
                    bufferedWriter.newLine();
                }
                bufferedWriter.write(" -------------------------------------");
                bufferedWriter.newLine();
            }

            // Garlic Knots
            if (!order.getGarlicKnots().isEmpty()) {
                bufferedWriter.write("  GARLIC KNOTS x" + order.getGarlicKnots().size());
                bufferedWriter.write(" - $" + String.format("%.2f", order.getGarlicKnots().get(0).getPrice() * order.getGarlicKnots().size()));
                bufferedWriter.newLine();

                bufferedWriter.write("--------------------------------------");
                bufferedWriter.newLine();
            }

            bufferedWriter.write("======================================");
            bufferedWriter.newLine();

            bufferedWriter.write(String.format("  TOTAL:        $%.2f", order.getTotal()));
            bufferedWriter.newLine();

            bufferedWriter.write("======================================");
            bufferedWriter.newLine();

            bufferedWriter.write("  Thank you for choosing Santino's!");
            bufferedWriter.newLine();

            bufferedWriter.write("======================================");
            bufferedWriter.newLine();

            bufferedWriter.close();
            System.out.println("Receipt Saved Successfully!");

        } catch (Exception e) {
            System.err.println("An error occurred. Please try again.");
        }
    }



}
