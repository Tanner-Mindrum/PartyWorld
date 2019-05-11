package AquaWorld;

/**
 * 
 * @author steven, tanner, tymee, justin
 *
 */
public class Jalapeno extends PizzaDecorator {
	Pizza pizza;
	
	public Jalapeno(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public String getDescription() {
		return pizza.getDescription() + ", Jalapeno";
	}
}
