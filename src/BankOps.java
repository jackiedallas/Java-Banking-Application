import java.util.Calendar;
import java.util.Scanner;

public class BankOps {

    // properties
    String customerFirstName;
    String customerLastName;
    double balance = 0;
    double previousTransaction;

    // constructor to initialize bank methods
    public BankOps(String customerFirstName, String customerLastName) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
    }

    // method to create new set up new customer
    public static void newCustomer() {

        Calendar date = Calendar.getInstance();

        int newCustomerAccountNo = (int) (Math.floor(Math.random() * 9999999) + 1000000);
        Scanner bankScanner = new Scanner(System.in);
        System.out.println("Welcome to Dallas International Bank!");
        System.out.println();
        System.out.println("Let's get started, please enter your first name:");
        String newCustomerFirstName = bankScanner.nextLine();
        System.out.println("Please enter your last name:");
        String newCustomerLastName = bankScanner.nextLine();
        System.out.println("Please enter your age:");
        int newCustomerAge = bankScanner.nextInt();

        if (newCustomerAge < 18) {
            System.out.println("You must be at least 18 years old to open an account.\n");
            newCustomer();
        }

        bankScanner.nextLine();
        BankOps customer = new BankOps(newCustomerFirstName, newCustomerLastName);
        System.out.println("Account Details");
        System.out.println();
        System.out.printf("""
                Account Number: %s
                Account Holder: %s %s
                Date Created: %tB %te, %tY%n
                """, newCustomerAccountNo, newCustomerFirstName, newCustomerLastName, date, date, date);
        customer.showMenu();

    }

    // switch statement to navigate menu
    public void showMenu() {

        Scanner menuScanner = new Scanner(System.in);
        int menuSelection;
        System.out.println("Please select from the menu below");
        System.out.println();
        System.out.println("""
                1. Deposit
                2. Withdraw
                3. Show Balance
                4. Previous Transaction
                5. Exit Bank
                """);
        menuSelection = menuScanner.nextInt();

        switch (menuSelection) {
            case 1 -> deposit();
            case 2 -> withdraw();
            case 3 -> showBalance();
            case 4 -> previousTransaction();
            case 5 -> exitBank();
            default -> {
                System.out.println("Invalid input.");
                showMenu();
            }
        }

    }

    // deposit monies method
    public void deposit() {

        Scanner depositScanner = new Scanner(System.in);
        System.out.println("Enter deposit amount:");
        double depositAmount = depositScanner.nextDouble();

        // if statement to add to balance
        if (depositAmount != 0) {
            balance += depositAmount;
            previousTransaction = depositAmount;
        }

        System.out.printf("You deposited $%.2f%n", depositAmount);
        showMenu();

    }

    // withdraw monies method
    public void withdraw() {

        Scanner withdrawalScanner = new Scanner(System.in);
        System.out.println("Enter withdrawal amount:");
        double withdrawalAmount = withdrawalScanner.nextDouble();

        if (withdrawalAmount > balance) {
            System.out.printf("Your balance of $%.2f is insufficient to complete this transaction.\nPlease deposit more money or lower the withdrawal amount.\n", balance);
            showMenu();
        } else if (balance == 0){
            System.out.println("Your account balance is $0.00, please deposit monies.");
            showMenu();
        } else {
            balance -= withdrawalAmount;
            previousTransaction = -withdrawalAmount;
            System.out.printf("You took out $%.2f%n", withdrawalAmount);
            System.out.printf("You now have a balance of $%.2f%n", balance);
        }
        showMenu();

    }

    // show balance method
    public void showBalance() {

        System.out.printf("Your current balance is $%.2f%n", balance);
        showMenu();
    }

    // previous transaction method
    public void previousTransaction() {

        System.out.println("Previous Transaction");
        System.out.println("--------------------");
        if (previousTransaction > 0) {
            System.out.printf("Deposit: $%.2f%n", previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.printf("Withdrawal: $%.2f%n", previousTransaction);
        } else {
            System.out.println("None");
        }
        showMenu();

    }

   // exit bank with summary
    public void exitBank() {
        System.out.printf("""
                Account summary:
                Name -- %s %s
                Current balance -- $%.2f
                Last transaction -- $%.2f%n
                """, customerFirstName, customerLastName, balance, previousTransaction);

        System.out.println("Thanks for banking with Dallas International! Have a great day!");
    }
}
