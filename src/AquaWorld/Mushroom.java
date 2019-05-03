package AquaWorld;

public class Mushroom extends PizzaDecorator {
	
	Pizza pizza;
	
	public Mushroom(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	public String getDescription() {
		return pizza.getDescription() + ", Mushroom";
	}
}
