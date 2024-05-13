package dieting_data;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class EditPanel extends JPanel{
	public EditPanel(MainFrame frame) {
		setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Edit Mode");
		label.setHorizontalAlignment((int)EditPanel.CENTER_ALIGNMENT);
		add(label, BorderLayout.NORTH);
		
		JLabel instructions = new JLabel("Select item you would like to edit");
		instructions.setHorizontalAlignment((int)EditPanel.CENTER_ALIGNMENT);
		add(instructions, BorderLayout.CENTER);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
