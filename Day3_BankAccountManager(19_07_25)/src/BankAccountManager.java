
public class BankAccountManager {
    private String accountHolder;
    private double balance;

    // Constructor to initialize account with name and initial balance
    public BankAccountManager(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance can't be negative. Setting to 0.");
            this.balance = 0;
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    // Method to display current balance
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: $" + balance);
    }

    // Main method to test the BankAccountManager class
    public static void main(String[] args) {
        BankAccountManager account = new BankAccountManager("John Doe", 1000);
        account.displayBalance();
        account.deposit(500);
        account.withdraw(200);
        account.withdraw(1500);  // Should show insufficient balance
        account.displayBalance();
    }
}
