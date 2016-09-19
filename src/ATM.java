import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.sun.tools.doclets.formats.html.markup.StringContent;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by john.tumminelli on 9/14/16.
 */

public class ATM {

    private static void pressAnyKeyToContinue() throws Exception
    {
        System.out.println("Press Enter to continue...");
        {
            System.in.read();
        }
    }

    private static void makeWithdrawal(Scanner scanner, Customer customer) throws Exception {

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

        validUsers.put("bob", new Customer("bob", 2000, "bob123", false));
        validUsers.put("fred", new Customer("fred", 1000, "fred123", false));
        validUsers.put("barney", new Customer("barney", 1500, "barney123", false));
        validUsers.put("itchy", new Customer("itchy", 800, "itchy123", true));
        validUsers.put("scratchy", new Customer("scratchy", 2300, "scratchy123", true));



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
                    //default all users to non administrator

                    Customer addCustomer = new Customer(addUname, depositLong, addPasswd, false);
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
                System.out.println("4 - Admin Options");

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
                    if (validUsers.get(name).isAdmin) {
                        System.out.println("Please select from these menu choices:");
                        System.out.println("1 - Close out your account");
                        System.out.println("2 - Print all accounts and balances to the console");
                        selection = scanner.nextLine();
                        if (selection.equals("1")) {
                            validUsers.remove(name);
//                            customer.balance = 0;
                            System.out.println("Account for Username: " + name + " is deleted.");
                            loopMainMenu = false;
                        }
                        if (selection.equals("2")) {
                            for (String out : validUsers.keySet()) {
                                long balanceOut = validUsers.get(out).balance;
                                System.out.println(out + " " + balanceOut);
                            }
                        }
                    }
                    else {
                        System.out.println(customer.name.toUpperCase() + " does not have admin privileges. Press Enter to continue.");
                        pressAnyKeyToContinue();
                    }


                }
            }


        }

    }
}
















