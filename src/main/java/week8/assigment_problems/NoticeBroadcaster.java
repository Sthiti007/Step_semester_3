package session8.assignment.p5;

import java.util.List;

interface NotificationChannel {
    void send(String studentName, String message);
}

class EmailChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[Email -> " + studentName + "] " + message);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[SMS -> " + studentName + "] " + message);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String studentName, String message) {
        System.out.println("[App -> " + studentName + "] " + message);
    }
}

class Notice {
    private String title;
    private List<String> departments;

    public Notice(String title, List<String> departments) {
        if (title == null || title.isEmpty() || departments == null || departments.isEmpty()) {
            throw new IllegalArgumentException("Cannot post notice: At least one target department is required.");
        }
        this.title = title;
        this.departments = departments;
    }

    public String getTitle() { return title; }
    public List<String> getDepartments() { return departments; }
}