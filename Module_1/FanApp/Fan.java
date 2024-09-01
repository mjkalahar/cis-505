/* 
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package FanApp;

public class Fan {
	//Declare fan speed constants
	static final int STOPPED = 0;
	static final int SLOW = 1;
	static final int MEDIUM = 2;
	static final int FAST = 3;
	
	//Declare fan attributes
	private int speed;
	private boolean on;
	private double radius;
	private String color;
	
	/*
	 * Default fan constructor
	 * Default speed: STOPPED - 0
	 * Default on: false
	 * Default radius: 6
	 * Default color: "white"
	 */
	public Fan() {
		setSpeed(STOPPED);
		setOn(false);
		setRadius(6);
		setColor("white");
	}
	
	/*
	 * Argument fan constructor
	 * @param speed int - Speed of fan
	 * @param on boolean - If fan is running
	 * @param radius double - Radius of fan
	 * @param color String - Color of fan
	 */
	public Fan(int speed, boolean on, double radius, String color) {
		setSpeed(speed);
		setOn(on);
		setRadius(radius);
		setColor(color);
	}
	
	/*
	 * Speed getter
	 * @return speed int
	 */
	private int getSpeed() {
		return speed;
	}
	
	/*
	 * Speed setter
	 * @param speed int - Speed of fan 0-3
	 */
	private void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/*
	 * On getter
	 * @return on boolean
	 */
	private boolean isOn() {
		return on;
	}

	/*
	 * On setter
	 * @param on boolean - Fan on (true) or off (false)
	 */
	private void setOn(boolean on) {
		this.on = on;
	}
	
	/*
	 * Radius getter
	 * @return radius double
	 */
	private double getRadius() {
		return radius;
	}
	
	/*
	 * Radius setter
	 * @param radius double - Fan radius
	 */
	private void setRadius(double radius) {
		this.radius = radius;
	}
	
	/*
	 * Color getter
	 * @return color String
	 */
	private String getColor() {
		return color;
	}
	
	/*
	 * Color setter
	 * @param color String - Fan color
	 */
	private void setColor(String color) {
		this.color = color;
	}
	
	/*
	 * toString override to display fan attributes
	 * @return String - Formatted string of fan attributes
	 */
	@Override
	public String toString() {
		if(isOn()) {
			return String.format("The fan speed is set to %d with a color of %s and a radius of %.1f", getSpeed(), getColor(), getRadius());
		} else {
			return String.format("The fan is %s with a radius of %.1f and the fan is off", getColor(), getRadius());
		}
	}
}
