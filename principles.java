//Abstraction

//Encapsulation



//Polymorphism
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
        super(owner, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        balance += balance * interestRate;
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String owner, double balance, double overdraftLimit) {
        super(owner, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double withdraw(double amount) {
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
        BankAccount[] accounts = {
            new SavingsAccount("Alice", 1000, 0.01),
            new CheckingAccount("Bob", 500, 500)
        };

        for (BankAccount account : accounts) {
            System.out.println(account.withdraw(100));  // Calls the overridden method in each subclass
        }
    }
}




//Inheritance