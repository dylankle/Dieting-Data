package dieting_data;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

/**
 * AddFoodPanel class
 * 
 * This is a version of the BorderLayout.EAST in the original mainframe.
 * It will show up after food is selected after the JOptionPane asks to add
 * food or water, after add mode is initiated.
 * 
 * - A JTextBox for the name or text of the JButton.
 * - A JComboBox for the type of food.
 * - A JTextBox for additional details the user might want to attach to the item.
 * 
 * @see AddFoodListener to see where the user inputted data goes
 */
public class AddFoodPanel extends JPanel { 
	public AddFoodPanel(MainFrame frame) {
		setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Add Food Mode");
		label.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		add(label, BorderLayout.NORTH);
		
		JPanel grid = new JPanel(new GridLayout(4, 2));
		
		JLabel nameLabel = new JLabel("Name: ");
		JTextField name = new JTextField("");
		name.setText("");
		grid.add(nameLabel);
		grid.add(name);
		
		JLabel typeLabel = new JLabel("Type: ");
		String[] types = {"Fruit", "Vegetable", "Carb", "Protein", "Dairy"};
		JComboBox foodType = new JComboBox(types);
		grid.add(typeLabel);
		grid.add(foodType);
		
		JLabel detailLabel = new JLabel("Details: ");
		JTextField details = new JTextField("");
		name.setText("");
		grid.add(detailLabel);
		grid.add(details);
		
		add(grid, BorderLayout.CENTER);
		
		JPanel buttons = new JPanel(new FlowLayout());
		
		JButton exit = new JButton("Go Back");
		buttons.add(exit, BorderLayout.SOUTH);
		exit.addActionListener(new ReturnToInputBar(frame));
		
		add(buttons, BorderLayout.SOUTH);
		
		JButton addButton = new JButton("ADD");
		buttons.add(addButton, BorderLayout.SOUTH);
		addButton.addActionListener(new AddFoodListener(frame, name, foodType, details));
		
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
