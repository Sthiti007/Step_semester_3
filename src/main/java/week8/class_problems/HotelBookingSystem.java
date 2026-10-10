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