package AquaWorld;
/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the gold meal plan getting the description and the price for the plan
 */
public class goldMeal extends MealPlan{

	@Override
	/**
	 * gets the description 
	 * @return the description as a string
	 */
	public String getDescription() {
		this.description = "Included in meal: \n\t3XL 3 Topping Gourment Pizzas\n\t5 2L Soda Bottles\n\tSalad\n\tBread-Sticks\n\tChoice of 2 chicken wing flavors(spicy mild, lemon-pepper, bbq, sesame, or diablo) pick bone in or boneless\n\t $120";
		return this.description;
	}

	@Override
	/**
	 * gets the cost
	 * @return the cost as a double
	 */
	public double getCost() {
		this.cost = 120;
		return this.cost;
	}
	
}
