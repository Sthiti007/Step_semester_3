package session6.assignment;

public class LibraryMember {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;
    private boolean idSet = false;

    public LibraryMember() {}

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (!idSet) {
            this.membershipId = id;
            this.idSet = true;
        }
        // Subsequent calls are silently ignored (write-once behavior)
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    public void setSecurityAnswer(String answer) {
        this.securityAnswer = answer != null ? "TRANSFORMED_" + answer.hashCode() : null; // One-way transform, no getter allowed.
    }
}