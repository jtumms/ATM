/**
 * Created by john.tumminelli on 9/14/16.
 */
public class Customer {
    String name;
    long balance;

    public Customer(String newName, long newBalance) {
        name = newName;
        balance = newBalance;
    }
    long getBalance() {
        return balance;
    }
    void setBalance(long newBalance) {
        balance = newBalance;



    }
}
