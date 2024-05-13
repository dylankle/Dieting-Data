package dieting_data;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class AddFoodPanel extends JPanel { 
	public AddFoodPanel(MainFrame frame) {
		setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Add Food Mode");
		add(label, BorderLayout.NORTH);
		
		JPanel grid = new JPanel(new GridLayout(4, 2));
		
		JLabel nameLabel = new JLabel("Name: ");
		JTextField name = new JTextField();
		grid.add(nameLabel);
		grid.add(name);
		
		JLabel typeLabel = new JLabel("Type: ");
		String[] types = {"Fruit", "Vegetable", "Carb", "Protein", "Dairy"};
		JComboBox foodType = new JComboBox(types);
		grid.add(typeLabel);
		grid.add(foodType);
		
		JLabel detailLabel = new JLabel("Details: ");
		JTextField details = new JTextField();
		grid.add(detailLabel);
		grid.add(details);
		
		add(grid, BorderLayout.CENTER);
		
		JButton addButton = new JButton("ADD");
		add(addButton, BorderLayout.SOUTH);
		addButton.addActionListener(new AddFoodListener(frame, name, foodType, details));
		
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
