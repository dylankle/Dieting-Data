package dieting_data;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InputPanel extends JPanel{
	JLabel inputLabel = new JLabel("Menu");
	
	public InputPanel(MainFrame frame, JPanel model) {
		setLayout(new BorderLayout());
		inputLabel.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		add(inputLabel, BorderLayout.NORTH);
		add(new InputBar(frame, model), BorderLayout.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
