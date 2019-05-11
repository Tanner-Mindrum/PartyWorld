package AquaWorld;

/**
 * 
 * @author steven, tanner, tymee, justin
 *
 *
 * adds mushrooms to the pizza as a topping
 */
public class Mushroom extends PizzaDecorator {
	
	Pizza pizza;
	
	/**
	 * constructor for the pizza that adds mushrooms to the pizza
	 * @param pizza to add the mushrooms to
	 */
	public Mushroom(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	/**
	 * gets the description of the pizza
	 * @return the description of the pizza as a string
	 */
	public String getDescription() {
		return pizza.getDescription() + ", Mushroom";
	}
}
