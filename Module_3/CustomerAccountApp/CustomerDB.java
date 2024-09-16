/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package CustomerAccountApp;

/*
 * Customer DB class to represent getting customer information from DB by ID
 */
public class CustomerDB {

    /*
     * Returns a customer from the database with the id matching the id from input
     * @param id Integer Customer ID
     * @return Customer Customer object containing information for customer with matching ID
     */
    public static Customer getCustomer(Integer id) {
        //If id is 1007, return John Smith customer
        if(id == 1007) {
            return new Customer("John Smith", "2142 Quincy St", "Scottsdale", "12345");
        }
        //If id is 1008, return Jane Johnson customer 
        else if(id == 1008) {
            return new Customer("Jane Johnson", "32215 Gregg Rd", "Portland", "25125");
        }
        //If id is 1009, return Shannon Debransky customer
        else if(id == 1009)  {
            return new Customer("Shannon Debransky", "3152 Oakdale Dr", "Coral Gables", "32531");
        }
        //Id does not match, return default customer (Chris Reitz)
        else {
            return new Customer();
        }
    }
}