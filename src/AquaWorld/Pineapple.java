package AquaWorld;

/**
 * 
 * @author steven, justin, tymee, tanner
 *
 *adds pineapple toppings to the pizza
 */
public class Pineapple extends PizzaDecorator{
	
	Pizza pizza;
	
	/**
	 * adds pineapple to the pizza (is the constructor)
	 * @param pizza to add the toping to
	 */
	public Pineapple(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	/**
	 * gets the description of the pizza
	 * @return the pizza's info as a string
	 */
	public String getDescription() {
		return pizza.getDescription() + ", Pineapple";
	}
}
