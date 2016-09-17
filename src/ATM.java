import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by john.tumminelli on 9/14/16.
 */

public class ATM {

    static void makeWithdrawal(Scanner scanner, Customer customer) throws Exception {

        System.out.println("To withdraw funds, please enter the amount you would like to withdraw:");
        String withdrawAsString = scanner.nextLine();
        System.out.println("Withdrawal Amount: $" + withdrawAsString);

        //long number = Long.parseLong(numberAsString); - Convert amount as string to a long
        long amount = Long.parseLong(withdrawAsString);
        while (amount > customer.getBalance()) {
            System.out.println("You have insufficient funds for this withdrawal.");
        }
        long newBalance = customer.getBalance() - amount;
        System.out.println("Please take your money");
        System.out.println("Your new balance is: $" + newBalance);
        customer.setBalance(newBalance);
        System.out.println("Would you like to make another transaction? y or n");

    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Customer> validUsers = new HashMap<>();

        validUsers.put("bob", new Customer("bob", 2000, "bob123"));
        validUsers.put("fred", new Customer("fred", 1000, "fred123"));
        validUsers.put("barney", new Customer("barney", 1500, "barney123"));
        validUsers.put("itchy", new Customer("itchy", 800, "itchy123"));
        validUsers.put("scratchy", new Customer("scratchy", 230, "scratchy123"));



        boolean keepRunning = true;
        while (keepRunning) {

            System.out.println("Welcome to Iron Yard ATM!!");
            System.out.print("Username: ");                             //prompt for username
            String name = scanner.nextLine();
            System.out.print("Password: ");
            String passwd = scanner.nextLine();
            if ((validUsers.containsKey(name) && !(validUsers.get(name).password).equals(passwd))) {      //use a while loop for the integral condition her instead
                boolean retryPassword = true;
                while (retryPassword) {
                    System.out.println("Password incorrect. Please retry");
                    System.out.print("Password: ");
                    passwd = scanner.nextLine();
                    if (validUsers.get(name).password.equals(passwd)) {
                        retryPassword = false;
                    }
                }
            }
            else if (!validUsers.containsKey(name)) {
                System.out.println("Username does not exist. Would you like to open an account? Y/n");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("y")) {
                    System.out.println("Please enter a username for your new account:");
                    String addUname = scanner.nextLine();
                    System.out.println("Please enter a password:");
                    String addPasswd = scanner.nextLine();
                    System.out.println("Please reenter your password:");
                    String comparePasswd = scanner.nextLine();
                    while (!addPasswd.equals(comparePasswd)) {                  //remember to use .equals to test for string equality
                        System.out.println("Your passwords do not match. Please try again.");
                        System.out.println("Please enter a password:");
                        addPasswd = scanner.nextLine();
                        System.out.println("Please reenter your password:");
                        comparePasswd = scanner.nextLine();
                    }
                    System.out.println("How much to you want to deposit?");
                    String deposit = scanner.nextLine();
                    long depositLong = Long.parseLong(deposit);
                    Customer addCustomer = new Customer(addUname, depositLong, addPasswd);
                    validUsers.put(name, addCustomer);


                } else if (input.equalsIgnoreCase("n")) {
                    keepRunning = false;
                }
            }

            Customer customer = validUsers.get(name);

            boolean loopMainMenu = true;
            while (loopMainMenu) {
                System.out.println("Welcome: " + customer.name.toUpperCase());
                System.out.println("Please select from the following menu choices.");
                System.out.println("1 - Check your balance");
                System.out.println("2 - Withdraw funds");
                System.out.println("3 - Cancel and Logout");
                System.out.println("4 - Close and delete your account");
                System.out.println("5 - Admin Options");

                String selection = scanner.nextLine();
                if (selection.equals("1")) {
                    System.out.println("Your current balance is: $" + customer.getBalance());

                }

                if (selection.equals("2")) {
                    makeWithdrawal(scanner, customer);
                }
                if (selection.equals("3")) {
                    System.out.println("Thanks! Have a good day. Bye!!");
                    loopMainMenu = false;
                }
                else if (selection.equals("4")) {
                    customer.balance = 0;
                    System.out.println("Are you sure you want to close and delete your account? Y/N");
                    String deleteConfirm = scanner.nextLine();
                    if (!deleteConfirm.equalsIgnoreCase("Y")) {

                    }

                }
            }


        }

    }
}
















