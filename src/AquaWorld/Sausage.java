package AquaWorld;

public class Sausage extends PizzaDecorator {
	Pizza pizza;
	public Sausage(Pizza pizza) {
		this.pizza = pizza;
	}
	public String getDescription() {
		return pizza.getDescription() + ", sausage";
	}
}
