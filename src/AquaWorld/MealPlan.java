package AquaWorld;

/**
 * 
 * @author steven, tanner, justin, tymee
 *
 * the abstract meal plan to make meal plans
 */
public abstract class MealPlan {
	private double mealCost;
	private platMeal platMeal;
	private basicMeal basicMeal;
	private goldMeal goldMeal;
	private bronzeMeal bronzeMeal;
	private silverMeal silverMeal;

	protected String description; 
	protected double cost; 

	/**
	 * gets the description of the meal plan
	 * @return the plan as a string
	 */
	public abstract String getDescription();

	/**
	 * gets the cost of the meal plan
	 * @return the meal plan's cost as a double
	 */
	public abstract double getCost();
}
