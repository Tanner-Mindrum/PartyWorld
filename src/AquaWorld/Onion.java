package AquaWorld;

/**
 * 
 * @author steven, tymee, justin, tanner
 *
 */
public class Onion extends PizzaDecorator  {
	Pizza pizza;
	
	/**
	 * constructor that adds onions to the pizza
	 * @param pizza that will have onions added to it
	 */
	public Onion(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	/**
	 * gets the description of the pizza
	 * @return the pizza's description as a String
	 */
	public String getDescription() {
		return pizza.getDescription() + ", Onion";
	}
}
