package AquaWorld;

/**
 * 
 * @author steven, tanner, tymee, justin
 *
 *adds the jalepeno topping to the pizza
 */
public class Jalapeno extends PizzaDecorator {
	Pizza pizza;
	
	/**
	 * the constructor for the Jalepeno class, takes in the pizza to add the topping to it
	 * @param pizza to add the topping to it
	 */
	public Jalapeno(Pizza pizza) {
		this.pizza = pizza;
	}
	
	/**
	 * gets the description of the pizza
	 * @return the pizza's description as a string
	 */
	public String getDescription() {
		return pizza.getDescription() + ", Jalapeno";
	}
}
