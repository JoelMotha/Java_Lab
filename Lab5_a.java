interface BankInterface {
    double getBalance();
    double getInterestRate();
}

class BankA implements BankInterface {
    private double balance;

    BankA(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.0; 
    }
}

class BankB implements BankInterface {
    private double balance;

    BankB(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.4;
    }
}

class BankC implements BankInterface {
    private double balance;

    BankC(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.9;
    }
}

public class Lab5_a {
    public static void main(String[] args) {
        BankA bankA = new BankA(10000);
        BankB bankB = new BankB(150000);
        BankC bankC = new BankC(200000);

        System.out.println("Bank A:");
        System.out.println("Balance: $" + bankA.getBalance());
        System.out.println("Interest Rate: " + bankA.getInterestRate() + "%\n");

        System.out.println("Bank B:");
        System.out.println("Balance: $" + bankB.getBalance());
        System.out.println("Interest Rate: " + bankB.getInterestRate() + "%\n");

        System.out.println("Bank C:");
        System.out.println("Balance: $" + bankC.getBalance());
        System.out.println("Interest Rate: " + bankC.getInterestRate() + "%\n");
    }
}

/* DESCRIPTION
Demonstrates the use of interfaces and polymorphism to model bank
functionality. The BankInterface defines methods for retrieving a bank's
balance and interest rate. Three classes, BankA, BankB, and BankC, implement
this interface with their specific balance and interest rate values. The
Lab5_a class creates objects for each bank, retrieves their balance and
interest rate, and displays the information.
*/

/* OUTPUT
Bank A:                                                                                                                                                    
Balance: $10000.0
Interest Rate: 7.0%

Bank B:
Balance: $150000.0
Interest Rate: 7.4%

Bank C:
Balance: $200000.0
Interest Rate: 7.9%
*/