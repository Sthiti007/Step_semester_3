package session8.practice.p5;

import java.util.Map;

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        return true; // Simulated successful payment
    }
}

class PayPalPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        return false; // Simulated failed payment
    }
}

class Order {
    private Map<String, Integer> items;
    private String status; // "Pending", "Paid"

    public Order(Map<String, Integer> items) {
        this.items = items;
        this.status = "Pending";
    }

    public boolean isEmpty() {
        return items == null || items.isEmpty();
    }

    public void pay(PaymentMethod method, double amount) {
        if (isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }
        boolean success = method.processPayment(amount);
        if (success) {
            status = "Paid";
            System.out.println("Payment successful. Order status: Paid.");
        } else {
            System.out.println("Payment failed. Order status: Pending.");
        }
    }
}