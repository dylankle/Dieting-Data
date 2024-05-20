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
	
	public Food() {
		
	}
	
	public Food(String name, String type, String details) {
		this.name = name;
		this.type = type;
		this.details = details;
		
		setText(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	
	public String toString() {
		return "Name: " + name + "\nType: " + type + "\nDetails: " + details;
	}
}
