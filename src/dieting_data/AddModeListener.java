package dieting_data;

import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

/**
 * AddModeListener implements ActionListener
 * 
 * Reacts to the Add JRadioButton from the InputBar. The actionPerformed method will call the method
 * from MainFrame to switch the CardLayout in the BorderLayout.EAST to a "add" mode.
 */
public class AddModeListener extends ModeListener{	
	/**
	 * AddModeListener constructor
	 * 
	 * @param currentFrame
	 * @param currentModel
	 * @param currentButton
	 */
	public AddModeListener(MainFrame currentFrame, JPanel currentModel, JRadioButton currentButton) {
		super(currentFrame, currentModel, currentButton);
		currentButton.setSelected(false);
	}
	
	/**
	 * Reacts to the Add JRadioButton in the main input menu
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		currentFrame.addTypeMode();
		
		currentButton.setSelected(false);
	}
}
