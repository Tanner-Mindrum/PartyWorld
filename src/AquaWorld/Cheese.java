package AquaWorld;
// i love cheeeze
/**
 * 
 * @author steve, tanner, justin, tymee
 *
 */
public class Cheese extends PizzaDecorator {
	
	Pizza pizza; 
	
	/**
	 * adds cheese to the pizza, is the constructor for the cheese class
	 * @param pizza
	 */
	public Cheese(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	/**
	 * gets the new description of the pizza
	 * @return the pizza's description as a String
	 */
	public String getDescription() {
		return pizza.getDescription() + ", Cheese";
	}	
}