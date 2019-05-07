package AquaWorld;

public class Jalapeno extends PizzaDecorator {
	Pizza pizza;
	
	public Jalapeno(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public String getDescription() {
		return pizza.getDescription() + ", Jalapeno";
	}
}
