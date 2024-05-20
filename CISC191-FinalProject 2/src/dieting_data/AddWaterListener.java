package dieting_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * AddWaterListener class implements ActionListener
 *
 * Takes the user data from AddWaterPanel and sends Integer
 * value to addWater method
 * @see MainFrame
 */
public class AddWaterListener implements ActionListener{
	MainFrame frame;
	JTextField amount;
	
	public AddWaterListener(MainFrame frame, JTextField amount) {
		this.frame = frame;
		this.amount = amount;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.addWater(Integer.valueOf(amount.getText()));
		
		amount.setText("");
	}
}
