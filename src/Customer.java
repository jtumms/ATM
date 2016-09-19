import sun.util.resources.cldr.om.CurrencyNames_om;

/**
 * Created by john.tumminelli on 9/14/16.
 */
public class Customer {
    String name;
    long balance;
    String password;
    boolean isAdmin;

    public Customer(String newName, long newBalance, String newPassword, boolean newIsAdmin) {
        name = newName;
        balance = newBalance;
        password = newPassword;
        isAdmin = newIsAdmin;

    }
    long getBalance() {
        return balance;
    }
    void setBalance(long newBalance) {
        balance = newBalance;
    }


}
