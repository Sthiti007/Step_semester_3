package session3.assigment_problems;

public class EmployeeM5 {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeM5(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        EmployeeM5 e1 = new EmployeeM5("Rahul", 40000);
        EmployeeM5 e2 = new EmployeeM5("Sneha", 45000);
        EmployeeM5 e3 = new EmployeeM5("Vikas", 42000);

        System.out.println("3 Employee objects created");
        EmployeeM5.printCompanyInfo();
    }
}