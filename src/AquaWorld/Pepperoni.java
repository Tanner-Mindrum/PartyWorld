package AquaWorld;

/**
 * 
 * @author steven ,tanner, justin, tymee
 *
 *adds peperoni toppings to a pizza
 */
public class Pepperoni extends PizzaDecorator {
	
	Pizza pizza;
	/**
	 * constructor for this class to add the pepperoni topping
	 * @param pizza to add the pepperoni topping to
	 */
	public Pepperoni(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	/**
	 * gets the description of the class
	 * @return the pizza's description as a string 
	 */
	public String getDescription() {
		return pizza.getDescription() + ", Pepperoni";
	}
}
