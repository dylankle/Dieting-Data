package dieting_data;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SetDate extends JFrame{
	static String date;
	
	/**
	 * SetDate constructor
	 */
	public SetDate() {
		String resp = "Welcome to Dieting Data!";
		
		date = JOptionPane.showInputDialog(resp, "Enter the date:");                         
	}
	
	/**
	 * main method, compilation starts with asking for the date
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//start request
		new SetDate();
		
		//main frame of the application opens after date is entered
		MainFrame frame = new MainFrame(date);
	}
}
