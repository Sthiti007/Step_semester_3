package session7.practice.p5;

public abstract class DeliveryNote {
    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }
}

public class ParcelNote extends DeliveryNote {
    private String trackingId;

    public ParcelNote(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String confirmDelivery() {
        return "Parcel " + trackingId + " delivered";
    }
}

public class LetterNote extends DeliveryNote {
    private String trackingId;

    public LetterNote(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String confirmDelivery() {
        return "Letter " + trackingId + " delivered";
    }
}

public class DeliveryLogger {
    public static void logAll(DeliveryNote[] notes) {
        if (notes != null) {
            for (DeliveryNote note : notes) {
                if (note != null) {
                    System.out.println(note.confirmDelivery());
                }
            }
        }
    }
}