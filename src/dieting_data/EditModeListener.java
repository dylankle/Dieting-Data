package dieting_data;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;

/**
 * EditModeListener class extends Modelistener
 * 
 * This class is connected to the JRadioButton from the main, original input menu.
 * @see InputBar class
 * 
 * It will call the correct method from the MainFrame class to display the instructions to select
 * the button the user wants to edit.
 */
public class EditModeListener extends ModeListener{
	/**
	 * EditModeListener constructor
	 * 
	 * @param currentFrame
	 * @param currentModel
	 * @param currentButton
	 */
	public EditModeListener(MainFrame currentFrame, JPanel currentModel, JRadioButton currentButton) {
		super(currentFrame, currentModel, currentButton);
		currentButton.setSelected(false);
	}
	
	/**
	 * Reacts to the Edit JRadioButton in the main input menu
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		currentFrame.editMode();
		
		currentButton.setSelected(false);
	}
}
