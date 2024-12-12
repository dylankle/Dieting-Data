package dieting_data;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import java.awt.Dimension;

/**
 * FoodPanel class extends JPanel
 * 
 * This panel is located in the BorderLayout.CENTER. The flow layout adds buttons
 * with affiliated Food object name. A HashMap stores the a JButton with a String
 * key.
 * 
 * All buttons are disabled, but after edit or view mode is engaged...
 * @see ButtonListener
 * ... all buttons will be enabled.
 * 
 * Each button in the panel has an ButtonListener that will switch the 
 * instructions to select a button to either a edit panel or open JOptionPane when viewing
 */
@SuppressWarnings("unchecked")
public class FoodPanel extends JPanel{
	MainFrame frame;
	String editOrView = "";
	
	public ArrayList<Food> food = new ArrayList<>();
	
	ArrayList<Food>[] typeArray = new ArrayList[6];
	/**
	 * FoodPanel constructor
	 * 
	 * @param frame
	 */
	public FoodPanel(MainFrame frame) {
		this.frame = frame;
		
		for(int i = 0; i < 6; i++) {
			typeArray[i] = new ArrayList<Food>();
		}
		
		setLayout(new FlowLayout());
	}
	
	/**
	 * Adds Food object to the ArrayList
	 * 
	 * @param newFood
	 */
	public void addItem(Food newFood) {
		food.add(newFood);
		newFood.setPreferredSize(new Dimension(100, 50));
		newFood.addActionListener(new ButtonListener(frame, newFood, this));
		newFood.setEnabled(false);
		
		switch(newFood.getType()) {
		case "Fruit":
			typeArray[0].add(newFood);
		case "Vegetable":
			typeArray[1].add(newFood);
		case "Carb":
			typeArray[2].add(newFood);
		case "Protein":
			typeArray[3].add(newFood);
		case "Dairy":
			typeArray[4].add(newFood);
		case "Combo":
			typeArray[5].add(newFood);
		}
		
		add(newFood);
	}
	
	/**
	 * Enable all the JButtons
	 */
	public void enableButtons() {
		for (Food button : food) {
			button.setEnabled(true);
		}	
	}
	
	/**
	 * Diable all the JButtons
	 */
	public void disableButtons() {
		for (Food button : food) {
			button.setEnabled(false);
		}	
	}
	
	/**
	 * @return editOrView "edit" or "view"
	 */
	public String getEditOrView() {
		return editOrView;
	}
	
	/**
	 * set the editOrView "edit" or "view"
	 * @param str
	 */
	public void setEditOrView(String str) {
		editOrView = str;
	}
	
	/**
	 * Calls toString method on all Food objects and makes one String for the final txt file
	 * 
	 * @param date
	 * @param water
	 * @return
	 */
	public String export(String date, int water) {
		String returnValue = date + "\nWater Drank: " + water + "oz\n--------\n";
		
		for (Food item : food) {
			returnValue += item.getName() + "\n" + item.getType() + "\n" + item.getDetails() + "\n--------\n";
		}
		
		return returnValue;
	}
}
