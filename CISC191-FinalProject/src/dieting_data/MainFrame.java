package dieting_data;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

public class MainFrame extends JFrame{
	JFrame frame = new JFrame("Dieting Data");
	
	JPanel model = new JPanel();
	
	String date;
	JLabel dateLabel = new JLabel();
	
	JPanel waterPanel = new JPanel();
	JLabel waterLabel = new JLabel("Water");
	WaterProgress progressBar = new WaterProgress();
	JLabel waterCounter = new JLabel();
	
	JPanel inputPanel = new JPanel();
	JLabel inputLabel = new JLabel("Menu");
	
	
	/**
	 * MainFrame constuctor
	 * 
	 * @param input
	 */
	public MainFrame(String input) {
		//Setting the main JFrame size
		frame.setSize(850, 480);
		
		//Setting the layout for the main JPanel
		model.setLayout(new BorderLayout());
		//JLabel settings such as text, centering, and layout location
		dateLabel.setText(input);
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		model.add(dateLabel, BorderLayout.NORTH);
		
		//Adding components for the water panel going in West layout
		waterPanel.setLayout(new BorderLayout());
		waterCounter.setText(Integer.toString(progressBar.getWater()) + " oz");	
		//Water JLabel settings such centering
		waterLabel.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		waterPanel.add(waterLabel, BorderLayout.NORTH);
		waterPanel.add(progressBar, BorderLayout.CENTER);
		//Water counter JLabel settings such centering
		waterCounter.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		waterPanel.add(waterCounter, BorderLayout.SOUTH);
		model.add(waterPanel, BorderLayout.WEST);
		
		//Adding components for the inputs panel going in East layout
		inputPanel.setLayout(new BorderLayout());
		inputLabel.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		inputPanel.add(inputLabel, BorderLayout.NORTH);
		inputPanel.add(new InputBar(), BorderLayout.CENTER);
		model.add(inputPanel, BorderLayout.EAST);
		
		//Adding the overall border layout model to the main frame
		frame.add(model);
		
		//Settings for visible JFrame with closing capabilities
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/**
	 * date setter
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * date getter
	 * 
	 * @return
	 */
	public String getDate() {
		return date;
	}
}
