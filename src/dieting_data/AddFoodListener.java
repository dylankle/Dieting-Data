package dieting_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * AddFoodListener class implements ActionListener
 *
 * Takes the user data from AddFoodPanel and sends String
 * values to addFood method
 * @see MainFrame
 */
public class AddFoodListener implements ActionListener{
	MainFrame frame;
	JTextField name;
	JComboBox foodType;
	JTextArea details;
	
	/**
	 * AddFoodListener constructor
	 * 
	 * @param frame
	 * @param name
	 * @param foodType
	 * @param details
	 */
	public AddFoodListener(MainFrame frame, JTextField name, JComboBox foodType, JTextArea details) {
		this.frame = frame;
		this.name = name;
		this.foodType = foodType;
		this.details = details;
	}
	
	/**
	 * Reacts to ADD button in the add mode
	 * @throws NameInputException
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//If empty or over 30 chars throw exception
			if(name.getText().isEmpty() || name.getText().length() > 30)
				throw new NameInputException("Name");
			else {
				//Else updates data and resets boxes
				frame.addFood(name.getText(), (String)foodType.getSelectedItem(), details.getText());
				name.setText("");
				foodType.setSelectedItem("Fruit");
				details.setText("");
			}
		}
		catch(NameInputException nameInput) {
			//JOptionPane to show error message
			JOptionPane.showMessageDialog(frame, "No name was entered or\n name is too long\n(character limit:30)", "Name Error", JOptionPane.WARNING_MESSAGE);
		}
	}
}
