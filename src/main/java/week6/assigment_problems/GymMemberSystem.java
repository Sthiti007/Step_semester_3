package session5.assignment.p2;

import session5.assignment.p1.GymMember;
import session5.assignment.p1.PremiumMember;

public class EliteMember extends PremiumMember {
    private String lockerNumber;

    public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Elite Member | Trainer: " + getTrainerName() + " | Locker: " + lockerNumber + " | Sessions: " + getSessionsAttended());
    }
}

public class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }
}

public class GymUtils {
    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) return "Multilevel descendant (3 generations deep)";
        else if (member instanceof PremiumMember || member instanceof GroupClassMember) return "Hierarchical sibling (independent branch)";
        return "Base Member";
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        if (members != null) {
            for (GymMember m : members) {
                if (m != null) total += m.getSessionsAttended();
            }
        }
        return total;
    }
}