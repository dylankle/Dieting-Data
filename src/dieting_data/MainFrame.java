package dieting_data;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import java.util.ArrayList;

import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * MainFrame class
 * 
 * main method located here
 * [RUN HERE]
 * 
 * current main JFrame along with its JPanels are located here
 * BorderLayout for the most part
 * 
 * CardLayout for the BorderLayout.EAST because we need to switch
 * that panel out multiple times
 * 	- Add/Edit/View/Done
 * @see AddModeListener class
 *  - Add Food Mode OR Add Water Mode
 *  - Select item to edit
 *  - Edit selected item
 *  - Select item to view
 * Total Cards: 6
 * 
 * Methods that update the GUI are at the bottom (above the main method) They are all called by
 * different listeners. Each one forcing a different card to be shown based
 * on the previous button press.
 */
public class MainFrame extends JFrame{
	//JFrame field
	JFrame frame = new JFrame("Dieting Data");
	
	//JPanel field
	JPanel model = new JPanel();
	
	//date field for BorderLayout.NORTH to indicate data
	String date;
	JLabel dateLabel = new JLabel();
	
	//panel for BorderLayout.WEST that has a 2 labels and progress bar
	JPanel waterPanel = new JPanel();
	JLabel waterLabel = new JLabel("Water");
	WaterProgress progressBar = new WaterProgress();
	JLabel waterCounter = new JLabel();
	
	//FoodPanel field that stores JButtons
	FoodPanel foodPanel = new FoodPanel(this);
	
	//panel for BorderLayout.EAST that uses a CardLayout to switch between menus
	JPanel menuBar = new JPanel();
	CardLayout mainInputMenu = new CardLayout();
	//add,view,edit, or done panel
	InputPanel card1;
	//add food panel
	AddFoodPanel card2 = new AddFoodPanel(this);
	//add water panel
	AddWaterPanel card3 = new AddWaterPanel(this);
	//select food to edit panel
	EditModePanel card4 = new EditModePanel(this);
	//edit selected food panel
	EditSelectedPanel card5;
	//select food to view panel
	ViewModePanel card6 = new ViewModePanel(this);
	
