/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package ExpenseTracker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Class to handle reading and writing transactions to a file
 */
public class TransactionIO {
    //File name for storing transactions
    private static String FILE_NAME = "expenses.txt";
    //File object for storing transactions
    private static File file = new File(FILE_NAME);

    /*
     * Inserts a list of transactions to the file
     * @param ArrayList<Transaction> transactions The list of transactions to insert
     * @throws IOException If an error occurs with the file
     */
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        //Create a new PrintWriter to write to the file
        PrintWriter output = null;

        //If the file exists, append to it
        //If the file does not exist, create it
        if(file.exists()) {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        } else {
            output = new PrintWriter(FILE_NAME);
        }

        //Write each transaction to the file in a line, space delimited attributes
        for(Transaction transaction : transactions) {
            output.print(transaction.getDate() + " ");
            output.print(transaction.getDescription() + " ");
            output.println(transaction.getAmount());
        }

        //Close the file
        output.close();
    }

    /*
     * Finds all transactions in the file
     * @return ArrayList<Transaction> The list of transactions found
     * @throws IOException If an error occurs with the file
     */
    public static ArrayList<Transaction> findAll() throws IOException {
        //Create a new ArrayList to store the transactions
        ArrayList<Transaction> transactions = new ArrayList<>();
        //Create a new Scanner to read the file
        Scanner input = new Scanner(file);

        //Read each line in the file
        //Repeat until the end of the file
        while(input.hasNextLine()) {
            String s = input.nextLine();
            //Split the line into tokens based on spaces
            String[] tokens = s.split(" ");
            //Create a new transaction object with the tokens
            Transaction transaction = new Transaction(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
            //Add the transaction to the list
            transactions.add(transaction);
        }
        //Close the file
        input.close();
        //Return the list of transactions
        return transactions;
    }
}