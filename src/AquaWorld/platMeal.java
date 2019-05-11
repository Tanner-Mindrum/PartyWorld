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
		this.description = "Included in meal:\n\t4 XL 4 Topping Gourment Pizzas\n\t5 2L Soda Bottles\n\tSalad\n\tBread-Sticks\n\tChoice of 2 chicken wing flavors. Pick bone in or boneless\n\t2 Flavors of Ice Cream(chocolate, vanilla, strawberry)\n\t$150";
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
