package AquaWorld;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the aquaWorldRoom class that holds the wait list, the restrictions, 
 * description and the single instance attributes
 */
public class AquaWorldRoom extends PartyRoom{
	private String restrictions;
	private static AquaWorldRoom singleInstance = null; 
	private String description;
	private ArrayList<PartyGoer> waitList = new ArrayList<PartyGoer>();

	/**
	 * constructor of the aquaworldroom
	 */
	private AquaWorldRoom() {
		restrictions = "To access water facilities, bathing suits must be worn at all times.";
		description = "Capacity: 75 people\nCost: $700/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n\t-access to showers/lockers\n\t"
				+ "-life guards on duty\n\t-DJ\n"
				+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
				+ "-Projector\t\tCost: $10/hour\n\t-Towel Rental\t\tCost: $2 each\n\t-Party Decorations & set-Up       Cost: $100\n\t"
				+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern\nRestrictions:\n\t-Bathing suits must be worn at all times.";
	}

	/**
	 * gets the instance of the singular class
	 * @return the AquaWorldRoom
	 */
	public static AquaWorldRoom getInstance() {
		if (singleInstance == null) {
			singleInstance = new AquaWorldRoom(); 
		}
		
		return singleInstance;
	}
	
	/**
	 * adds to the waitlist
	 * @param partyGoer as a partyGoer
	 */
	public void addWaitList(PartyGoer partyGoer) {
		
		waitList.add(partyGoer);
	
	}
	
	/**
	 * gets the description of the rooms
	 * @return the description as a string
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * adds a new restriction to the room
	 * @param newRestriction the restriction to the room
	 */
	public void addRestrictions(String newRestriction) {
		restrictions = newRestriction;
		
	}
	
	/**
	 * gets the restrictions
	 * @return the restrictions as a string
	 */
	public String getRestrictions() {
		return restrictions;
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
	public PartyGoer reserveRoom(int month, int day, int year, int startTime, int endTime) {
		return null;
	}


}
