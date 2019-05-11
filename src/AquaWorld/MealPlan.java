package AquaWorld;

public abstract class MealPlan {
	private double mealCost;
	private platMeal platMeal;
	private basicMeal basicMeal;
	private goldMeal goldMeal;
	private bronzeMeal bronzeMeal;
	private silverMeal silverMeal;

	protected String description; 
	protected double cost; 

	public abstract String getDescription();

	public abstract double getCost();
}
