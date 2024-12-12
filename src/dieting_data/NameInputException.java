package dieting_data;

/**
 * NameInputException class extends Exception
 * 
 * This class is a custom exception for name inputs
 * @see EditSelectedListener actionPerformed
 * @see AddFoodListener actionPerformed
 */
public class NameInputException extends Exception{
	String input;
	
	/**
	 * NameInputException constructor
	 * 
	 * @param either
	 */
	public NameInputException(String either) {
		input = either;
	}
}
