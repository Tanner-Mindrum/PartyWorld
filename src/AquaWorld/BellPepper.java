package AquaWorld;

/**
 * 
 * @author steve, tanner justin tymee
 *
 *the bellpepper frame to add as a topping to the pizza
 */
public class BellPepper extends PizzaDecorator{
	
	Pizza pizza;
	
	/**
	 * constructor for the bellPepper frame, takes in a pizza to add a bellPepper topping to it
	 * @param pizza to add to the toppings
	 */
	public BellPepper(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	/**
	 * gets the information about the pizza
	 * @return the pizza's description as a string
	 */
	public String getDescription() {
		return pizza.getDescription() + ", bell pepper";
	}
}
