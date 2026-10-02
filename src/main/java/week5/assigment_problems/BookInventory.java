package session6.assignment;

public class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public void checkOut() {
        if (this.copiesAvailable > 0) {
            this.copiesAvailable--;
        }
    }

    public void checkIn() {
        if (this.copiesAvailable < this.copiesTotal) {
            this.copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return this.copiesAvailable;
    }
}