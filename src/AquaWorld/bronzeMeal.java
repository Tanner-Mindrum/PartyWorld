package AquaWorld;

import java.util.ArrayList;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the bronze meal plan getting the description and the price for the plan
 */
public class bronzeMeal extends MealPlan {

    private String breadStickOrSalad;
    private String soda1;
    private String soda2;
    private String soda3;
    private ArrayList<PizzaDecorator> pizza1;
    private ArrayList<PizzaDecorator> pizza2;
    private ArrayList<PizzaDecorator> pizza3;

    public bronzeMeal(String breadStickOrSalad, String soda1, String soda2, String soda3, ArrayList<PizzaDecorator> pizza1, ArrayList<PizzaDecorator> pizza2, ArrayList<PizzaDecorator> pizza3) {
        this.breadStickOrSalad = breadStickOrSalad;
        this.soda1 = soda1;
        this.soda2 = soda2;
        this.soda3 = soda3;
        this.pizza1 = pizza1;
        this.pizza2 = pizza2;
        this.pizza3 = pizza3;
    }

    public String getBreadStickOrSalad() {
        return breadStickOrSalad;
    }

    public String getSoda1() {
        return soda1;
    }

    public String getSoda2() {
        return soda2;
    }

    public String getSoda3() {
        return soda3;
    }

    public ArrayList<PizzaDecorator> getPizza1() {
        return pizza1;
    }

    public ArrayList<PizzaDecorator> getPizza2() {
        return pizza2;
    }

    public ArrayList<PizzaDecorator> getPizza3() {
        return pizza3;
    }

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
