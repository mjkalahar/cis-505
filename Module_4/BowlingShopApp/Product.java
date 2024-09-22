/* 
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package BowlingShopApp;

/*
 * Represent a bowling shop product with a code, description, and price
 */
public class Product {
    //Product code
    private String code = "";
    //Product description
    private String description = "";
    //Product price
    private double price = 0;

    /*
     * Returns the code of the product
     * @return String The code of the product
     */
    public String getCode() {
        return code;
    }

    /*
     * Sets the code of the product
     * @param code String The code of the product
     */
    public void setCode(String code) {
        this.code = code;
    }

    /*
     * Returns the description of the product
     * @return String The description of the product
     */
    public String getDescription() {
        return description;
    }

    /*
     * Sets the description of the product
     * @param description String The description of the product
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * Returns the price of the product
     * @return double The price of the product
     */
    public double getPrice() {
        return price;
    }

    /*
     * Sets the price of the product
     * @param price double The price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /*
     * Returns a string of the attributes for a product
     * @return String of the attributes for a product
     */
    @Override
    public String toString() {
        return String.format("  Product Code: %s\n  Description: %s\n  Price: $%,6.2f", getCode(), getDescription(), getPrice());
    }
}