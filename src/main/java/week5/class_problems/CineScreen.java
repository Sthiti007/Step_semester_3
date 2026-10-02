package session6.practice;

public class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public void bookSeat() {
        if (this.seatsAvailable > 0) {
            this.seatsAvailable--;
        }
    }

    public void cancelBooking() {
        if (this.seatsAvailable < this.seatsTotal) {
            this.seatsAvailable++;
        }
    }

    public int getSeatsAvailable() {
        return this.seatsAvailable;
    }
}