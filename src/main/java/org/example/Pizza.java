package org.example;

public class Pizza {

        private String[] toppings;
        double price;
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
            Pizza pizza = new Pizza(toppings, toppings.length);
            System.out.println(pizza);
        }
    }


