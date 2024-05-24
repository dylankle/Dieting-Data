package dieting_data;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * EditModePanel class extends JPanel
 * 
 * This panel is the instructions to select the item you want to edit and shows
 * up after the EditModeListener is pressed.
 */
public class EditModePanel extends JPanel{
	public EditModePanel(MainFrame frame) {
		setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Edit Mode");
		label.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		add(label, BorderLayout.CENTER);
		
		JLabel instruction = new JLabel("Select an item to edit");
		instruction.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		add(instruction, BorderLayout.CENTER);
		
		JButton exit = new JButton("Go Back");
		exit.addActionListener(new ReturnToInputBar(frame));
		add(exit, BorderLayout.SOUTH);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
