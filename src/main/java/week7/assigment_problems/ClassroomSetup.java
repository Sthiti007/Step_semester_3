package session7.assignment.p4;

public abstract class ClassroomDevice {
    protected String assetTag;

    public ClassroomDevice(String assetTag) {
        this.assetTag = assetTag;
    }

    public abstract String operate();
}

public interface Chargeable {
    String charge();
    String charge(int minutes);
}

public class Tablet extends ClassroomDevice implements Chargeable {
    public Tablet(String assetTag) {
        super(assetTag);
    }

    @Override
    public String operate() {
        return "Tablet " + assetTag + " displaying lesson";
    }

    @Override
    public String charge() {
        return assetTag + " charging";
    }

    @Override
    public String charge(int minutes) {
        return assetTag + " charging for " + minutes + " minutes";
    }
}