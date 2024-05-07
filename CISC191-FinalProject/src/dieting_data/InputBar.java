package dieting_data;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.JRadioButton;

public class InputBar extends JPanel{
	JRadioButton add = new JRadioButton();
	JRadioButton edit = new JRadioButton();
	JRadioButton done = new JRadioButton();
	
	public InputBar() {
		setLayout(new GridLayout(3, 1));
		
		add.setText("Add");
		edit.setText("Edit");
		done.setText("Done");
		
		add(add, 0, 0);
		add(edit, 1, 0);
		add(done, 2, 0);
		
		setBorder(new EmptyBorder(130, 60, 130, 60));
	}
}
