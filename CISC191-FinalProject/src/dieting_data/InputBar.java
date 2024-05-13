package dieting_data;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.JRadioButton;

public class InputBar extends JPanel{
	JRadioButton add = new JRadioButton();
	JRadioButton edit = new JRadioButton();
	JRadioButton view = new JRadioButton();
	JRadioButton done = new JRadioButton();
	/**
	 * InputBar constuctor
	 */
	public InputBar(MainFrame currentFrame, JPanel currentModel) {
		
		//creating GridLayout for InputBar JPanel
		setLayout(new GridLayout(4, 1));
		
		//setting JButtons text
		add.setText("Add");
		add.addActionListener(new AddModeListener(currentFrame, currentModel, add));
		edit.setText("Edit");
		edit.addActionListener(new EditModeListener(currentFrame, currentModel, edit));
		view.setText("View");
		view.addActionListener(new ViewModeListener(currentFrame, currentModel, view));
		done.setText("Done");
		done.addActionListener(new DoneListener(currentFrame, currentModel, done));
		
		//adding buttons to JPanel
		add(done, 0, 0);
		add(view, 1, 0);
		add(edit, 2, 0);
		add(add, 3, 0);
		
		//spacing the buttons and text
		setBorder(new EmptyBorder(90, 50, 90, 50));
	}
}
