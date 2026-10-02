package session6.assignment;

import java.util.Arrays;

public final class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds != null ? Arrays.copyOf(bookIds, bookIds.length) : new String[0];
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] updatedIds = Arrays.copyOf(this.bookIds, this.bookIds.length);
        if (index >= 0 && index < updatedIds.length) {
            updatedIds[index] = newId;
        }
        return new LoanReceipt(this.memberId, updatedIds);
    }

    public static class ReferenceOnlyLoanReceipt extends LoanReceipt {
        private final String roomNumber;

        public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
            super(memberId, bookIds);
            this.roomNumber = roomNumber;
        }

        public String getRoomNumber() {
            return roomNumber;
        }
    }

    public static class CirculationLedger {
        private static String branchCode;

        static {
            branchCode = "PAGE-TURNER-CENTRAL";
        }

        public static String processNightlyCirculation(LoanReceipt[] receipts) {
            int processed = 0;
            int nullSkipped = 0;
            int refOnlyCount = 0;
            int regularCount = 0;

            if (receipts != null) {
                for (LoanReceipt receipt : receipts) {
                    if (receipt == null) {
                        nullSkipped++;
                        continue;
                    }
                    processed++;
                    if (receipt instanceof ReferenceOnlyLoanReceipt) {
                        refOnlyCount++;
                    } else {
                        regularCount++;
                    }
                }
            }
            return processed + " processed | " + nullSkipped + " null skipped | " + refOnlyCount + " reference-only | " + regularCount + " regular";
        }
    }
}