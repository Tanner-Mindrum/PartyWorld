package AquaWorld;

public class goldMeal extends MealPlan{

	@Override
	public String getDescription() {
		this.description = "Included in meal: \n\t3XL 3 topping Gourment Pizzas\n\t5 2L Soda Bottles\n\tSalad\n\tBread-Sticks\n\tChoice of 2 chicken wing flavors(spicy mild, lemon-pepper, bbq, sesame, or diablo) pick bone in or boneless";
		return this.description;
	}

	@Override
	public double getCost() {
		this.cost = 120;
		return this.cost;
	}
	
}
