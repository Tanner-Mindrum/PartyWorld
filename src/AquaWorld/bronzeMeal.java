package AquaWorld;
/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the bronze meal plan getting the description and the price for the plan
 */
public class bronzeMeal extends MealPlan {

    @Override
    /**
     * gets the description of the plan
     * @return the description as a string
     */
    public String getDescription() {
        description = "Included in meal:\n\t-3 XL 2 Topping Gourmet Pizzas\n\t-5 2L Soda Bottles\n\t-Salad or bread-sticks\nCost: $75";
        return description;
    }

    @Override
    /**
     * gets the cost of the plan
     * @return the cost as a double
     */
    public double getCost() {
        cost = 75;
        return cost; 
    }


}
