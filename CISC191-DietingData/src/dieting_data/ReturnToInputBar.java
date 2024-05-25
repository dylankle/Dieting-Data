package dieting_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * ReturnToInputBar class implements ActionListener
 * 
 * This class is added to the "Go Back" button
 * @see AddFoodPanel, AddWaterPanel, EditModePanel, EditSelectedPanel, and ViewModePanel
 * 
 * When the button is pressed, it resets the panel (where ever it is) back to the original
 * input menu.
 */
public class ReturnToInputBar implements ActionListener{
	MainFrame currentFrame;
	
	/**
	 * ReturnToInputBar constructor
	 * 
	 * @param currentFrame
	 */
	public ReturnToInputBar(MainFrame currentFrame) {
		this.currentFrame = currentFrame;
	}

	/**
	 * Reacts to the Go Back button in the add, edit, and view modes
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		currentFrame.goBacktoInputPanel();
	}
}
