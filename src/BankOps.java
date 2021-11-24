import java.util.Scanner;

public class BankOps {
    // properties
    String customerFirstName;
    String customerLastName;
    double balance;
    double previousTransaction;
    int randomAccountNo = (int) (Math.floor(Math.random() * 9999999) + 1000000);

    public BankOps(String customerFirstName, String customerLastName, int randomAccountNo) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
    }


    public void newCustomer() {

        Scanner bankScanner = new Scanner(System.in);
        System.out.println("Welcome to Dallas International Bank!");
        System.out.println();
        System.out.println("Let's get started, please enter your first name:");
        String newCustomerFirstName = bankScanner.nextLine();
        System.out.println("Please enter your last name:");
        String newCustomerLastName = bankScanner.nextLine();
        bankScanner.nextLine();
        System.out.println("Please enter your age:");
        int newCustomerAge = bankScanner.nextInt();

        BankOps customer = new BankOps(newCustomerFirstName, newCustomerLastName, randomAccountNo);
        customer.showMenu();

    }

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
            case 4 -> previousTrans();
            case 5 -> exitBank();
            default -> showMenu();
        }

        public void deposit() {
            Scanner depositScanner = new Scanner(System.in);
            System.out.println("Enter deposit amount:");
            double depositAmount = depositScanner.nextDouble();

        }

    }
}
