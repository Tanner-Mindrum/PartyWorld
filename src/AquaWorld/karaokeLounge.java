package AquaWorld;

import java.util.ArrayList;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the kareoke class that holds the waitlist, has a description and holds a kareoke lounge type
 */
public class karaokeLounge extends PartyRoom {
	private karaokeLounge partyRoom;
	private String Description = "Capacity: 10 people\nCost: $30/hr\nIncluded in cost:\n\t-Access to the karaoke machine\n"
	+ "Upgrades Available:\n\t-Add Meal Plan\tCost: $(meal plan cost)\n";
	ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();

	/**
	 * calculates the cost of the lounge
	 * @return the cost as a double
	 */
	public double calculateCost() {
		return 0;
	}

	@Override
	/**
	 * reserves the room to a partygoer
	 * @return a PartyGoer
	 */
	public boolean reserveRoom(int month, int day, int year, int startTime, int endTime, PartyGoer partyGoer) {
		return false;
	}

	/**
	 * gets the description of the lounge
	 * @return the description as a String
	 */
	public String getDescription() {
		return Description;
	}
	
	/**
	 * adds the partyGoer to the waitlist
	 * @param partyGoer thats to be added to the list
	 */
	public void addWaitList(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}

	/**
	 * the to string method returning the info as a string
	 * @return the info as a string
	 */
	public String toString() {
		return "Capacity: 10 people\nCost: $30/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n";
//				+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
//				+ "-Projector\t\tCost: $10/hour\n\t-Party Decorations & set-Up       Cost: $100\n\t"
//				+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern";;

//		return "Capacity: 30 people\nCost: $150/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n"
//				+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
//				+ "-Projector\t\tCost: $10/hour\n\t-Party Decorations & set-Up       Cost: $100\n\t"
//				+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern";
	}
}
