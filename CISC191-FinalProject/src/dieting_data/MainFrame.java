package dieting_data;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import java.util.ArrayList;

import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MainFrame extends JFrame{
	JFrame frame = new JFrame("Dieting Data");
	
	JPanel model = new JPanel();
	
	String date;
	JLabel dateLabel = new JLabel();
	
	JPanel waterPanel = new JPanel();
	JLabel waterLabel = new JLabel("Water");
	WaterProgress progressBar = new WaterProgress();
	JLabel waterCounter = new JLabel();
	
	FoodPanel foodPanel = new FoodPanel();
	
	JPanel menuBar = new JPanel();
	CardLayout mainInputMenu = new CardLayout();
	InputPanel card1;
	AddFoodPanel card2 = new AddFoodPanel(this);
	AddWaterPanel card3 = new AddWaterPanel(this);
	EditPanel card4 = new EditPanel(this);	
	/**
	 * MainFrame constuctor
	 * 
	 * @param input
	 */
	public MainFrame(String input) {
		//Setting the main JFrame size
		frame.setSize(850, 480);
		
		//Setting the layout for the main JPanel
		model.setLayout(new BorderLayout());
		//JLabel settings such as text, centering, and layout location
		dateLabel.setText("\n" + input + "\n");
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		dateLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		model.add(dateLabel, BorderLayout.NORTH);
		
		//Adding components for the water panel going in West layout
		waterPanel.setLayout(new BorderLayout());
		waterCounter.setText(Integer.toString(progressBar.getWater()) + " oz");	
		//Water JLabel settings such centering
		waterLabel.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		waterPanel.add(waterLabel, BorderLayout.NORTH);
		waterPanel.add(progressBar, BorderLayout.CENTER);
		//Water counter JLabel settings such centering
		waterCounter.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		waterPanel.add(waterCounter, BorderLayout.SOUTH);
		waterPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		model.add(waterPanel, BorderLayout.WEST);
		
		//Creating instance of FoodPanel class
		model.add(foodPanel, BorderLayout.CENTER);
		
		//Adding cards to card layout and adding panel with that layout to the main JPanel
		card1 = new InputPanel(this, model);
		menuBar.setLayout(mainInputMenu);
		menuBar.add(card1, "input");
		menuBar.add(card2, "addFood");
		menuBar.add(card3, "addWater");
		menuBar.add(card4, "edit");
		model.add(menuBar, BorderLayout.EAST);
		
		//Adding the overall border layout model to the main frame
		frame.add(model);
		
		//Settings for visible JFrame with closing capabilities
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * date setter
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * date getter
	 * 
	 * @return
	 */
	public String getDate() {
		return date;
	}
	
	public void addTypeMode() {
		JPanel itemType = new JPanel();
		itemType.setLayout(new GridLayout(3, 1));
		
		JLabel typeLabel = new JLabel("Food or Water");
		ButtonGroup group = new ButtonGroup();
		JRadioButton food = new JRadioButton("Food");
		JRadioButton water = new JRadioButton("Water");
		group.add(food);
		group.add(water);
		
		itemType.add(water, 0, 0);
		itemType.add(food, 1, 0);
		itemType.add(typeLabel, 2, 0);
		
		JOptionPane.showMessageDialog(null, itemType);
		
		if (food.isSelected()) {
			mainInputMenu.show(menuBar, "addFood");
		}
		
		if (water.isSelected()) {
			mainInputMenu.show(menuBar, "addWater");
		}
			
	}
	
	public void addFood(String name, String type, String details) {
		Food newFood = new Food(name, type, details);
		foodPanel.addItem(newFood);
		
		mainInputMenu.show(menuBar, "input");
	}
	
	public void addWater(int amount) {
		progressBar.increaseWater(amount);
		progressBar.setValue(progressBar.getWater());
		waterCounter.setText(Integer.toString(progressBar.getWater()) + " oz");
		
		mainInputMenu.show(menuBar, "input");
	}
	
	public void editMode() {
		mainInputMenu.show(menuBar, "edit");
		
		foodPanel.enableButtons();
	}
}
