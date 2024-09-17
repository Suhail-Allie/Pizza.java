package org.example;
import java.util.Scanner;

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
                DeliveryPizza pizza = new DeliveryPizza(toppings, address, numToppings);
                System.out.println("\n" + pizza);
            } else {
                Pizza pizza = new Pizza(toppings, numToppings);
                System.out.println("\n" + pizza);
            }

            input.close();
        }
    }


