package AquaWorld;
// i love cheeeze
public class Cheese extends PizzaDecorator {
	
	Pizza pizza; 
	public Cheese(Pizza pizza) {
		this.pizza = pizza; 
	}
	public String getDescription() {
		return pizza.getDescription() + ", Cheese";
	}	
}