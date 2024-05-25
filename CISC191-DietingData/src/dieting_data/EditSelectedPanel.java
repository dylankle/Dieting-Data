package dieting_data;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * EditSelectedPanel class extends JPanel
 * 
 * This panel is a lot like the AddFoodPanel. It will have JTextFields and a JComboBox for the user
 * to change the data for the item. It shows up after ButtonListener is pressed.
 */
public class EditSelectedPanel extends JPanel{
	/**
	 * EditSelectedPanel constructor
	 * 
	 * @param frame
	 * @param currentButton
	 */
	public EditSelectedPanel(MainFrame frame, Food currentButton) {
		setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Edit Mode");
		label.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		add(label, BorderLayout.NORTH);
		
		JPanel grid = new JPanel(new GridLayout(4, 2));
		
		JLabel nameLabel = new JLabel("Name: ");
		JTextField name = new JTextField(currentButton.getName(), 10);
		grid.add(nameLabel);
		grid.add(name);
		
		JLabel typeLabel = new JLabel("Type: ");
		String[] types = {"Fruit", "Vegetable", "Carb", "Protein", "Dairy", "Combo"};
		JComboBox foodType = new JComboBox(types);
		foodType.setSelectedItem(currentButton.getType());
		grid.add(typeLabel);
		grid.add(foodType);
		
		JLabel detailLabel = new JLabel("Details: ");
		JTextArea details = new JTextArea(currentButton.getDetails(), 40, 10);
		details.setLineWrap(true);
		details.setWrapStyleWord(true);
		grid.add(detailLabel);
		grid.add(details);
		
		add(grid, BorderLayout.CENTER);
		
		JPanel buttons = new JPanel(new FlowLayout());
		
		JButton exit = new JButton("Go Back");
		buttons.add(exit, BorderLayout.SOUTH);
		exit.addActionListener(new ReturnToInputBar(frame));
		
		JButton addButton = new JButton("EDIT");
		buttons.add(addButton, BorderLayout.SOUTH);
		addButton.addActionListener(new EditSubmitListener(frame, name, foodType, details, currentButton));
		
		add(buttons, BorderLayout.SOUTH);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
