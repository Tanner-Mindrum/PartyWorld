package AquaWorld;

import java.util.ArrayList;

/**
 * 
 * @author steven, tymee, Justin, Tanner
 *
 * This class is the small party room that holds the waitlist and description
 */
public class smallPartyRoom extends PartyRoom {
	private String Description = "Capacity: 30 people\nCost: $150/hr\nIncluded in cost:\n\t-Basic Meal Plan\n\t-Table & Chair Set-up\n"
			+ "Upgrades Available:\n\t-Upgrade Meal Plan\tCost: $(meal plan cost)\n\t-Party favor bags\t Cost: $5 per bag\n\t"
			+ "-Projector\t\tCost: $10/hour\n\t-Party Decorations & set-Up       Cost: $100\n\t"
			+ "     Themes: Hawaiian, Sea Life, Jungle, Space, or Modern";
	private ArrayList<PartyGoer> reservationList;
	private ArrayList<PartyGoer> waitList;
	private ArrayList<Integer> reservationDates;
	private ArrayList<Integer> reservationTimes;
	private Integer fullDate;
	
	public smallPartyRoom() {
		fullDate = 0;
		reservationTimes = new ArrayList<>();
		reservationDates = new ArrayList<>();
		waitList = new ArrayList<PartyGoer>();
		reservationList = new ArrayList<>();
	}

	/**
	 * adds to the waitlist
	 * @param partyGoer to be added to the waitlist
	 */
	public void addWaitlist(PartyGoer partyGoer) {
		waitList.add(partyGoer);
	}
	
	/**
	 * gets the description of the room
	 * @return the description as a String
	 */
	public String getDescription() {
		return Description;
	}
	
	/**
	 * calculates the cost of the room
	 * @return the rooms cost as a double
	 */
	public double calculateCost() {
		return 0;
	}

	@Override
	/**
	 * reserves the room
	 * @return the PartyGoer that reserved the room
	 */
	public PartyGoer reserveRoom(int month, int day, int year, int startTime, int endTime) {

		fullDate = month + day + year;

		//Check date
		if (!reservationDates.contains(fullDate)) {
			reservationList.add()
		}
		reservationDates.add(fullDate);
		System.out.println(startTime);
		System.out.println(endTime);
		reservationTimes.add(startTime);
		reservationTimes.add(endTime);

		return null;
	}

}
