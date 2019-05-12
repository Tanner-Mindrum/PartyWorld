package AquaWorld;

/**
 * 
 * @author steven, tanner, justin, tymee
 *
 * the wings that holds its flavor
 */
public class Wings {

	private String wingsDescription;
	
	/**
	 * constructor that takes in that flavor of the string
	 * @param flavor of the wings as a string
	 */
	public Wings(String flavor) {
		this.wingsDescription = flavor;
	}
	
	/**
	 * gets the flavor of the wings
	 * @return the flavor as a string
	 */
	public String getWingFlavor() {
		return this.wingsDescription;
	}
}
