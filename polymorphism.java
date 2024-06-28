class BankAccount {
    protected String owner;
    protected double balance;

    // Constructor to initialize owner and balance
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    // Method to deposit an amount to the balance
    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    // Method to withdraw an amount from the balance
    public double withdraw(double amount) {
        // Check if there are sufficient funds
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return balance;
        }
        balance -= amount;
        return balance;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor to initialize owner, balance, and interest rate
    public SavingsAccount(String owner, double balance, double interestRate) {
        super(owner, balance);
        this.interestRate = interestRate;
    }

    // Method to apply interest to the balance
    public void applyInterest() {
        balance += balance * interestRate;
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    // Constructor to initialize owner, balance, and overdraft limit
    public CheckingAccount(String owner, double balance, double overdraftLimit) {
        super(owner, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Overridden method to withdraw an amount considering the overdraft limit
    @Override
    public double withdraw(double amount) {
        // Check if the amount exceeds the balance plus overdraft limit
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
        // Create an array of BankAccount objects, including SavingsAccount and CheckingAccount
        BankAccount[] accounts = {
            new SavingsAccount("Alice", 1000, 0.01),  // Savings account for Alice with interest rate 0.01
            new CheckingAccount("Bob", 500, 500)     // Checking account for Bob with overdraft limit 500
        };

        // Iterate over the array of accounts
        for (BankAccount account : accounts) {
            // Call the withdraw method on each account
            // This demonstrates polymorphism as the appropriate method is called based on the object type
            System.out.println(account.withdraw(100));  // Calls the overridden method in each subclass
        }
    }
}
