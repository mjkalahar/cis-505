/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package ComposerApp;

import java.util.Scanner;
import java.util.function.Predicate;

/*
 * Main class for testing the ComposerDAO
 * Users can view composers, find composers, add composers, and exit
 */
public class TestComposerApp {

    /*
     * Displays the menu options for the composer app
     */
    public static void displayMenu() {
        System.out.println("\n  MENU OPTIONS");
        System.out.println("    1. View Composers");
        System.out.println("    2. Find Composer");
        System.out.println("    3. Add Composer");
        System.out.println("    4. Exit\n");
    }

    /*
     * Main method
     * @param args The command line arguments
     */
    public static void main(String [] args) {
        //Welcome message
        System.out.println("  Welcome to the Composer App");
        //Boolean for controlling loop to exit
        boolean exit = false;
        //Create a new MemComposerDAO
        MemComposerDAO memComposerDAO = new MemComposerDAO();
        //Variable to hold user input
        int input;
        //Create a new scanner
        Scanner sc = new Scanner(System.in);
        //Loop until user decides to exit
        while(!exit) {
            //Display menu options
            displayMenu();
            //Get users menu selection
            input = getIntInput(sc, "  Please choose an option: ",  value -> value > 0 && value <= 4);
            //If user selected option 1
            if (input == 1) {
                //Display all composers
                System.out.println("\n\n  --DISPLAYING COMPOSERS--");
                for (Composer composer : memComposerDAO.findAll()) {
                    System.out.println(composer + "\n");
                }
            } 
            //If user selected option 2
            else if (input == 2) {
                System.out.println();
                //Get user input for composer id
                int composerIdInput = getIntInput(sc, "  Enter an id: ");
                //Find composer by id
                Composer composer = memComposerDAO.findBy(composerIdInput);
                //Display composer if found, otherwise display error message
                System.out.println("\n\n  --DISPLAYING COMPOSER--");
                if (composer != null) {
                    System.out.println(composer);
                } else {
                    System.out.println("  Could not find a composer with that id");
                }
            } 
            //If user selected option 3
            else if (input == 3) {
                //Get user input for composer id, name, and genre
                System.out.println();
                int inputId = getIntInput(sc, "  Enter an id: ");
                String name = getStringInput(sc, "  Enter a name: ");
                String genre = getStringInput(sc, "  Enter a genre: ");
                //Insert new composer
                memComposerDAO.insert(new Composer(inputId, name, genre));
            } 
            //If user selected option 4
            else if (input == 4) {
                exit = true;
            }
        }

        //End of program message
        System.out.println("\n  End of line...");
    }

    /*
     * Gets an integer input from the user, validates it, and returns the input
     * @param sc The scanner to get input from
     * @param prompt The prompt to display to the user
     * @param condition The condition to validate the input against
     * @return int The validated integer input
     */
    private static int getIntInput(Scanner sc, String prompt, Predicate<Integer> condition) {
        int input = 0;
        boolean valid = false;
        while(!valid) {
            System.out.print(prompt);
            if(!sc.hasNextInt()) {
                System.out.println("\n  Invalid integer value. Please try again.\n");
            }
            else {
                input = sc.nextInt();
                if(condition.test(input)) {
                    valid = true;
                } else {
                    System.out.println("\n  Integer value outside accepted range. Please try again.\n");
                }
            }
            sc.nextLine();
        }
        return input;
    }

    /*
     * Gets an integer input from the user, validates it, and returns the input
     * @param sc The scanner to get input from
     * @param prompt The prompt to display to the user
     * @return int The validated integer input
     */
    private static int getIntInput(Scanner sc, String prompt) {
        int input = 0;
        boolean valid = false;
        while(!valid) {
            System.out.print(prompt);
            if(!sc.hasNextInt()) {
                System.out.println("\n  Invalid integer value. Please try again.\n");
            }
            else {
                input = sc.nextInt();
                valid = true;
            }
            sc.nextLine();
        }
        return input;
    }

    /*
     * Gets a string input from the user, validates it, and returns the input
     * @param sc The scanner to get input from
     * @param prompt The prompt to display to the user
     * @return String The validated string input
     */
    private static String getStringInput(Scanner sc, String prompt) {
        String input = "";
        boolean valid = false;
        while(!valid) {
            System.out.print(prompt);
            if(!sc.hasNextLine()) {
                System.out.println("\n  Invalid integer value. Please try again.\n");
                sc.nextLine();
            }
            else {
                input = sc.nextLine();
                valid = true;
            }
        }
        return input;
    }
}
