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
            bufferedWriter.write("Order Date: " + order.getOrderDate());
            bufferedWriter.newLine();

            bufferedWriter.write("Pizzas: ");
            bufferedWriter.newLine();

            for (Pizza pizza : order.getPizzas()) {
                bufferedWriter.write(pizza.toString());
                bufferedWriter.newLine();
            }

            if (!order.getDrinks().isEmpty()) {
                bufferedWriter.write("Drinks: ");
                bufferedWriter.newLine();

                for (Drink drink : order.getDrinks()) {
                    bufferedWriter.write(drink.toString());
                    bufferedWriter.newLine();
                }
            }

            if (!order.getGarlicKnots().isEmpty()) {
                bufferedWriter.write("Garlic Knots: ");
                bufferedWriter.newLine();

                for (GarlicKnots knot : order.getGarlicKnots()) {
                    bufferedWriter.write(knot.toString());
                    bufferedWriter.newLine();
                }
            }

            bufferedWriter.write("Total: $" + order.getTotal());
            bufferedWriter.newLine();
            bufferedWriter.close();

            System.out.println("Receipt Saved Successfully!");

        } catch (Exception e) {
            System.err.println("An error occurred. Please try again.");
        }

}




}
