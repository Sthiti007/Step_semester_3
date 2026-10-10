package session8.practice.p1;

interface Vehicle {
    String getId();
    double calculateCharge(int days);
}

class Sedan implements Vehicle {
    private String id;

    public Sedan(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double calculateCharge(int days) {
        return days * 1000.0;
    }
}

class SUV implements Vehicle {
    private String id;

    public SUV(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double calculateCharge(int days) {
        return days * 1800.0;
    }
}

class Rental {
    private String customerName;
    private Vehicle vehicle;
    private int days;
    private boolean active = true;

    public Rental(String customerName, Vehicle vehicle, int days) {
        this.customerName = customerName;
        this.vehicle = vehicle;
        this.days = days;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isActive() {
        return active;
    }

    public void returnVehicle() {
        active = false;
        System.out.println(vehicle.getId() + " returned by " + customerName + ".");
    }
}
```[cite: 38]

---

### Question 2: Employee Leave Request Workflow
* **Requirements Summary**: Leave request management with strict state validations (preventing reverts once Approved or Rejected)[cite: 38, 39].

```java
package session8.practice.p2;

class LeaveRequest {
    private String employeeName;
    private String startDate;
    private String endDate;
    private String status; // "Pending", "Approved", "Rejected"

    public LeaveRequest(String employeeName, String startDate, String endDate) {
        this.employeeName = employeeName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending";
        System.out.println("Leave request submitted for " + employeeName + " (" + startDate + " - " + endDate + "). Status: Pending.");
    }

    public String getStatus() {
        return status;
    }

    public void approve(String managerName) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status.");
            return;
        }
        status = "Approved";
        System.out.println(managerName + " approved " + employeeName + "'s leave request. Status: Approved.");
    }

    public void reject(String managerName) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status.");
            return;
        }
        status = "Rejected";
        System.out.println(managerName + " rejected " + employeeName + "'s leave request. Status: Rejected.");
    }

    public void changeStatus(String newStatus) {
        if (status.equals("Approved") || status.equals("Rejected")) {
            System.out.println("Cannot change leave request status from " + status + " to " + newStatus + ".");
            return;
        }
        this.status = newStatus;
    }
}
```[cite: 38, 39]

---

### Question 3: Online Examination System
* **Requirements Summary**: Polymorphic question evaluation logic supporting Multiple Choice and True/False questions[cite: 39, 40].

```java
package session8.practice.p3;

abstract class Question {
    protected int points;

    public Question(int points) {
        this.points = points;
    }

    public abstract int evaluate(String studentAnswer);
}

class MultipleChoiceQuestion extends Question {
    private String correctAnswer;

    public MultipleChoiceQuestion(int points, String correctAnswer) {
        super(points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int evaluate(String studentAnswer) {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(int points, boolean correctAnswer) {
        super(points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int evaluate(String studentAnswer) {
        return Boolean.parseBoolean(studentAnswer) == correctAnswer ? points : 0;
    }
}
```[cite: 39, 40]

---

### Question 4: Hotel Booking System
* **Requirements Summary**: Room categories with dynamic pricing calculation and strict availability checking[cite: 40, 41].

```java
package session8.practice.p4;

abstract class Room {
    protected String roomId;

    public Room(String roomId) {
        this.roomId = roomId;
    }

    public abstract double calculatePrice(int nights);

    public String getRoomId() {
        return roomId;
    }
}

class StandardRoom extends Room {
    public StandardRoom(String roomId) {
        super(roomId);
    }

    @Override
    public double calculatePrice(int nights) {
        return nights * 1200.0;
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom(String roomId) {
        super(roomId);
    }

    @Override
    public double calculatePrice(int nights) {
        return nights * 2200.0;
    }
}
```[cite: 40, 41]

---

### Question 5: Payment Processing for a Shopping System
* **Requirements Summary**: Order validation (preventing payment on empty orders) and polymorphic payment method execution[cite: 41].

```java
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
```[cite: 41]