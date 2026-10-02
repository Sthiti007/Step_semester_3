package session4.assigment_problems;

public class LibraryMembership {
    static class MembershipCard {
        static String libraryName;
        static String validUntil;
        String studentName;

        static {
            libraryName = "SRM Central Library";
            validUntil = "May 2027";
            System.out.println("Library info loaded");
        }

        public MembershipCard(String studentName) {
            this.studentName = studentName;
            System.out.println("Membership card issued: " + this.studentName);
        }
    }

    public static void main(String[] args) {
        String[] names = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};
        for (String name : names) {
            new MembershipCard(name);
        }
    }
}