import java.util.Scanner;

class ATM {
    private final int correctPin = 1234;
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int pin, double amount) {
        try {
            if (pin != correctPin) {
                throw new SecurityException("Error: Invalid PIN.");
            }

            if (amount > balance) {
                throw new IllegalArgumentException("Error: Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Current Balance: " + balance);
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(3000); // Initial balance

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        System.out.print("Withdraw Amount: ");
        double amount = scanner.nextDouble();

        atm.withdraw(pin, amount);
        scanner.close();
    }
}
