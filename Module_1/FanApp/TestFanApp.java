/* 
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package FanApp;

public class TestFanApp {
	public static void main(String[] args) {
		//Create default fan using default attributes
		Fan defaultFan = new Fan();

		//Create fan using arguments passed in and fan speed constant
		Fan argsFan = new Fan(Fan.MEDIUM, true, 8.0, "Blue");
		
		//Print toString for default fan
		System.out.println(defaultFan.toString());
		//Add new line space
		System.out.println();
		//Print toString for arguments created fan
		System.out.println(argsFan.toString());
	}
}
