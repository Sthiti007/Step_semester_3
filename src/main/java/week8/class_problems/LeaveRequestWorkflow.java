package session8.practice.p2;

class LeaveRequest {
    private String employeeName;
    private String startDate;
    private String endDate;
    private String status; // "Pending", "Approved", "Rejected"

    public LeaveRequest(String employeeName, String startDate, String endDate) {
        this.employeeName = employeeName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending";
        System.out.println("Leave request submitted for " + employeeName + " (" + startDate + " - " + endDate + "). Status: Pending.");
    }

    public String getStatus() {
        return status;
    }

    public void approve(String managerName) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status.");
            return;
        }
        status = "Approved";
        System.out.println(managerName + " approved " + employeeName + "'s leave request. Status: Approved.");
    }

    public void reject(String managerName) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status.");
            return;
        }
        status = "Rejected";
        System.out.println(managerName + " rejected " + employeeName + "'s leave request. Status: Rejected.");
    }

    public void changeStatus(String newStatus) {
        if (status.equals("Approved") || status.equals("Rejected")) {
            System.out.println("Cannot change leave request status from " + status + " to " + newStatus + ".");
            return;
        }
        this.status = newStatus;
    }
}