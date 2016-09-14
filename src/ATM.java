import com.sun.tools.classfile.Code_attribute;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

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

        if (amount > customer.getBalance()) {
            throw new Exception("You have insufficient funds for this withdrawal");
        }
        else {
            long newBalance = customer.getBalance() - amount;
            System.out.println("Please take your money");
            System.out.println("Your new balance is: $" + newBalance);

            customer.setBalance(newBalance);
        }
        System.out.println("Would you like to make another transaction? y or n");

    }
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Iron Yard ATM!!");
        System.out.println("Please enter your name to begin:");


        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        boolean keepRunning = true;


        Customer customer = new Customer(name, 100);

        while (keepRunning) {
            if (name.equals("")) {
                throw new Exception("Invalid name");
            }
            System.out.println("Welcome to the bank, " + name);
            System.out.println("Please select from the following menu choices. Select 1, 2, or 3");
            System.out.println("1 - Check your balance");
            System.out.println("2 - Withdraw funds");
            System.out.println("3 - Cancel");

            String selection = scanner.nextLine();
            if (selection.equals("1")) {
                System.out.println("Your current balance is: $" + customer.getBalance());
            }

            else if (selection.equals("2")) {
                makeWithdrawal(scanner, customer);
            }

            else if (selection.equals("3")) {
                System.out.println("You have cancelled the transaction and no changes have been made to your account");
                System.out.println("Thank you and please come again...");
                keepRunning = false;
            }
        }



    }

}
