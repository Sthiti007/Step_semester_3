package session5.practice.p5;

public class LibraryMemberAudited {
    private static int membersEnrolledCount = 0;
    private final String memberNumber;
    private int booksBorrowed = 0;

    public LibraryMemberAudited(int borrowLimit) {
        membersEnrolledCount++;
        this.memberNumber = "LIB-" + (100 + membersEnrolledCount);
    }

    public void borrowBook() {
        booksBorrowed++;
    }

    public void borrowBook(String genre) {
        borrowBook(); // Reusing no-arg version
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) return false;
        if (code.charAt(0) != 'R') return false;
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) return false;
        if (!Character.isUpperCase(code.charAt(3))) return false;
        return true;
    }

    public static int getMembersEnrolled() {
        return membersEnrolledCount;
    }
}