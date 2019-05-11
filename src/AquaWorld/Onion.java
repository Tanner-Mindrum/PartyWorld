package AquaWorld;

public class Onion extends PizzaDecorator  {
	Pizza pizza;
	
	public Onion(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	public String getDescription() {
		return pizza.getDescription() + ", Onion";
	}
}
