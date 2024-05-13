package dieting_data;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddWaterPanel extends JPanel{
	public AddWaterPanel(MainFrame frame) {
		setLayout(new BorderLayout());
		
		JLabel label = new JLabel("Add Water Mode");
		add(label, BorderLayout.NORTH);
		
		JLabel waterLabel = new JLabel("Amount(oz): ");
		JTextField water = new JTextField();
		add(waterLabel, BorderLayout.CENTER);
		add(water, BorderLayout.CENTER);
		
		JButton addButton = new JButton("ADD");
		add(addButton, BorderLayout.SOUTH);
		addButton.addActionListener(new AddWaterListener(frame, water));
	}
}
