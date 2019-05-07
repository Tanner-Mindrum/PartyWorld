package AquaWorld;

public class Pepperoni extends PizzaDecorator {
	
	Pizza pizza;
	public Pepperoni(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	public String getDescription() {
		return pizza.getDescription() + ", Pepperoni";
	}
}
