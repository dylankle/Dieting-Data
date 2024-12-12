package dieting_data;

import javax.swing.JButton;

/**
 * Food class extends JButton
 * 
 * This class is a JButton with 3 String fields to store the data for a name/button text, type, and details.
 * It will be stored in an ArrayList in FoodPanel where it can be added indefinitely.
 */
public class Food extends JButton{
	String name;
	String type;
	String details;
	
	/**
	 * Food constructor with no params
	 */
	public Food() {
	}
	
	/**
	 * Food constructor
	 * 
	 * @param name
	 * @param type
	 * @param details
	 */
	public Food(String name, String type, String details) {
		this.name = name;
		this.type = type;
		this.details = details;
		
		setText(name);
	}
	
	/**
	 * name getter
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * name setter
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * type getter
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * type setter
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * details getter
	 * @return details
	 */
	public String getDetails() {
		return details;
	}
	
	/**
	 * details setter
	 * @param details
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	
	/**
	 * @return String of all the fields together
	 */
	public String toString() {
		return "Name: " + name + "\nType: " + type + "\nDetails: " + details;
	}
}