	/**
	 * MainFrame constuctor
	 * 
	 * @param input
	 */
	public MainFrame(String date) {
		this.date = date;
		
		//Setting the main JFrame size
		frame.setSize(850, 480);
		
		//Setting the layout for the main JPanel
		model.setLayout(new BorderLayout());
		//JLabel settings such as text, centering, and layout location
		dateLabel.setText("\n" + date + "\n");
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		dateLabel.setBorder(BorderFactory.createLineBorder(Color.black));
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
		waterPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		model.add(waterPanel, BorderLayout.WEST);
		
		//Creating instance of FoodPanel class
		model.add(foodPanel, BorderLayout.CENTER);
		
		//Adding cards to card layout and adding panel with that layout to the main JPanel
		card1 = new InputPanel(this, model);
		menuBar.setLayout(mainInputMenu);
		menuBar.add(card1, "input");
		menuBar.add(card2, "addFood");
		menuBar.add(card3, "addWater");
		menuBar.add(card4, "edit");
		menuBar.add(card6, "view");
		//menuBar.add(card5, "editSelected");
		model.add(menuBar, BorderLayout.EAST);
		
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
	
	/**
	 * changes from the other modes back to the original input menu in case an accidental 
	 * button press.
	 * @see AddFoodPanel, AddWaterPanel, EditModePanel, EditSelectedPanel, ViewModePanel
	 * 		classes
	 */
	public void goBacktoInputPanel() {
		mainInputMenu.show(menuBar, "input");
	}
	
	/**
	 * actionPerformed in AddModeListener calls this to open a JOptionPane
	 * to check if the user wants to add food or water. The pane has a GridLayout
	 * of 3 rows and 1 column.
	 *  - Food or Water?
	 *  - O Food
	 *  @see AddFoodPanel class
	 *  - O Water
	 *  @see AddWaterPanel class
	 *      [OK]
	 *      
	 * if the "food" button was selected the CardLayout would switch to an
	 * instance of the addFoodPanel class.
	 * 
	 * if the "water" button was selected the CardLayout would switch to an
	 * instance of the addWaterPanel class.
	 */
	public void addTypeMode() {
		//Panel for food or water in JOptionPane
		JPanel itemType = new JPanel();
		itemType.setLayout(new GridLayout(3, 1));
		
		//Customize panel
		JLabel typeLabel = new JLabel("Food or Water");
		ButtonGroup group = new ButtonGroup();
		JRadioButton food = new JRadioButton("Food");
		JRadioButton water = new JRadioButton("Water");
		group.add(food);
		group.add(water);	
		
		itemType.add(water, 0, 0);
		itemType.add(food, 1, 0);
		itemType.add(typeLabel, 2, 0);
		
		JOptionPane.showMessageDialog(null, itemType);
		
		if (food.isSelected()) {
			//Turn CardLayout to add menu
			mainInputMenu.show(menuBar, "addFood");
		}
		
		if (water.isSelected()) {
			//Turn CardLayout to edit menu
			mainInputMenu.show(menuBar, "addWater");
		}
			
	}
	
	/**
	 * Creates a new Food object with the inputted data, adds it to the ArrayList in
	 * the FoodPanel class, and resets it back to the original input menu. 
	 * @see AddFoodListener class
	 * 
	 * @param name
	 * @param type
	 * @param details
	 */
	public void addFood(String name, String type, String details) {
		Food newFood = new Food(name, type, details);
		foodPanel.addItem(newFood);
		
		//Reset CardLayout to original input menu
		mainInputMenu.show(menuBar, "input");
	}
	
	/**
	 * Updates the static field of waterAmount in the WaterProgress class with the inputted
	 * data. Updates the JLabel in this class with the new waterAmount. Resets it back to the
	 * original input menu.
	 * @see AddWaterListener class
	 * 
	 * @param amount
	 */
	public void addWater(int amount) {
		progressBar.increaseWater(amount);
		progressBar.setValue(progressBar.getWater());
		waterCounter.setText(Integer.toString(progressBar.getWater()) + " oz");
		
		//Reset CardLayout to original input menu
		mainInputMenu.show(menuBar, "input");
	}
	
	/**
	 * Calls the CardLayout card for the edit mode instructions and enables the buttons for
	 * selecting.
	 * @see EditModeListener
	 */
	public void editMode() {
		foodPanel.setEditOrView("edit");
		mainInputMenu.show(menuBar, "edit");
		
		//Enables all the buttons
		foodPanel.enableButtons();
	}
	
	/**
	 * Creates the an EditSelectedPanel with the selected item and changes the edit instructions
	 * panel to a panel with JTextFields to change the Strings.
	 * @see ButtonListener class
	 * 
	 * @param currentButton
	 */
	public void editSelected(Food currentButton) {
		card5 = new EditSelectedPanel(this, currentButton);
		menuBar.add(card5, "editSelected");
		
		//Turn CardLayout to edit name, type, and details menu
		mainInputMenu.show(menuBar, "editSelected");
	}
	
	/**
	 * Updates the selected item's data from the Food class' methods such as the name, type, and
	 * detail setters. Disables the all the buttons, and changes it back to the original input
	 * menu.
	 * @see EditSubmitListener class
	 * 
	 * @param name
	 * @param type
	 * @param details
	 * @param currentButton
	 */
	public void submitEditFood(String name, String type, String details, Food currentButton) {
		currentButton.setText(name);
		currentButton.setName(name);
		currentButton.setType(type);
		currentButton.setDetails(details);
		foodPanel.disableButtons();
		repaint();
		
		//Reset CardLayout to original input menu
		mainInputMenu.show(menuBar, "input");
	}
	
	/**
	 * Calls the CardLayout card for the view mode instructions and enables the buttons for
	 * selecting.
	 * @see ViewModeListener 
	 */
	public void viewMode() {
		foodPanel.setEditOrView("view");
		mainInputMenu.show(menuBar, "view");
		
		//Enables all buttons
		foodPanel.enableButtons();
	}
	
	/**
	 * Opens a JOptionPane and shows the name, type, and details of the selected button.
	 * @see ButtonListener class
	 * 
	 * @param currentButton
	 */
	public void viewSelected(Food currentButton) {
		JOptionPane.showMessageDialog(null, currentButton.toString());
		foodPanel.disableButtons();
		
		//Reset CardLayout to original input menu
		mainInputMenu.show(menuBar, "input");
	}
	
	/**
	 * Creates a file, finds the correct directory, and gets the time to create a file
	 * that takes all the data from the accumulating ArrayList from foodPanel. All the data
	 * is exported as a .txt file.
	 * @see DoneModeListener
	 */
	public void doneMode() {
		String time = "";
		String hour = "";
		String min = "";
		
		//Setting the time field based on worldtimeapi
		try {
			Scanner scr = new Scanner(new URL("http://worldtimeapi.org/api/ip").openStream());
			
			while(scr.hasNext())
				time += scr.next();
			
			time = time.substring(time.indexOf("\"datetime\":", 0) + 23, 
					time.indexOf("\"datetime\":\"", 0) + 28);
			
			hour = ((Integer)(Integer.parseInt(time.substring(0, 2)) % 12)).toString();
			min = time.substring(3);
			
			if (Integer.parseInt(time.substring(0, 2)) > 12)
				time = hour + "-" + min + "PM";
			else
				time = hour + "-" + min + "AM";
		} catch (Exception e){
			time = "";
		}
		
		//Get user downloads directory 
		String userHome = System.getProperty("user.home");
		String path = userHome + "/Downloads/" + time + "_" + date + "_DietingData.txt";
		
		System.out.println(path);
		
		//Changes time back to ":" instead of "-"
		time = time.replace("-", ":");
		
		//Uses PrintWriter to edit a txtfile, produces a JOptionPane message, and closes program
		try (PrintWriter out = new PrintWriter(new FileWriter(path))){
			out.println(foodPanel.export(date, WaterProgress.waterAmount));
			out.close();
			
			JOptionPane.showMessageDialog(this, "All your data for " + date + 
												" has been exported to your downloads folder at " + time + "!");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		String date = "";
		
		//Gets the date from worldtimeapi
		try {
			Scanner scr = new Scanner(new URL("http://worldtimeapi.org/api/ip").openStream());
		
			while (scr.hasNext())
				date += scr.next();
		
			String month = date.substring(date.indexOf("\"datetime\":", 0) + 17,
										  date.indexOf("\"datetime\":\"", 0) + 19);
			String day = date.substring(date.indexOf("\"datetime\":", 0) + 20, 
										date.indexOf("\"datetime\":\"", 0) + 22);
			String year = date.substring(date.indexOf("\"datetime\":", 0) + 12,
										 date.indexOf("\"datetime\":\"", 0) + 16);
			
			date = month + "-" + day + "-" + year;
		}
		catch (Exception e)
		{
			date = "";
		}
		finally {
			new MainFrame(date);
			JOptionPane.showMessageDialog(null, "Welcome to Dieting Data!\n\n"
											  + "Here you can document the food you eat and the water you drink.\n"
											  + " - Add mode allows you to add foods and water you consume.\n"
											  + " - Edit mode allows you to edit your added foods.\n"
											  + " - View mode allows you to look at the items you added.\n"
											  + "The [Done] button at the bottom will export all your data to your downloads folder!\n\n"
											  + "Enjoy! :D", 
										  "Welcome to Dieting Data!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
