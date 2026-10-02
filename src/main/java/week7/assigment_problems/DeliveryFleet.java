package session7.assignment.p5;

public abstract class Drone {
    protected String id;

    public Drone(String id) {
        this.id = id;
    }

    public abstract String fly();
}

public interface Trackable {
    String getLocation();
}

public class DeliveryDrone extends Drone implements Trackable {
    public DeliveryDrone(String id) {
        super(id);
    }

    @Override
    public String fly() {
        return "Delivery drone " + id + " flying";
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}

public class ScoutDrone extends Drone {
    public ScoutDrone(String id) {
        super(id);
    }

    @Override
    public String fly() {
        return "Scout drone " + id + " flying";
    }
}

public class GroundRobot implements Trackable {
    private String id;

    public GroundRobot(String id) {
        this.id = id;
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}

public class FleetUtils {
    public static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            return ((Trackable) o).getLocation();
        }
        return "Tracking not available";
    }
}