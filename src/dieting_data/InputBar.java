package dieting_data;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.JRadioButton;

/**
 * InputBar extends JPanel
 * 
 * The constructor creats an instance of the class and sets it to a GridLayout of 4 rows
 * and 1 column. 
 * 
 * The grid is full of JRadioButtons that have separate "mode" listeners to change the 
 * card layout and the view of the main JPanel's BorderLayout.EAST.
 *  - O Add
 *  - O Edit
 *  - O View
 *  - O Done
 *  
 *  The end of the class has the formatting to space the grid layout from the sides.
 */
public class InputBar extends JPanel{
	JRadioButton add = new JRadioButton();
	JRadioButton edit = new JRadioButton();
	JRadioButton view = new JRadioButton();
	/**
	 * InputBar constuctor
	 */
	public InputBar(MainFrame currentFrame, JPanel currentModel) {
		
		//creating GridLayout for InputBar JPanel
		setLayout(new GridLayout(3, 1));
		
		//setting JButtons text
		add.setText("Add");
		add.addActionListener(new AddModeListener(currentFrame, currentModel, add));
		edit.setText("Edit");
		edit.addActionListener(new EditModeListener(currentFrame, currentModel, edit));
		view.setText("View");
		view.addActionListener(new ViewModeListener(currentFrame, currentModel, view));
		
		//adding buttons to JPanel
		add(view, 0, 0);
		add(edit, 1, 0);
		add(add, 2, 0);
		
		//spacing the buttons and text
		setBorder(new EmptyBorder(90, 50, 90, 50));
	}
}
