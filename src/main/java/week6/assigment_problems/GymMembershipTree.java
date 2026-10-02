package session5.assignment.p1;

public class GymMember {
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended = 0;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0, rejected = 0;
        if (memberIds != null) {
            for (String id : memberIds) {
                try {
                    new GymMember(id, monthlyFee);
                    signedUp++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }
}

public class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }
}