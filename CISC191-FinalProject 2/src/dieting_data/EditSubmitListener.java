package dieting_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
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
	JTextArea details;
	Food currentButton;
	
	/**
	 * EditSubmitListener constructor
	 * 
	 * @param frame
	 * @param name
	 * @param foodType
	 * @param details
	 * @param currentButton
	 */
	public EditSubmitListener(MainFrame frame, JTextField name, JComboBox foodType, JTextArea details, Food currentButton) {
		this.frame = frame;
		this.name = name;
		this.foodType = foodType;
		this.details = details;
		this.currentButton = currentButton;
	}

	/**
	 * Reacts to the EDIT button in the edit selected mode
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(name.getText().isEmpty() || name.getText().length() > 30)
				throw new NameInputException("Name");
			else {
				frame.submitEditFood(name.getText(), (String)foodType.getSelectedItem(), details.getText(), currentButton);
				name.setText("");
				foodType.setSelectedItem("Fruit");
				details.setText("");
			}
		}
		catch(NameInputException nameInput) {
			JOptionPane.showMessageDialog(frame, "No name was entered or\n name is too long\n(character limit:30)", "Name Error", JOptionPane.WARNING_MESSAGE);
		}
	}
}
