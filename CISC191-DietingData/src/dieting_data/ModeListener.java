package dieting_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JPanel;

/**
 * abstract ModeListener class implements ActionListener
 * 
 * This class is extended by all the buttons in the InputPanel
 *  O Add
 *  O Edit
 *  O View
 *  
 *  This is an abstract class so all the classes can just call the super constructor, and
 *  must have a version of the actionPerformed method.
 */
public abstract class ModeListener implements ActionListener{
	MainFrame currentFrame;
	JPanel currentModel;
	JRadioButton currentButton;
	
	/**
	 * ModeListener constructor
	 * 
	 * @param currentFrame
	 * @param currentModel
	 * @param currentButton
	 */
	public ModeListener(MainFrame currentFrame, JPanel currentModel, JRadioButton currentButton) {
		this.currentFrame = currentFrame;
		this.currentModel = currentModel;
		this.currentButton = currentButton;
	}
	
	/**
	 * actionPerformed method that needs to be in every child class
	 */
	public abstract void actionPerformed(ActionEvent e);
}
