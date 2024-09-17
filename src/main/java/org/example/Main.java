package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Pizza
    public static class Pizza {

        private String[] toppings;
        private double price;
        private String description;

        // Constructor
        public Pizza(String[] toppings, int numToppings) {
            // Ensure we only use up to 10 toppings
            if (numToppings > 10) {
                numToppings = 10;
            }

            this.toppings = new String[numToppings];

            // Copy the toppings into the array
            for (int i = 0; i < numToppings; i++) {
                this.toppings[i] = toppings[i];
            }

            // Create the description from the toppings
            StringBuilder desc = new StringBuilder();
            for (int i = 0; i < numToppings; i++) {
                if (i > 0) {
                    desc.append(", ");
                }
                desc.append(this.toppings[i]);
            }
            this.description = desc.toString();

            // Set the price: $14 plus $2 per topping
            this.price = 14 + 2 * numToppings;
        }

        // toString method to display Pizza description and price
        @Override
        public String toString() {
            return "Pizza with toppings: " + description + "\nPrice: $" + price;
        }

        // Main method for testing
        public static void main(String[] args) {
            String[] toppings = {"Cheese", "Pepperoni", "Mushrooms", "Olives", "Bell Peppers"};
            org.example.Pizza pizza = new org.example.Pizza(toppings, toppings.length);
            System.out.println(pizza);
        }
    }

    //DeliveryPizza

    public class DeliveryPizza extends org.example.Pizza {
        private double deliveryFee;
        private String deliveryAddress;

        // Constructor
        public DeliveryPizza(String[] toppings, String address, int numToppings) {
            super(toppings, numToppings);

            // Set the delivery address
            this.deliveryAddress = address;

            // Determine the delivery fee based on the price of the pizza
            if (super.price > 18) {
                this.deliveryFee = 3.0;
            } else {
                this.deliveryFee = 5.0;
            }
        }

        // Override toString method to include delivery address and fee
        @Override
        public String toString() {
            return super.toString() + "\nDelivery Address: " + deliveryAddress + "\nDelivery Fee: $" + deliveryFee;
        }

        // Main method for testing
        public static void main(String[] args) {
            String[] toppings = {"Cheese", "Pepperoni", "Mushrooms"};
            org.example.DeliveryPizza pizza = new org.example.DeliveryPizza(toppings, "123 Pizza Lane", toppings.length);
            System.out.println(pizza);
        }
    }

    //DemoPizza
    public class DemoPizza {

        private static final String QUIT = "QUIT";
        private static final int MAX_TOPPINGS = 3;

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // Collect toppings
            String[] toppings = new String[MAX_TOPPINGS];
            int numToppings = 0;

            System.out.println("Enter up to " + MAX_TOPPINGS + " toppings. Type '" + QUIT + "' to stop:");

            while (numToppings < MAX_TOPPINGS) {
                System.out.print("Enter topping " + (numToppings + 1) + ": ");
                String topping = input.nextLine();

                if (topping.equalsIgnoreCase(QUIT)) {
                    break;
                }

                toppings[numToppings] = topping;
                numToppings++;
            }

            // Ask if the pizza is to be delivered
            System.out.print("Is the pizza to be delivered? (yes/no): ");
            boolean isDelivered = input.nextLine().equalsIgnoreCase("yes");

            // Create the appropriate Pizza object
            if (isDelivered) {
                System.out.print("Enter the delivery address: ");
                String address = input.nextLine();
                org.example.DeliveryPizza pizza = new org.example.DeliveryPizza(toppings, address, numToppings);
                System.out.println("\n" + pizza);
            } else {
                org.example.Pizza pizza = new org.example.Pizza(toppings, numToppings);
                System.out.println("\n" + pizza);
            }

            input.close();
        }
    }

}