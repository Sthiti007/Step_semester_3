package session8.assignment.p4;

interface MembershipPlan {
    double calculateFee();
    int getMonths();
}

class MonthlyPlan implements MembershipPlan {
    public double calculateFee() { return 1000.00; }
    public int getMonths() { return 1; }
}

class QuarterlyPlan implements MembershipPlan {
    public double calculateFee() { return (1000.00 * 3) * 0.90; } // 10% off
    public int getMonths() { return 3; }
}

class AnnualPlan implements MembershipPlan {
    public double calculateFee() { return (1000.00 * 12) * 0.75; } // 25% off
    public int getMonths() { return 12; }
}

class Membership {
    private String memberName;
    private MembershipPlan plan;
    private String status; // "Active", "Frozen", "Expired"

    public Membership(String memberName, MembershipPlan plan) {
        this.memberName = memberName;
        this.plan = plan;
        this.status = "Active";
        System.out.println("Membership created for " + memberName + ". Fee: " + plan.calculateFee() + ". Status: Active.");
    }

    public String getStatus() { return status; }

    public void freeze() {
        if (status.equals("Expired")) {
            System.out.println("Cannot freeze an Expired membership.");
            return;
        }
        status = "Frozen";
        System.out.println(memberName + "'s membership frozen. Status: Frozen.");
    }

    public void checkIn() {
        if (!status.equals("Active")) {
            System.out.println("Check-in denied: Membership is " + status + ".");
            return;
        }
        System.out.println(memberName + " checked in successfully.");
    }

    public void expire() {
        status = "Expired";
        System.out.println(memberName + "'s membership expired. Status: Expired.");
    }
}