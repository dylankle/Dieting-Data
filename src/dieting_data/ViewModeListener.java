package dieting_data;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * VietModeListener class extends ModeListener
 * 
 * This class is connected to the JRadioButton from the main, original input menu.
 * @see InputBar class
 * 
 * It will call the correct method from the MainFrame class to display the instructions to select
 * the button the user wants to view.
 */
public class ViewModeListener extends ModeListener{
	/**
	 * ViewModeListener constructor
	 * 
	 * @param currentFrame
	 * @param currentModel
	 * @param currentButton
	 */
	public ViewModeListener(MainFrame currentFrame, JPanel currentModel, JRadioButton currentButton) {
		super(currentFrame, currentModel, currentButton);
		currentButton.setSelected(false);
	}
	
	/**
	 * Reacts to the View JRadioButton in the original input menu
	 */
	public void actionPerformed(ActionEvent e) {
		currentFrame.viewMode();
		
		currentButton.setSelected(false);
	}
}
