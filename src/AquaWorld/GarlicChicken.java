package AquaWorld;

public class GarlicChicken {
	
	Pizza pizza;
	
	public GarlicChicken(Pizza pizza) {
		this.pizza = pizza; 
	}
	
	public String getDescription() {
		return pizza.getDescription() + ", garlic chicken";
	}
}
