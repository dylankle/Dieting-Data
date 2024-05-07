package dieting_data;

import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class WaterProgress extends JProgressBar{
	int waterAmount = 0;
	
	/**
	 * WaterProgress constructor
	 */
	public WaterProgress() {
		setOrientation(SwingConstants.VERTICAL);
		
		setPreferredSize(new Dimension(150, 500));
		
		setBorderPainted(true);
		
		setMinimum(0);
		setMaximum(72);
		
		setValue(waterAmount);
	}
	
	/**
	 * waterAmount getter
	 * 
	 * @return
	 */
	public int getWater() {
		return waterAmount;
	}
	
	/**
	 * add @param oz to waterAmount
	 * 
	 * @param oz
	 */
	public void increaseWater(int oz) {
		waterAmount += oz;
	}
}
