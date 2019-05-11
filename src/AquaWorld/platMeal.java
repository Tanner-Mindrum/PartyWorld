package AquaWorld;

public class platMeal extends MealPlan{

	@Override
	public String getDescription() {
		this.description = "Included in meal:\n\t4 XL 4 Topping Gourment Pizzas\n\t5 2L Soda Bottles\n\tSalad\n\tBread-Sticks\n\tChoice of 2 chicken wing flavors. Pick bone in or boneless\n\t2 Flavors of Ice Cream(chocolate, vanilla, strawberry)";
		return this.description;
	}

	@Override
	public double getCost() {
		this.cost = 150;
		return this.cost;
	}

}
