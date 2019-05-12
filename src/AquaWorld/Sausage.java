package AquaWorld;

/**
 * 
 * @author steve
 *
 * sausage that is to be added as a topping to the pizza
 */
public class Sausage extends PizzaDecorator {
	Pizza pizza;
	/**
	 * constructor that adds the sausage topping to the pizza
	 * @param pizza to add the topping to
	 */
	public Sausage(Pizza pizza) {
		this.pizza = pizza;
	}
	
	/**
	 * gets the pizzas whole description
	 * @return the description as a string
	 */
	public String getDescription() {
		return pizza.getDescription() + ", Sausage";
	}
}
