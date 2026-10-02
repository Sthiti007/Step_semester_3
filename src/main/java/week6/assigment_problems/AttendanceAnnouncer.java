package session5.assignment.p4;

import session5.assignment.p1.GymMember;
import session5.assignment.p1.PremiumMember;

public class AttendanceAnnouncer {
    public static String batchPrint(GymMember[] members) {
        StringBuilder sb = new StringBuilder();
        if (members != null) {
            for (GymMember m : members) {
                sb.append("Standard | Sessions: ").append(m.getSessionsAttended());
                if (m instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) m;
                    sb.append(" | Premium | Trainer: ").append(pm.getTrainerName()).append(" | Sessions: ").append(pm.getSessionsAttended()).append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("] ");
                }
                sb.append(" | ");
            }
        }
        return sb.toString().trim();
    }
}