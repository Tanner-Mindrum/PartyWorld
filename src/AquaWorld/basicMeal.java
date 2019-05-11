package AquaWorld;

public class basicMeal extends MealPlan {

    @Override
    public String getDescription() {
        description = "Included in meal:\n\t-3 XL 1 Topping Gourmet Pizzas\n\t-3 2L Soda Bottles\nCost: $65";
        return description;
    }

    @Override
    public double getCost() {
        
        cost = 65;
        return cost;
    }

}
