package org.example;

    public class DeliveryPizza extends Pizza {
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
            DeliveryPizza pizza = new DeliveryPizza(toppings, "123 Pizza Lane", toppings.length);
            System.out.println(pizza);
        }
    }


