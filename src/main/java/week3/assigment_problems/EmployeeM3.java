package session3.assigment_problems;

public class EmployeeM3 {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeM3(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeM3(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        EmployeeM3 permEmp = new EmployeeM3("E-101", "Divya", 65000);
        EmployeeM3 internEmp = new EmployeeM3("E-102", "Arjun");

        permEmp.printProfile();
        internEmp.printProfile();
    }
}