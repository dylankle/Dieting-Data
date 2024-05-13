package dieting_data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

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
	}
}
