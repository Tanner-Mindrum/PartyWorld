package AquaWorld;

import java.util.ArrayList;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the plat meal plan getting the description and the price for the plan
 */
public class platMeal extends MealPlan {

	private boolean breadStickOrSalad;
	private String soda1;
	private String soda2;
	private String soda3;
	private String soda4;
	private String soda5;
	private ArrayList<PizzaDecorator> pizza1;
	private ArrayList<PizzaDecorator> pizza2;
	private ArrayList<PizzaDecorator> pizza3;
	private ArrayList<PizzaDecorator> pizza4;
	private String wingFlavor;
	private String boneInorOut;
	private String iceCream1;
	private String iceCream2;

	public platMeal(boolean breadStickOrSalad, String soda1, String soda2, String soda3, String soda4, String soda5, ArrayList<PizzaDecorator> pizza1, ArrayList<PizzaDecorator> pizza2, ArrayList<PizzaDecorator> pizza3, ArrayList<PizzaDecorator> pizza4, String wingFlavor, String boneInorOut, String iceCream1, String iceCream2) {
		this.breadStickOrSalad = breadStickOrSalad;
		this.soda1 = soda1;
		this.soda2 = soda2;
		this.soda3 = soda3;
		this.soda4 = soda4;
		this.soda5 = soda5;
		this.pizza1 = pizza1;
		this.pizza2 = pizza2;
		this.pizza3 = pizza3;
		this.pizza4 = pizza4;
		this.wingFlavor = wingFlavor;
		this.boneInorOut = boneInorOut;
		this.iceCream1 = iceCream1;
		this.iceCream2 = iceCream2;
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

	public ArrayList<PizzaDecorator> getPizza4() {
		return pizza4;
	}

	public String getWingFlavor() {
		return wingFlavor;
	}

	public String getBoneInorOut() {
		return boneInorOut;
	}

	public String getIceCream1() {
		return iceCream1;
	}

	public String getIceCream2() {
		return iceCream2;
	}

	@Override
	/**
	 * gets the description of the plat plan 
	 * @return the description as a string
	 */
	public String getDescription() {
		this.description = "Included in meal:\n\t-4 XL 4 Topping Gourment Pizzas\n\t-5 2L Soda Bottles\n\t-Salad\n\t-Bread-Sticks\n\t-Choice of 2 chicken wing flavors. Pick bone in or boneless\n\t-2 Flavors of Ice Cream(chocolate, vanilla, strawberry)\nCost: $150";
		return this.description;
	}

	@Override
	/**
	 * gets the cost of the plan
	 * @return the cost as a double
	 */
	public double getCost() {
		this.cost = 150;
		return this.cost;
	}

}
