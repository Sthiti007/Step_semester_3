package session8.assignment.p3;

import java.util.List;
import java.util.ArrayList;

interface Seat {
    String getId();
    double getPrice();
}

class RegularSeat implements Seat {
    private String id;
    public RegularSeat(String id) { this.id = id; }
    public String getId() { return id; }
    public double getPrice() { return 150.00; }
}

class PremiumSeat implements Seat {
    private String id;
    public PremiumSeat(String id) { this.id = id; }
    public String getId() { return id; }
    public double getPrice() { return 250.00; }
}

class ReclinerSeat implements Seat {
    private String id;
    public ReclinerSeat(String id) { this.id = id; }
    public String getId() { return id; }
    public double getPrice() { return 400.00; }
}

class Show {
    private List<Seat> bookedSeats = new ArrayList<>();

    public boolean isBooked(Seat seat) {
        return bookedSeats.contains(seat);
    }

    public void bookSeats(List<Seat> seats) {
        bookedSeats.addAll(seats);
    }

    public void releaseSeats(List<Seat> seats) {
        bookedSeats.removeAll(seats);
    }
}

class Booking {
    private String customerName;
    private Show show;
    private List<Seat> seats;
    private boolean active = true;

    public Booking(String customerName, Show show, List<Seat> seats) {
        this.customerName = customerName;
        this.show = show;
        this.seats = seats;
    }

    public void cancel() {
        if (active) {
            show.releaseSeats(seats);
            active = false;
            System.out.println(customerName + "'s booking cancelled. Seats released.");
        }
    }
}