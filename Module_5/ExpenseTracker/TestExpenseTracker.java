/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package ExpenseTracker;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * Main class for expense tracker.
 * Users can view transactions, add transactions, and view their total monthly expenses
 */
public class TestExpenseTracker {
    /*
     * Displays the menu options for the expense tracker
     */
    public static void displayMenu() {
        System.out.println("\n  MENU OPTIONS");
        System.out.println("    1. View Transactions");
        System.out.println("    2. Add Transactions");
        System.out.println("    3. View Expense\n");
    }

    /*
     * Main method
     * @param args The command line arguments
     * @throws IOException If an error occurs with the storage file
     */
    public static void main(String [] args) throws IOException {
        //Welcome message
        System.out.println("  Welcome to the Expense Tracker");
        //Scanner for user input
        Scanner scanner = new Scanner(System.in);
        //Boolean for controlling loop to exit
        boolean exit = false;
        //Loop until user decides to exit
        while(!exit) {
            //Display menu options
            displayMenu();
            //Get users menu selection
            int input = ValidatorIO.getInt(scanner, "  Please choose an option: ");
            //If user selected option 1
            if(input == 1) {
                //Display all transactions
                System.out.println("\n  MONTHLY EXPENSES");
                for(Transaction transaction : TransactionIO.findAll()) {
                    System.out.println("\n" + transaction);
                }
            } 
            //If user selected option 2
            else if(input == 2) {
                //Create string to hold if add more user response is Y
                String addMore = "Y";
                //List of transactions to add in bulk
                ArrayList<Transaction> transactions = new ArrayList<>();
                //While user continues to say Y to add more transactions
                while("Y".equalsIgnoreCase(addMore)) {
                    //Get user input for transaction description
                    String description = ValidatorIO.getString(scanner, "\n  Enter the description: ");
                    //Get user input for transaction amount
                    double amount = ValidatorIO.getDouble(scanner, "  Enter the amount: ");
                    //Create new transaction and add to list, use current date as date
                    Transaction newTransaction = new Transaction(new SimpleDateFormat("MM-dd-yyyy").format(new Date()), description, amount);
                    transactions.add(newTransaction);
                    //Prompt user to add more
                    addMore = ValidatorIO.getString(scanner, "\n  Add another transaction? (y/n): ");
                }

                //Bulk insert transactions to file
                try {
                    TransactionIO.bulkInsert(transactions);
                } 
                //If exception occured, display message to user
                catch (IOException exception) {
                    System.out.println("\n  Exception: " + exception.getMessage());
                }
            } 
            //If user selected option 3
            else if(input == 3) {
                //Create running total
                double monthlyExpense = 0;
                //Find all transactions and loop through them
                for(Transaction transaction : TransactionIO.findAll()) {
                    //Add transaction amount to running total
                    monthlyExpense += transaction.getAmount();
                }
                //Display formatted total to user
                System.out.println(String.format("\n  Your total monthly expense is $%,6.2f", monthlyExpense));
            }
            //Prompt user to continue
            String response = ValidatorIO.getString(scanner, "\n  Continue? (y/n): ");
            //If user does not want to continue, set exit to true
            if("N".equalsIgnoreCase(response)) {
                exit = true;
            }
        }
        //End of program message
        System.out.println("\n  Program terminated by user...");
    }

}
