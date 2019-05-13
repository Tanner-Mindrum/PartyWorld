package AquaWorld;

import java.util.ArrayList;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the gold meal plan getting the description and the price for the plan
 */
public class goldMeal extends MealPlan {

	private boolean breadStickOrSalad;
	private String soda1;
	private String soda2;
	private String soda3;
	private String soda4;
	private String soda5;
	private ArrayList<PizzaDecorator> pizza1;
	private ArrayList<PizzaDecorator> pizza2;
	private ArrayList<PizzaDecorator> pizza3;
	private String wingFlavor;
	private String boneInorOut;

	public goldMeal(boolean breadStickOrSalad, String soda1, String soda2, String soda3, String soda4, String soda5, ArrayList<PizzaDecorator> pizza1, ArrayList<PizzaDecorator> pizza2, ArrayList<PizzaDecorator> pizza3, String wingFlavor, String boneInorOut) {
		this.breadStickOrSalad = breadStickOrSalad;
		this.soda1 = soda1;
		this.soda2 = soda2;
		this.soda3 = soda3;
		this.soda4 = soda4;
		this.soda5 = soda5;
		this.pizza1 = pizza1;
		this.pizza2 = pizza2;
		this.pizza3 = pizza3;
		this.wingFlavor = wingFlavor;
		this.boneInorOut = boneInorOut;
	}

	public boolean isBreadStickOrSalad() {
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

	public String getSoda4() {
		return soda4;
	}

	public String getSoda5() {
		return soda5;
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

	public String getWingFlavor() {
		return wingFlavor;
	}

	public String getBoneInorOut() {
		return boneInorOut;
	}

	@Override
	/**
	 * gets the description 
	 * @return the description as a string
	 */
	public String getDescription() {
		this.description = "Included in meal: \n\t-3XL 3 Topping Gourment Pizzas\n\t-5 2L Soda Bottles\n\t-Salad\n\t-Bread-Sticks\n\t-Choice of 2 chicken wing flavors(spicy mild, lemon-pepper, bbq, sesame, or diablo) pick bone in or boneless\nCost: $120";
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
