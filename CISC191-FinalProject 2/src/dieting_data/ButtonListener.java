package dieting_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ButtonListener class implements ActionListner
 * 
 * This class is added to the Food buttons when they are created
 * @see FoodPanel class
 * 
 * When the time comes (edit or view mode) and it is pressed, then it will check if the 
 * editOrView String is "edit" or "view" so the editSelected or the viewSelected is called
 * from the MainFrame class.
 */
public class ButtonListener implements ActionListener{
	MainFrame currentFrame;
	Food currentButton;
	String editOrView;
	FoodPanel foodPanel;
	
	/**
	 * ButtonListener constuctor
	 * 
	 * @param currentFrame
	 * @param currentButton
	 * @param foodPanel
	 */
	public ButtonListener(MainFrame currentFrame, Food currentButton, FoodPanel foodPanel) {
		this.currentFrame = currentFrame;
		this.currentButton = currentButton;
		this.foodPanel = foodPanel;
	}
	
	/**
	 * Reacts when a food item is pressed
	 * Will check if the mode is in edit or view
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		editOrView = foodPanel.getEditOrView();
		
		if (editOrView == "edit")
			currentFrame.editSelected(currentButton);
		else if (editOrView == "view")
			currentFrame.viewSelected(currentButton);
	}
}
