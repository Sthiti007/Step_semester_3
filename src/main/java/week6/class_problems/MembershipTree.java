package session5.practice.p2;

import session5.practice.p1.LibraryMember;
import session5.practice.p1.StudentMember;

public class HonorsStudentMember extends StudentMember {
    private int bonusLimit;

    public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public void displayInfo() {
        System.out.println("Honors Student Member | Course: " + getCourse() + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + getBooksBorrowed());
    }
}

public class FacultyMember extends LibraryMember {
    private String department;

    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    public void displayInfo() {
        System.out.println("Faculty Member | Department: " + department + " | Books Borrowed: " + getBooksBorrowed());
    }
}

public class MembershipUtils {
    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof StudentMember || member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }
        return "Base Member";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        if (members != null) {
            for (LibraryMember m : members) {
                if (m != null) total += m.getBooksBorrowed();
            }
        }
        return total;
    }
}