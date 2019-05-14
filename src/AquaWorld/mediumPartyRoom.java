package AquaWorld;

import java.util.ArrayList;
/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the medium party room that holds the waitlist and description 
 */
public class mediumPartyRoom extends PartyRoom {
	private mediumPartyRoom partyRoom; //This could be dangerous as it is already created by the factory
	private String Description = "Capacity: 45 people\nCost: $250/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n\t-DJ\n"
			+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $3 X (meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
			+ "-Projector\t\tCost: $10/hour\n\t-Party Decorations & set-Up       Cost: $100\n\t"
			+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern";
	ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();
	
	/**
	 * calculates the cost of the room
	 * @return the cost as a double
	 */
	public double calculateCost() {
		return 0;
	}

	/**
	 * reserves the room to a partygoer
	 * @return a PartyGoer
	 */
	public boolean reserveRoom(int month, int day, int year, int startTime, int endTime, PartyGoer partyGoer) {
		System.out.println("Reserved med room");
		return false;
	}

	/**
	 * sets the description of the room
	 * @param description as a String
	 */
	public void setDescription(String description) {
		Description = description;
	}
	
	/**
	 * adds to the waitlist
	 * @param partyGoer to tbe added to the waitlist
	 */
	public void addWaitList(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}
	
	/**
	 * gets the description of the room
	 * @return the description as a String
	 */
	public String getDescription() {
		return Description;
	}
	
	//We need to fix this for all classes

}
