/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package CustomerAccountApp;

import java.util.Scanner;

/*
 * Main driver class to test Customer Account App. Prompts the user to enter their customer id, then gives a menu of options on their account.
 * Allows actions check balance, deposit, or withdraw, then loops back to ask to perform more actions or exits.
 */
public class TestCustomerAccountApp {
    /*
	 * Main method for Customer Account App
	 */
    public static void main(String[] args) {
        //Print welcome message
        System.out.println("  Welcome to the Customer Account App");
        //Prompt user for customer id
        System.out.println("\n  Enter a customer ID:");
        System.out.print("    ex: 1007, 1008, 1009>: ");
        //Create scanner for reading input
        Scanner scanner = new Scanner(System.in);
        //Read input for customer id
        Integer accountId = scanner.nextInt();
        //Throw away newline
        scanner.nextLine();
        //Get customer from customer database using account id
        Customer customer = CustomerDB.getCustomer(accountId);
        //Create account object
        Account account = new Account();

        //Initialize boolean exit for loop control
        boolean exit = false;
        //Continue to allow account actions until exit is true
        do {
            //Display the account menu
            account.displayMenu();
            //Read menu option input
            String menuResponse = scanner.nextLine();
            //Process balance check option
            if("B".equalsIgnoreCase(menuResponse)) {
                //Display account balance
                System.out.println(String.format("\n  Account Balance: $%,6.2f", account.getBalance()));
            }
            //Process deposit option 
            else if("D".equalsIgnoreCase(menuResponse)) {
                //Prompt user for deposit amount
                System.out.print("\n  Enter deposit amount: ");
                //Read deposit amount input
                Double depositAmount = scanner.nextDouble();
                //Throw away newline
                scanner.nextLine();
                //Deposit the amount into account
                account.deposit(depositAmount);
                System.out.println();
            }
            //Process withdraw option
            else if("W".equalsIgnoreCase(menuResponse)) {
                //Prompt user for withdraw amount
                System.out.print("\n  Enter withdraw amount: ");
                //Read withdraw amount input
                Double withdrawAmount = scanner.nextDouble();
                //Throw away newline
                scanner.nextLine();
                //Withdraw the amount from account
                account.withdraw(withdrawAmount);
                System.out.println();
            } 
            //Invalid menu option
            else {
                //Display error message
                System.out.println("\n  Error: Invalid option\n");
            }

            //Prompt user to continue or exit
            System.out.print("  Continue? (y/n): ");
            //Read user response to continuing
            String continueResponse = scanner.nextLine();
            //If user does not enter "Y" or "y", set exit boolean to true
            if(!"y".equalsIgnoreCase(continueResponse)) {
                exit = true;
            }
            System.out.println();
        } while(!exit);

        //Display customer details
        System.out.println("\n  --Customer Details--");
        System.out.println(customer);

        //Display account details of amount and transaction date
        System.out.println(String.format("\n  Balance as of %s is $%,6.2f", account.getTransactionDate(), account.getBalance()));
        //Display end of program message
        System.out.print("\n  End of line...");
    }
}