package AquaWorld;

import java.util.ArrayList;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the room for adult billiards
 */
public class AdultBilliardsLounge extends PartyRoom {
	private String Restrictions = "21+ only";
	private AdultBilliardsLounge partyRoom;
	private String Description = "Capacity: 10 people\nCost: $25/hr\nIncluded in cost:\n\t-Access to the pool table and cues\n"
			+ "Upgrades Available:\n\t-Add Meal Plan\tCost: $(meal plan cost)\n\nRestrictions:\n\t-21+ only";
	ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();


	/**
	 * gets the description of the room
	 * @return the description as a String
	 */
	public String getDescription() {
		return Description; 
	}
	
	/**
	 * gets the restriction of the room as a String
	 * @return the restrictions as a String
	 */
	public String getRestriction() {
		return Restrictions;
	}
	
	/**
	 * adds a party goer to the room's waitlist
	 * @param partyGoer as a parameter to be added to the list
	 */
	public void addWaitList(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}
	
	/**
	 * calculates the cost of the room
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

}
