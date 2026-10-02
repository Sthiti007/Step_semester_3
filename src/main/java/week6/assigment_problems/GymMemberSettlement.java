package session5.assignment.p5;

public class GymMemberSettlement {
    private static int membersEnrolledCount = 0;
    private final String membershipNumber;
    private int feesPaidTotal = 0;

    public GymMemberSettlement(int monthlyFee) {
        membersEnrolledCount++;
        this.membershipNumber = "GYM-" + (2000 + membersEnrolledCount);
    }

    public void payFee(int amount) {
        feesPaidTotal += amount;
    }

    public void payFee(int amount, String mode) {
        payFee(amount); // Delegation
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) return false;
        if (code.charAt(0) != 'G') return false;
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) return false;
        if (!Character.isUpperCase(code.charAt(3))) return false;
        return true;
    }

    public static int getMembersEnrolled() {
        return membersEnrolledCount;
    }
}