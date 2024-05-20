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
public class FoodPanel extends JPanel{
	MainFrame frame;
	String editOrView = "";
	
	public ArrayList<Food> food = new ArrayList<>();
	
	public FoodPanel(MainFrame frame) {
		this.frame = frame;
		
		setLayout(new FlowLayout());
	}
	
	public void addItem(Food newFood) {
		food.add(newFood);
		newFood.setPreferredSize(new Dimension(100, 50));
		newFood.addActionListener(new ButtonListener(frame, newFood, this));
		newFood.setEnabled(false);
		add(newFood);
	}
	
	public void enableButtons() {
		for (Food button : food) {
			button.setEnabled(true);
		}	
	}
	
	public void disableButtons() {
		for (Food button : food) {
			button.setEnabled(false);
		}	
	}
	
	public String getEditOrView() {
		return editOrView;
	}
	
	public void setEditOrView(String str) {
		editOrView = str;
	}
	
	public String export(String date, int water) {
		String returnValue = date + "\nWater Drank: " + water + "oz\n--------\n";
		
		for (Food item : food) {
			returnValue += item.getName() + "\n" + item.getType() + "\n" + item.getDetails() + "\n--------\n";
		}
		
		return returnValue;
	}
}
