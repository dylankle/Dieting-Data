package dieting_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * EditSubmitListener class implements ActionListener
 * 
 * This class is the listener for the "EDIT" button.
 * @see EditSubmitListener class
 * 
 * It will call the correct method from the MainFrame class that will update fields of the selected button.
 */
public class EditSubmitListener implements ActionListener{
	MainFrame frame;
	JTextField name;
	JComboBox foodType;
	JTextField details;
	Food currentButton;
	
	public EditSubmitListener(MainFrame frame, JTextField name, JComboBox foodType, JTextField details, Food currentButton) {
		this.frame = frame;
		this.name = name;
		this.foodType = foodType;
		this.details = details;
		this.currentButton = currentButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.submitEditFood(name.getText(), (String)foodType.getSelectedItem(), details.getText(), currentButton);
		
		name.setText("");
		foodType.setSelectedItem("Fruit");
		details.setText("");
	}
}
