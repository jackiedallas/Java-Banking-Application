public class Account extends Customer{
    // Properties
    protected int accountNo;

    // constructor
    public Account(String firstName, String lastName, int age, int accountNo) {
        super(firstName, lastName, age);
        this.accountNo = accountNo;
    }
}
