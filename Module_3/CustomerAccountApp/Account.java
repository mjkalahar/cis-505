/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package CustomerAccountApp;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Represents a customer account with balance and actions for viewing balance, depositing, withdrawing, and displaying menu
 */
public class Account {
    //Account balance
    private double balance = 200;

    /*
     * Returns the account balance
     * @return double Account balance
     */
    public double getBalance() {
        return balance;
    }

    /*
     * Deposits the amount into the account and updates the balance
     * @param amt double Amount to deposit
     */
    public void deposit(double amt) {
        //Add deposit amount to balance
        balance += amt;
    }

    /*
     * Withdraws the amount from the account if balance is greater or equal to amt
     * @param amt double Amount to withdraw
     */
    public void withdraw(double amt) {
        if(balance >= amt) {
            //Subtract withdraw amount from balance
            balance -= amt;
        }
    }

     /*
     * Returns the formatted transaction date
     * @return String Formatted transaction date
     */
    public String getTransactionDate() {
        return new SimpleDateFormat("MM-dd-yyyy").format(new Date());
    }
    /*
     * Displays the account menu options
     */
    public void displayMenu() {
        //Display account menu options
        System.out.println("\n  Account Menu");
        System.out.println("  Enter <D/d> for deposit");
        System.out.println("  Enter <W/w> for withdraw");
        System.out.println("  Enter <B/b> for balance");
        System.out.print("    Enter an option: ");
    }
}