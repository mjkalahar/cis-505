/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package ExpenseTracker;

import java.util.Scanner;

/*
 * Class for validating user input for int, double, and string
 * Will re-prompt user with prompt provided if invalid response
 */
public class ValidatorIO {
    /*
     * Gets an integer from the user, displays error and reprompts if invalid
     * @param Scanner sc The scanner to get input from
     * @param String prompt The prompt to display to the user
     * @return int The integer entered by the user
     */
    public static int getInt(Scanner sc, String prompt) {
        //Intialize isValid for loop and input to hold value
        int input = 0;
        boolean isValid = false;
        //While not valid
        while(!isValid) {
            //Prompt user for input
            System.out.print(prompt);
            //If input is an integer, save it to input
            if(sc.hasNextInt()) {
                input = sc.nextInt();
                //Set valid to true
                isValid = true;
            } 
            //If input is not an integer, display error and reprompt
            else {
                System.out.println("\n  Error! Invalid integer value.\n");
            }
            //Clear scanner
            sc.nextLine();
        }

        //Return input
        return input;
    }

    /*
     * Gets a double from the user, displays error and reprompts if invalid
     * @param Scanner sc The scanner to get input from
     * @param String prompt The prompt to display to the user
     * @return double The double entered by the user
     */
    public static double getDouble(Scanner sc, String prompt) {
        //Intialize isValid for loop and input to hold value
        double input = 0;
        boolean isValid = false;
        //While not valid
        while(!isValid) {
            //Prompt user for input
            System.out.print(prompt);
            //If input is a double, save it to input
            if(sc.hasNextDouble()) {
                input = sc.nextDouble();
                //Set valid to true
                isValid = true;
            }
            //If input is not a double, display error and reprompt 
            else {
                System.out.println("\n  Error! Invalid double value.\n");
            }
            //Clear scanner
            sc.nextLine();
        }

        //Return input
        return input;
    }

    /*
     * Gets a string from the user, displays error and reprompts if invalid
     * @param Scanner sc The scanner to get input from
     * @param String prompt The prompt to display to the user
     * @return String The string entered by the user
     */
    public static String getString(Scanner sc, String prompt) {
        //Intialize isValid for loop and input to hold value
        String input = "";
        boolean isValid = false;
        //While not valid
        while(!isValid) {
            //Prompt user for input
            System.out.print(prompt);
            //If input is a string, save it to input
            if(sc.hasNext()) {
                input = sc.next();
                //Set valid to true
                isValid = true;
            } 
            //If input is not a string, display error and reprompt
            else {
                System.out.println("\n  Error! Invalid String value.\n");
            }
            //Clear scanner
            sc.nextLine();
        }

        //Return input
        return input;
    }
}