package dieting_data;

import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class WaterProgress extends JProgressBar{
	static int waterAmount = 0;
	
	/**
	 * WaterProgress constructor
	 */
	public WaterProgress() {
		//customizing the JProgressBar: orientation, size, paint
		setOrientation(SwingConstants.VERTICAL);
		setPreferredSize(new Dimension(150, 500));
		setBorderPainted(true);
		
		//setting WaterProgress mins and max
		setMinimum(0);
		setMaximum(104);
		
		//set the initial WaterProgress to 0
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
