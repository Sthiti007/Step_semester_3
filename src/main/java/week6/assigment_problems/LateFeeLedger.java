package session5.assignment.p3;

import java.util.Arrays;

public class GymMemberFeeTracker {
    private int[] feeHistory = new int[10];
    private int feeCount = 0;

    protected void chargeLateFee(int amount) {
        if (feeCount < feeHistory.length) {
            feeHistory[feeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(feeHistory, feeCount);
    }

    public int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < feeCount; i++) total += feeHistory[i];
        return total;
    }
}

public class PremiumMemberFeeTracker extends GymMemberFeeTracker {
    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}