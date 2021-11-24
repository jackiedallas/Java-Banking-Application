import java.util.Scanner;

public class BankOps extends Account {
    // properties
    double balance;
    double previousTransaction;

    public BankOps(String firstName, String lastName, int age, int accountNo) {
        super(firstName, lastName, age, accountNo);
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


    }
}
