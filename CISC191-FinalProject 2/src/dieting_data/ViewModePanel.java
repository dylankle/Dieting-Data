package dieting_data;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ViewModePanel class extends JPanel
 * 
 * This class changes the input menu into the view mode instructions to prompt the
 * user to select a button to view.
 */
public class ViewModePanel extends JPanel{
	public ViewModePanel(MainFrame frame) {
		setLayout(new BorderLayout());
		
		JLabel label = new JLabel("View Mode");
		label.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		add(label, BorderLayout.CENTER);
		
		JLabel instructions = new JLabel("Select an item to view");
		instructions.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		add(instructions, BorderLayout.CENTER);
		
		JButton exit = new JButton("Go Back");
		exit.addActionListener(new ReturnToInputBar(frame));
		add(exit, BorderLayout.SOUTH);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
