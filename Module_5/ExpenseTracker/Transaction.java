/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package ExpenseTracker;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Class to represent a single transaction with a date, description, and amount
 */
public class Transaction {
    //The date of the transaction
    private String date = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
    //The description of the transaction
    private String description = "";
    //The amount of the transaction
    private double amount = 0;

    /*
     * Default constructor for the Transaction class
     * Sets date to current date, description to blank string, and amount to 0
     */
    public Transaction() {

    }
    /*
     * Constructor for the Transaction class
     * @param String date The date of the transaction
     * @param String description The description of the transaction
     * @param double amount The amount of the transaction
     */
    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    /*
     * Gets the date of the transaction
     * @return String Date of the transaction
     */
    public String getDate() {
        return date;
    }

    /*
     * Sets the date of the transaction
     * @param String date The date of the transaction
     */
    public void setDate(String date) {
        this.date = date;
    }

    /*
     * Gets the description of the transaction
     * @return String Description of the transaction
     */
    public String getDescription() {
        return description;
    }

    /*
     * Sets the description of the transaction
     * @param String description The description of the transaction
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * Gets the amount of the transaction
     * @return double Amount of the transaction
     */
    public double getAmount() {
        return amount;
    }

    /*
     * Sets the amount of the transaction
     * @param double amount The amount of the transaction
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /*
     * Returns a formatted string representation of the transaction
     * @return String Formatted string representation of the transaction
     */
    @Override
    public String toString() {
        return String.format("  Date: %s\n  Description: %s\n  Amount: $%,6.2f", getDate(), getDescription(), getAmount());
    }
}