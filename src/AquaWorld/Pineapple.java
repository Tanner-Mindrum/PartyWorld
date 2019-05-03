package AquaWorld;

public class Pineapple extends PizzaDecorator{
	
	Pizza pizza;
	
	public Pineapple(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	public String getDescription() {
		return pizza.getDescription() + ", Pineapple";
	}
}
