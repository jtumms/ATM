import sun.util.resources.cldr.om.CurrencyNames_om;

/**
 * Created by john.tumminelli on 9/14/16.
 */
public class Customer {
    String name;
    long balance;
    String password;

    public Customer(String newName, long newBalance, String newPassword) {
        name = newName;
        balance = newBalance;
        password = newPassword;
    }
    long getBalance() {
        return balance;
    }
    void setBalance(long newBalance) {
        balance = newBalance;
    }
    void createUser() {


    }

}
