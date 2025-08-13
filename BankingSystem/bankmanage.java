import java.util.*;

class Account {
    protected String name;
    protected long accountNumber;
    protected double balance;
    protected List<String> transactionHistory = new ArrayList<>();

    public Account(String name, long accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        transactionHistory.add("Account created with initial balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + "\nNew Balance: " + balance);
            System.out.println("Deposit successful\nCurrent Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + "\nNew Balance: " + balance);
            System.out.println("Withdrawal successful\nCurrent Balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }

    public void showTransactionHistory() {
        System.out.println("\nTransaction History for " + name + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String name, long accountNumber, double balance) {
        super(name, accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < 500) {
            System.out.println("Withdrawal denied. Minimum balance of 500 must be maintained.");
        } else {
            super.withdraw(amount);
        }
    }
}

public class bankmanage {
    static Map<Long, Account> accounts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void createacc() {
        System.out.print("Enter customer name: ");
        String name = sc.next();
        System.out.print("Enter 10-digit account number: ");
        long accNum = sc.nextLong();

        if (String.valueOf(accNum).length() != 10) {
            System.out.println("Invalid account number! Must be 10 digits.");
            return;
        }

        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();

        Account acc = new SavingsAccount(name, accNum, bal);
        accounts.put(accNum, acc);
        System.out.println("Account created successfully for " + name);
    }

    public static void depositcash() {
        System.out.print("Enter account number: ");
        long accNum = sc.nextLong();
        Account acc = accounts.get(accNum);

        if (acc != null) {
            System.out.print("Enter deposit amount: ");
            acc.deposit(sc.nextDouble());
        } else {
            System.out.println("Account not found!");
        }
    }

    public static void withdrawcash() {
        System.out.print("Enter account number: ");
        long accNum = sc.nextLong();
        Account acc = accounts.get(accNum);

        if (acc != null) {
            System.out.print("Enter withdrawal amount: ");
            acc.withdraw(sc.nextDouble());
        } else {
            System.out.println("Account not found!");
        }
    }

    public static void viewhistory() {
        System.out.print("Enter account number: ");
        long accNum = sc.nextLong();
        Account acc = accounts.get(accNum);

        if (acc != null) {
            acc.showTransactionHistory();
        } else {
            System.out.println("Account not found!");
        }
    }

    public static void main(String[] args) {
        int choice;
        String ch;
        do {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Withdraw Cash");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createacc();
                    break;
                case 2:
                    depositcash();
                    break;
                case 3:
                    withdrawcash();
                    break;
                case 4:
                    viewhistory();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.print("Do you want to continue? (Y/N): ");
            ch = sc.next();
        } while (ch.equalsIgnoreCase("Y"));
    }
}
