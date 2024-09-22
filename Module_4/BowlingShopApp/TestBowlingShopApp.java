/* 
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package BowlingShopApp;

import java.util.Scanner;

/*
 * Main Driver class for bowling shop app. Displays menu, retrieves product listing or exits based on input
 */
public class TestBowlingShopApp {
    /*
     * Displays a menu of options for the bowling shop
     * balls, bags, shoes, exit 
     */
    public static void displayMenu() {
        System.out.println("\n  MENU OPTIONS");
        System.out.println("    1. <b> Bowling Balls");
        System.out.println("    2. <a> Bowling Bags");
        System.out.println("    3. <s> Bowling Shoes");
        System.out.println("    4. <x> To exit");
        System.out.print("\n  Please choose an option: ");
    }

    /*
     * Main method for running bowling shop app
     */
    public static void main(String[] args) {
        //Create scanner for reading input
        Scanner scanner = new Scanner(System.in);
        //Boolean controlling exit
        boolean exit = false;
        //Display welcome message
        System.out.println("  Welcome to the Bowling Shop\n");

        //Loop while exit is false
        while(!exit) {
            //Display bowling shop menu
            displayMenu();
            //Get user input
            String userInput = scanner.nextLine();
            //If user selects exit, set control boolean to true
            if("X".equalsIgnoreCase(userInput)) {
                exit = true;
            } else {
                //Get GenericQueue of products from Product DB
                GenericQueue<Product> products = ProductDB.getProducts(userInput);
                //Display product listing title
                System.out.println("\n  --Product Listing--");
                //While products exist in the queue
                while(products.size() > 0) {
                    //Pull product from queue and display it
                    System.out.println(products.dequeue() + "\n");
                }
            }
        }

        //Display exist message
        System.out.println("\n\n  End of line...");
    }
}