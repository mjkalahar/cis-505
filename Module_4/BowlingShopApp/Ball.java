/* 
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package BowlingShopApp;

/*
 * Represent a bowling ball that inherits from a Product
 */
public class Ball extends Product {
    //Bowling ball color
    private String color = "";

    /*
     * Returns the color of the bowling ball
     * @return String The color of the bowling ball
     */
    public String getColor() {
        return color;
    }

    /*
     * Sets the color of the bowling ball
     * @param color String The color of the bowling ball
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /*
     * Returns a string of the attributes for a bowling ball
     * @return String of the attributes for a bowling ball
     */
    @Override
    public String toString() {
        return super.toString() + String.format("\n  Color: %s", getColor());
    }
}