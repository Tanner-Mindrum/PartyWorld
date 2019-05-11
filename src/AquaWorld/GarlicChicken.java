package AquaWorld;

/**
 * 
 * @author steven, justin, tymee, tanner
 * 
 * adds garlic chicken as a topping to the pizza
 *
 */
public class GarlicChicken extends PizzaDecorator{
	
	Pizza pizza;
	
	/**
	 * the constructor for the garlicChicken class
	 * @param pizza as a parameter to add the topping to it
	 */
	public GarlicChicken(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	/**
	 * gets the info of the pizza
	 * @return the description as a string
	 */
	public String getDescription() {
		return pizza.getDescription() + ", garlic chicken";
	}
}
