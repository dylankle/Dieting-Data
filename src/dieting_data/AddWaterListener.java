package dieting_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
	
	/**
	 * AddWaterListener constructor
	 * 
	 * @param frame
	 * @param amount
	 */
	public AddWaterListener(MainFrame frame, JTextField amount) {
		this.frame = frame;
		this.amount = amount;
	}
	
	/**
	 * Reacts to the ADD button in the add water mode
	 * @throws NumberFormatException
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			frame.addWater(Integer.valueOf(amount.getText()));
		} 
		catch (NumberFormatException notInteger) {
			JOptionPane.showMessageDialog(frame, "Enter an integer...", "Invalid Amount Entered", JOptionPane.WARNING_MESSAGE);
		} 
		finally {
			amount.setText("");
		}
	}
}
