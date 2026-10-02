package session5.practice.p3;

import java.util.Arrays;

public class LibraryMemberWithFines {
    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) total += fineHistory[i];
        return total;
    }
}

public class StudentMemberWithFine extends LibraryMemberWithFines {
    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}