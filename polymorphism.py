#Polymorphism
#Polymorphism is a core concept in object-oriented programming (OOP) that allows objects of different classes to be treated as objects of a common superclass. It provides a way to perform a single action in different forms, promoting flexibility and the ability to extend systems easily.


class BankAccount:
    def __init__(self, owner, balance=0):
        self.owner = owner
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self.balance

    def withdraw(self, amount):
        if amount > self.balance:
            return "Insufficient funds"
        self.balance -= amount
        return self.balance

    def get_balance(self):
        return self.balance

class SavingsAccount(BankAccount):
    def __init__(self, owner, balance=0, interest_rate=0.01):
        super().__init__(owner, balance)
        self.interest_rate = interest_rate

    def apply_interest(self):
        self.balance += self.balance * self.interest_rate
        return self.balance

class CheckingAccount(BankAccount):
    def __init__(self, owner, balance=0, overdraft_limit=500):
        super().__init__(owner, balance)
        self.overdraft_limit = overdraft_limit

    # Overriding the withdraw method to consider the overdraft limit
    def withdraw(self, amount):
        if amount > self.balance + self.overdraft_limit:
            return "Insufficient funds"
        self.balance -= amount
        return self.balance

# Polymorphism in action
accounts = [
    SavingsAccount("Alice", 1000),  # Creating a SavingsAccount instance
    CheckingAccount("Bob", 500)     # Creating a CheckingAccount instance
]

# Iterating through the accounts list
for account in accounts:
    # Calls the overridden withdraw method in each subclass
    print(account.withdraw(100))  
    # For SavingsAccount, it uses the withdraw method from BankAccount
    # For CheckingAccount, it uses the overridden withdraw method considering the overdraft limit
