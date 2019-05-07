package AquaWorld;

public class Ham extends PizzaDecorator {
	Pizza pizza;
	
	public Ham(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public String getDescription() {
		return pizza.getDescription() + ", Ham";
	}
}
