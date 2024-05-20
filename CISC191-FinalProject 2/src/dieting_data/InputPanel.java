package dieting_data;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * InputPanel class extends JPanel
 * 
 * The constructor makes an instance of the class and sets a BorderLayout. 
 * A JLabel at the BorderLayout.NORTH to show it is in the Input Menu 
 * state/card. An instance of the inputBar class is made in the 
 * BorderLayout.CENTER.
 * 
 * A thin, black border is made around the whole InputPanel.
 */
public class InputPanel extends JPanel{
	JLabel inputLabel = new JLabel("Menu");
	
	public InputPanel(MainFrame frame, JPanel model) {
		setLayout(new BorderLayout());
		inputLabel.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		
		add(inputLabel, BorderLayout.NORTH);
		add(new InputBar(frame, model), BorderLayout.CENTER);
		
		JButton done = new JButton("Done");
		done.addActionListener(new DoneModeListener(frame, model, done));
		add(done, BorderLayout.SOUTH);
		
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
