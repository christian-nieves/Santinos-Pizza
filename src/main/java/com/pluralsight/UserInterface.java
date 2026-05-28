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

                    break;
                case "2":

                    break;
                case "3":

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


}
