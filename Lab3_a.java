import java.util.Scanner;

class Employee {
    int employeeId;
    String employeeName;
    String designation;

    Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    void displayInfo() {
        System.out.println("ID: " + employeeId + ", Name: " + employeeName + ", Designation: " + designation);
    }

    double calculateBonus() {
        return 0.0;
    }
}

class HourlyEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
    }
}

class SalariedEmployee extends Employee {
    double monthlySalary;

    SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    double calculateWeeklySalary() {
        return monthlySalary / 4;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
    }
}

class ExecutiveEmployee extends SalariedEmployee {
    double bonusPercentage;

    ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    double calculateBonus() {
        return monthlySalary * 12 * (bonusPercentage / 100);
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Annual Bonus: " + calculateBonus());
    }
}

public class Lab3_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee type (1: Hourly, 2: Salaried, 3: Executive): ");
        int employeeType = scanner.nextInt();

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();

        if (employeeType == 1) {
            System.out.print("Enter Hourly Rate: ");
            double rate = scanner.nextDouble();
            System.out.print("Enter Hours Worked: ");
            int hours = scanner.nextInt();
            HourlyEmployee emp = new HourlyEmployee(id, name, designation, rate, hours);
            emp.displayInfo();
        } else if (employeeType == 2) {
            System.out.print("Enter Monthly Salary: ");
            double salary = scanner.nextDouble();
            SalariedEmployee emp = new SalariedEmployee(id, name, designation, salary);
            emp.displayInfo();
        } else if (employeeType == 3) {
            System.out.print("Enter Monthly Salary: ");
            double salary = scanner.nextDouble();
            System.out.print("Enter Bonus Percentage: ");
            double bonusPercent = scanner.nextDouble();
            ExecutiveEmployee emp = new ExecutiveEmployee(id, name, designation, salary, bonusPercent);
            emp.displayInfo();
        } else {
            System.out.println("Invalid employee type.");
        }

        scanner.close();
    }
}

/* DESCRIPTION
Implements a payroll system for managing different employee types: Hourly, Salaried, and Executive. 
The base Employee class holds common details like employeeId, employeeName, and designation. HourlyEmployee 
and SalariedEmployee extend this class, adding specific pay attributes and methods to calculate weekly salaries. 
ExecutiveEmployee, a subclass of SalariedEmployee, includes a bonus percentage and an overridden calculateBonus method. 
In the main program, users input employee details, and the system calculates and displays weekly salaries, along with
 bonuses for executives, to provide a quick view of employee compensation.
*/

/* OUTPUT
Enter employee type (1: Hourly, 2: Salaried, 3: Executive): 1
Enter ID: 123
Enter Name: Joel
Enter Designation: IT Lead
Enter Hourly Rate: 3000
Enter Hours Worked: 60
ID: 123, Name: Joel, Designation: IT Lead
Weekly Salary: 180000.0

Enter employee type (1: Hourly, 2: Salaried, 3: Executive): 2
Enter ID: 123
Enter Name: Joel
Enter Designation: IT Lead
Enter Monthly Salary: 70000
ID: 123, Name: Joel, Designation: IT Lead
Weekly Salary: 17500.0

Enter employee type (1: Hourly, 2: Salaried, 3: Executive): 3
Enter ID: 123
Enter Name: Joel
Enter Designation: IT Lead
Enter Monthly Salary: 50000
Enter Bonus Percentage: 5000
ID: 123, Name: Joel, Designation: IT Lead
Weekly Salary: 12500.0
Annual Bonus: 3.0E7
*/