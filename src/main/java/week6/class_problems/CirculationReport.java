package session5.practice.p4;

import session5.practice.p1.LibraryMember;
import session5.practice.p1.StudentMember;

public class CirculationReport {
    public static String batchPrint(LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();
        if (members != null) {
            for (LibraryMember m : members) {
                sb.append("General | Books: ").append(m.getBooksBorrowed());
                if (m instanceof StudentMember) {
                    StudentMember sm = (StudentMember) m;
                    sb.append(" | Student | Course: ").append(sm.getCourse()).append(" [Course via downcast: ").append(sm.getCourse()).append("] ");
                }
                sb.append(" | ");
            }
        }
        return sb.toString().trim();
    }
}