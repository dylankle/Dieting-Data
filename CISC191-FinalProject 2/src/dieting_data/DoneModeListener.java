package dieting_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * DoneModeListener class implements ActionListener
 * 
 * This class is added to the "Done" JButton.
 * @see InputPanel
 * 
 * It calls the method in the MainFrame class to finish, export, and close the program.
 */
public class DoneModeListener implements ActionListener{
	MainFrame currentFrame;
	JPanel currentModel;
	JButton currentButton;
	
	public DoneModeListener(MainFrame currentFrame, JPanel currentModel, JButton currentButton) {
		this.currentFrame = currentFrame;
		this.currentModel = currentModel;
		this.currentButton = currentButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		currentFrame.doneMode();
	}
}
