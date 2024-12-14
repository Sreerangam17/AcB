class LessBalanceException extends Exception {
    public LessBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;
    private final double MIN_BALANCE = 500;

    public BankAccount(double initialBalance) {
        if (initialBalance < MIN_BALANCE) {
            System.out.println("Initial balance cannot be less than " + MIN_BALANCE + " Rs");
            balance = MIN_BALANCE;
        } else {
            balance = initialBalance;
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " Rs deposited successfully");
    }

    public void withdraw(double amount) throws LessBalanceException {
        if (balance - amount < MIN_BALANCE) {
            throw new LessBalanceException("Withdrawal of " + amount + " Rs is not valid. Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println(amount + " Rs withdrawn successfully");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Bank1 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        // Performing operations
        System.out.println("Current Balance: " + account.getBalance() + " Rs");

        try {
            account.withdraw(600);
        } catch (LessBalanceException e) {
            System.out.println(e.getMessage());
        }

        try {
            account.withdraw(400);
        } catch (LessBalanceException e) {
            System.out.println(e.getMessage());
        }

        account.deposit(700);
        System.out.println("Current Balance: " + account.getBalance() + " Rs");
    }
}