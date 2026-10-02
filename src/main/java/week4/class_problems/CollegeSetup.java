package session4.class_problems;

public class CollegeSetup {
    static class SrmStudent {
        static String collegeName;
        static String academicYear;
        String name;

        static {
            collegeName = "SRM";
            academicYear = "2026";
            System.out.println("College info loaded");
        }

        public SrmStudent(String name) {
            this.name = name;
            System.out.println("Student record created: " + this.name);
        }
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};
        for (String name : names) {
            new SrmStudent(name);
        }
    }
}