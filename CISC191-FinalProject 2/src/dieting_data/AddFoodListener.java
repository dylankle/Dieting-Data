package dieting_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
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
	JTextField details;
	
	public AddFoodListener(MainFrame frame, JTextField name, JComboBox foodType, JTextField details) {
		this.frame = frame;
		this.name = name;
		this.foodType = foodType;
		this.details = details;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.addFood(name.getText(), (String)foodType.getSelectedItem(), details.getText());
		
		name.setText("");
		foodType.setSelectedItem("Fruit");
		details.setText("");
	}
}
