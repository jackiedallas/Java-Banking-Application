import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BankOps {
    // properties
    String customerFirstName;
    String customerLastName;
    double balance = 0;
    double previousTransaction;
    int randomAccountNo;

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
            System.out.println("You must be at least 18 years old to open an account.");
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
                5. Exit
                """);
        menuSelection = menuScanner.nextInt();

        switch (menuSelection) {
            case 1 -> deposit();
            case 2 -> withdraw();
            case 3 -> showBalance();
//            case 4 -> previousTrans();
//            case 5 -> exitBank();
            default -> showMenu();
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
        System.out.printf("You deposited $%.2f\n", depositAmount);
        showMenu();

    }

    // withdraw monies method
    public void withdraw() {
        Scanner withdrawalScanner = new Scanner(System.in);
        System.out.println("Enter withdrawal amount:");
        double withdrawalAmount = withdrawalScanner.nextDouble();

        if (withdrawalAmount > balance) {
            System.out.println("Insufficient funds. Please deposit more money or lower the withdrawal amount.");
            withdraw();
        } else {
            balance -= withdrawalAmount;
            previousTransaction -= withdrawalAmount;
            System.out.printf("You now have a balance of $%.2f\n", balance);
        }
        showMenu();
    }

    public void showBalance() {

    }





}
