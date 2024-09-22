/* 
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package BowlingShopApp;

/*
 * Represent a bowling bag that inherits from a Product
 */
public class Bag extends Product {
    //Bowling bag type
    private String type = "";

    /*
     * Returns the type of the bowling bag
     * @return String The type of the bowling bag
     */
    public String getType() { 
        return type;
    }

    /*
     * Sets the type of the bowling bag
     * @param type String The type of the bowling bag
     */
    public void setType(String type) {
        this.type = type;
    }

    /*
     * Returns a string of the attributes for a bowling bag
     * @return String of the attributes for a bowling bag
     */
    @Override
    public String toString() {
        return super.toString() + String.format("\n  Type: %s", getType());
    }
}