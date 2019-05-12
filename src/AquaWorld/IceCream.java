package AquaWorld;

/**
 * 
 * @author steven, tanner, tymee, justin
 *
 *ice cream class
 */
public class IceCream {

	private String IceCreamFlavor;
	
	/**
	 * constructor that takes in a flavor for the ice cream
	 * @param flavor for the ice cream as a string
	 */
	public IceCream(String flavor) {
		this.IceCreamFlavor = flavor;
	}
	
	/**
	 * returns the flavor for the ice cream
	 * @return the flavor as a string
	 */
	public String getIceCreamFlavor() {
		return this.IceCreamFlavor;
	}
}
