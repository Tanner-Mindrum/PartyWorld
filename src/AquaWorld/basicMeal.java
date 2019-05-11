package AquaWorld;
/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the basic meal plan getting the description and the price for the plan
 */
public class basicMeal extends MealPlan {

    @Override
    /**
     * gets the description of the plan
     * @return the description as a string
     */
    public String getDescription() {
        description = "Included in meal:\n\t-3 XL 1 Topping Gourmet Pizzas\n\t-3 2L Soda Bottles\nCost: $65";
        return description;
    }

    @Override
    /**
     * gets the cost of the plan
     * @return the cost as a double
     */
    public double getCost() {
        
        cost = 65;
        return cost;
    }

}
