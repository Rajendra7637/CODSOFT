import java.util.Scanner;

// Class to represent the Bank Account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Check balance method
    public double checkBalance() {
        return balance;
    }
}

// Class to represent the ATM Machine
class ATM {
    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    // Display ATM options to the user
    public void showMenu() {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();
                
                switch (choice) {
                    case 1 -> // Check balance
                        System.out.println("Current balance: " + account.checkBalance());
                    case 2 -> {
                        // Deposit
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                    }
                    case 3 -> {
                        // Withdraw
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                    }
                    case 4 -> // Exit
                        System.out.println("Thank you for using the ATM. Goodbye!");
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } while (choice != 4);
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        // Create a BankAccount with an initial balance of 1000
        BankAccount account = new BankAccount(1000.00);

        // Create an ATM with the bank account
        ATM atm = new ATM(account);

        // Display the ATM menu
        atm.showMenu();
    }
}
