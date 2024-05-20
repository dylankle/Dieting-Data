package dieting_data;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * AddWaterPanel class extends JPanel
 * 
 * This is a version of the BorderLayout.EAST in the original mainframe.
 * It will show up after water is selected after the JOptionPane asks to add
 * food or water, after add mode is initiated.
 * 
 * - A JTextBox for the amount of water the user drank
 * Also converts String textbox data to Integer
 * 
 * @see AddWaterListener to see where the user inputted data goes
 */
public class AddWaterPanel extends JPanel{
	public AddWaterPanel(MainFrame frame) {
		setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Add Water Mode");
		label.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		add(label, BorderLayout.NORTH);
		
		JLabel waterLabel = new JLabel("Amount(oz): ");
		JTextField water = new JTextField();
		add(waterLabel, BorderLayout.CENTER);
		add(water, BorderLayout.CENTER);
		
		JPanel buttons = new JPanel(new FlowLayout());
		
		JButton exit = new JButton("Go Back");
		buttons.add(exit, BorderLayout.SOUTH);
		exit.addActionListener(new ReturnToInputBar(frame));
		
		JButton addButton = new JButton("ADD");
		buttons.add(addButton, BorderLayout.SOUTH);
		addButton.addActionListener(new AddWaterListener(frame, water));
		
		add(buttons, BorderLayout.SOUTH);
	}
}
