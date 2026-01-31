import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    BankAccount(String name, int accNo) {
        accountHolder = name;
        accountNumber = accNo;
        balance = 0.0;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    void displayDetails() {
        System.out.println("Account Holder Name: " + accountHolder);
        System.out.println("Account Number     : " + accountNumber);
        System.out.println("Account Balance    : ₹" + balance);
    }
}

public class BankingInformationSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Banking Information System =====");
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount account = new BankAccount(name, accNo);

        int choice;
        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depAmt = sc.nextDouble();
                    account.deposit(depAmt);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withAmt = sc.nextDouble();
                    account.withdraw(withAmt);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using Banking Information System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
