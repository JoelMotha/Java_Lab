import java.util.Scanner;

class Employee {
    protected int employeeId;
    protected String employeeName;
    protected String designation;

    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    public double calculateBonus() {
        return 0;
    }

    public void displayInfo() {
        System.out.println("ID: " + employeeId + ", Name: " + employeeName + ", Designation: " + designation);
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
    }
}

class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    public double calculateWeeklySalary() {
        return monthlySalary / 4;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
    }
}

class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateBonus() {
        double annualSalary = super.calculateWeeklySalary() * 4 * 12;
        return annualSalary * (bonusPercentage / 100);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bonus: $" + calculateBonus());
    }
}

public class Lab3_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Hourly Employee:");
        System.out.print("Employee ID: ");
        int hourlyId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Employee Name: ");
        String hourlyName = scanner.nextLine();
        System.out.print("Designation: ");
        String hourlyDesignation = scanner.nextLine();
        System.out.print("Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        System.out.print("Hours Worked: ");
        int hoursWorked = scanner.nextInt();
        HourlyEmployee hourlyEmp = new HourlyEmployee(hourlyId, hourlyName, hourlyDesignation, hourlyRate, hoursWorked);

        System.out.println("\nEnter details for Salaried Employee:");
        System.out.print("Employee ID: ");
        int salariedId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Employee Name: ");
        String salariedName = scanner.nextLine();
        System.out.print("Designation: ");
        String salariedDesignation = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double monthlySalary = scanner.nextDouble();
        SalariedEmployee salariedEmp = new SalariedEmployee(salariedId, salariedName, salariedDesignation, monthlySalary);

        System.out.println("\nEnter details for Executive Employee:");
        System.out.print("Employee ID: ");
        int executiveId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Employee Name: ");
        String executiveName = scanner.nextLine();
        System.out.print("Designation: ");
        String executiveDesignation = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double execMonthlySalary = scanner.nextDouble();
        System.out.print("Bonus Percentage: ");
        double bonusPercentage = scanner.nextDouble();
        ExecutiveEmployee execEmp = new ExecutiveEmployee(executiveId, executiveName, executiveDesignation, execMonthlySalary, bonusPercentage);

        System.out.println("\nHourly Employee Details:");
        hourlyEmp.displayInfo();

        System.out.println("\nSalaried Employee Details:");
        salariedEmp.displayInfo();

        System.out.println("\nExecutive Employee Details:");
        execEmp.displayInfo();

        scanner.close();
    }
}

/* DESCRIPTION
The code implements an employee management system in Java using object-oriented principles. 
It features a base class Employee with common attributes and methods, while derived classes—HourlyEmployee, 
SalariedEmployee, and ExecutiveEmployee—specialize in salary calculations and information display. 
The main method allows user input to create instances of these employee types and displays their details, 
showcasing inheritance and polymorphism.
*/

/* OUTPUT
Enter details for Hourly Employee:
Employee ID: 12
Employee Name: Joel
Designation: IT Lead
Hourly Rate: 6000
Hours Worked: 39

Enter details for Salaried Employee:
Employee ID: 11
Employee Name: Joel
Designation: IT Lead
Monthly Salary: 1235

Enter details for Executive Employee:
Employee ID: 13
Employee Name: Joel
Designation: IT Lead
Monthly Salary: 89000
Bonus Percentage: 23

Hourly Employee Details:
ID: 12, Name: Joel, Designation: IT Lead
Weekly Salary: $234000.0

Salaried Employee Details:
ID: 11, Name: Joel, Designation: IT Lead
Weekly Salary: $308.75

Executive Employee Details:
ID: 13, Name: Joel, Designation: IT Lead
Weekly Salary: $22250.0
Bonus: $245640.0
*/