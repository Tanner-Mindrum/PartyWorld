package AquaWorld;

public class silverMeal extends MealPlan{

    @Override
    public String getDescription() {
        description = "Included in meal:\n\t-3 XL 3 Topping Gourmet Pizzas\n\t-5 2L Soda Bottles\n\t-Salad\n\t-Bread-sticks\nCost: $90";
        return description;
    }

    @Override
    public double getCost() {
        cost = 90;
        return cost;
    }

}
