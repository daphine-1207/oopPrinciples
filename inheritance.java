//Inheritance
//Inheritance is a fundamental concept in object-oriented programming (OOP) that allows a new class to acquire the properties and behaviors (attributes and methods) of an existing class. The existing class is referred to as the "base" or "parent" class, while the new class is called the "derived" or "child" class. Inheritance promotes code reuse, modularity, and the creation of a hierarchical class structure.

class BankAccount {
    protected String owner;
    protected double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return balance;
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String owner, double balance, double interestRate) {
        super(owner, balance); // Calling the constructor of the base class
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        balance += balance * interestRate;
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String owner, double balance, double overdraftLimit) {
        super(owner, balance); // Calling the constructor of the base class
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double withdraw(double amount) { // Overriding the withdraw method
        if (amount > balance + overdraftLimit) {
            System.out.println("Insufficient funds");
            return balance;
        }
        balance -= amount;
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        // Polymorphism in action
        BankAccount[] accounts = {
            new SavingsAccount("Alice", 1000, 0.01),  // Creating an instance of SavingsAccount
            new CheckingAccount("Bob", 500, 500)      // Creating an instance of CheckingAccount
        };

        for (BankAccount account : accounts) {
            System.out.println(account.withdraw(100));  // Calls the overridden method in each subclass
        }
    }
}
