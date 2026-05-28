package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    private String receiptsFolder;

    // Constructor
    public ReceiptWriter(String receiptsFolder) {
        this.receiptsFolder = "receipts/";
    }

    // Getter
    public String getReceiptsFolder() {
        return receiptsFolder;
    }

    // Method
    public void saveOrder(Order order) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
            String fileName = receiptsFolder + order.getOrderDate().format(formatter) + ".txt";

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
            System.out.println("Receipt Successfully Saved!");

        } catch (Exception e) {
            System.err.println("An error has occurred. Please try again");
        }
    }
}




}
