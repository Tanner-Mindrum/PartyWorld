package AquaWorld;

public class Pineapple {
	
	Pizza pizza;
	
	public Pineapple(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	public String getDescription() {
		return pizza.getDescription() + ", pineapple";
	}
}
