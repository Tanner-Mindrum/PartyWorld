package AquaWorld;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the plat meal plan getting the description and the price for the plan
 */
public class platMeal extends MealPlan{

	@Override
	/**
	 * gets the description of the plat plan 
	 * @return the description as a string
	 */
	public String getDescription() {
		this.description = "Included in meal:\n\t-4 XL 4 Topping Gourment Pizzas\n\t-5 2L Soda Bottles\n\t-Salad\n\t-Bread-Sticks\n\t-Choice of 2 chicken wing flavors. Pick bone in or boneless\n\t-2 Flavors of Ice Cream(chocolate, vanilla, strawberry)\nCost: $150";
		return this.description;
	}

	@Override
	/**
	 * gets the cost of the plan
	 * @return the cost as a double
	 */
	public double getCost() {
		this.cost = 150;
		return this.cost;
	}

}
