package dieting_data;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import java.awt.Dimension;

public class FoodPanel extends JPanel{
	ArrayList<Food> food = new ArrayList<>();
	HashMap<String, JButton> buttonsMap = new HashMap<>();
	
	public FoodPanel() {
		setLayout(new FlowLayout());
	}
	
	public void addItem(Food newFood) {
		food.add(newFood);
		JButton newButton = new JButton(newFood.getName());
		newButton.setPreferredSize(new Dimension(100, 50));
		newButton.setEnabled(false);
		add(newButton);
		buttonsMap.put(newFood.getName(), newButton);
	}
	
	public void removeItem(int select) {
		food.remove(select);
	}
	
	public Food getItem(int select) {
		return food.get(select);
	}
	
	public void enableButtons() {
		for (JButton button : buttonsMap.values()) {
			button.setEnabled(true);
		}	
	}
	
	public void disableButtons() {
		for (JButton button : buttonsMap.values()) {
			button.setEnabled(false);
		}	
	}
}
