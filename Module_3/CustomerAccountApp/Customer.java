/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package CustomerAccountApp;

/*
 * Represents a customer with name, address, city, and zip
 */
public class Customer {
    //Customer name
    private String name;
    //Customer address
    private String address;
    //Customer city
    private String city;
    //Customer zip code
    private String zip;

    /*
     * Default constructor for customer, sets default values for name, address, city, and zip
     */
    public Customer() {
        this("Chris Reitz", "4314 Poplar Ave", "New York", "62334");
    }

    /*
     * Constructor for customer with name, address, city, and zip
     * @param name String Customer name
     * @param address String Customer address
     * @param city String Customer city
     * @param zip String Customer zip code
     */
    public Customer (String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    /*
     * Returns the customer name
     * @return String Customer name
     */
    public String getName() {
        return name;
    }

    /*
     * Returns the customer address
     * @return String Customer address
     */
    public String getAddress() {
        return address;
    }

    /*
     * Returns the customer city
     * @return String Customer city
     */
    public String getCity() {
        return city;
    }

    /*
     * Returns the customer zip code
     * @return String Customer zip code
     */
    public String getZip() {
        return zip;
    }

    /*
     * Override toString to provide formatted customer details string with information for name, address, city, and zip code
     * @return String Containing customer details name, address, city, and zip code
     */
    @Override
    public String toString() {
        return String.format("  Name: %s\n  Address: %s\n  City: %s\n  Zip: %s", getName(), getAddress(), getCity(), getZip());
    }
}