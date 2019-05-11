package AquaWorld;

/**
 * 
 * @author steven, tanner, tymee, Justin
 * 
 * adds ham to the pizza class
 *
 */
public class Ham extends PizzaDecorator {
	Pizza pizza;
	
	/**
	 * adds the topping to the pizza
	 * @param pizza to add the topping to it
	 */
	public Ham(Pizza pizza) {
		this.pizza = pizza;
	}
	
	/**
	 * gets the description of the pizza
	 * @return the description as a string
	 */
	public String getDescription() {
		return pizza.getDescription() + ", Ham";
	}
}
