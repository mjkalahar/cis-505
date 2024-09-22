/* 
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package BowlingShopApp;

/*
 * Represent bowling shoes that inherits from a Product
 */
public class Shoe extends Product {
    //Bowling shoe size
    private double size = 0;

    /* Returns the size of the bowling shoe
     * @return double The size of the bowling shoe
     */
    public double getSize() {
        return size;
    }

    /* Sets the size of the bowling shoe
     * @param size double The size of the bowling shoe
     */
    public void setSize(double size) {
        this.size = size;
    }

    /*
     * Returns a string of the attributes for a bowling shoe
     * @return String of the attributes for a bowling shoe
     */
    @Override
    public String toString() {
        return super.toString() + String.format("\n  Size: %s", getSize());
    }
}