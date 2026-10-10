package session8.assignment.p2;

abstract class Assignment {
    String title;
    int maxMarks;
    int dueDateDay; // simplified day number representation

    public Assignment(String title, int maxMarks, int dueDateDay) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDateDay = dueDateDay;
    }

    public abstract double calculatePenalty(int submissionDay, double awardedMarks);
}

class CodingAssignment extends Assignment {
    public CodingAssignment(String title, int maxMarks, int dueDateDay) {
        super(title, maxMarks, dueDateDay);
    }

    @Override
    public double calculatePenalty(int submissionDay, double awardedMarks) {
        int lateDays = Math.max(0, submissionDay - dueDateDay);
        double penaltyRate = 0.10 * lateDays; // 10% per day late
        return Math.max(0, awardedMarks * (1.0 - penaltyRate));
    }
}

class WrittenAssignment extends Assignment {
    public WrittenAssignment(String title, int maxMarks, int dueDateDay) {
        super(title, maxMarks, dueDateDay);
    }

    @Override
    public double calculatePenalty(int submissionDay, double awardedMarks) {
        int lateDays = Math.max(0, submissionDay - dueDateDay);
        double penaltyRate = 0.20 * lateDays; // 20% per day late
        return Math.max(0, awardedMarks * (1.0 - penaltyRate));
    }
}

class Submission {
    private String studentName;
    private Assignment assignment;
    private int submissionDay;
    private String status; // "Submitted", "Graded"
    private double finalMarks;

    public Submission(String studentName, Assignment assignment, int submissionDay) {
        this.studentName = studentName;
        this.assignment = assignment;
        this.submissionDay = submissionDay;
        this.status = "Submitted";
    }

    public String getStatus() { return status; }

    public void grade(double baseMarks) {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '" + assignment.title + "' has already been graded.");
            return;
        }
        this.finalMarks = assignment.calculatePenalty(submissionDay, baseMarks);
        this.status = "Graded";
        int lateDays = Math.max(0, submissionDay - assignment.dueDateDay);
        System.out.println(studentName + " graded: " + (int)finalMarks + "/" + assignment.maxMarks + (lateDays > 0 ? " after penalty." : "") + " Status: Graded.");
    }
}