package AquaWorld;
/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the basic meal plan getting the description and the price for the plan
 */

public class basicMeal extends MealPlan {

    private String soda1;
    private String soda2;
    private String soda3;
    private String pizza1;
    private String pizza2;
    private String pizza3;

    public basicMeal(String soda1, String soda2, String soda3, String pizza1, String pizza2, String pizza3) {
        this.soda1 = soda1;
        this.soda2 = soda2;
        this.soda3 = soda3;
        this.pizza1 = pizza1;
        this.pizza2 = pizza2;
        this.pizza3 = pizza3;
    }

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
