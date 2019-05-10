package AquaWorld;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the decorator class for the pizza that gets its description
 */
public abstract class PizzaDecorator extends Pizza{
	
	/**
	 * abstract method that gets the description
	 * @return the description as a string
	 */
	public abstract String getDescription();
}
