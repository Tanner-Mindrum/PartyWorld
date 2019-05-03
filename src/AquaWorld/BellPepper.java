package AquaWorld;

public class BellPepper {
	
	Pizza pizza;
	
	public BellPepper(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	public String getDescription() {
		return pizza.getDescription() + ", bell pepper";
	}
}
