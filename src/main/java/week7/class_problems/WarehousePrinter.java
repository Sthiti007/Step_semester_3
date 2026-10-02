package session7.practice.p2;

public interface Printable {
    String printLabel();
}

public class PackageBox implements Printable {
    private String trackingId;

    public PackageBox(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String printLabel() {
        return "Package label: " + trackingId;
    }
}

public class Invoice implements Printable {
    private String invoiceNumber;

    public Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String printLabel() {
        return "Invoice label: " + invoiceNumber;
    }
}

public class WarehouseUtils {
    public static void printAll(Printable[] items) {
        if (items != null) {
            for (Printable item : items) {
                if (item != null) {
                    System.out.println(item.printLabel());
                }
            }
        }
    }
}