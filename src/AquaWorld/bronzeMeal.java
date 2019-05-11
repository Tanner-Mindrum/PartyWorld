package AquaWorld;

public class bronzeMeal extends MealPlan {

    @Override
    public String getDescription() {
        description = "Included in meal:\n\t-3 XL 2 Topping Gourmet Pizzas\n\t-5 2L Soda Bottles\n\t-Salad or bread-sticks\nCost: $75";
        return description;
    }

    @Override
    public double getCost() {
        cost = 75;
        return cost; 
    }


}
